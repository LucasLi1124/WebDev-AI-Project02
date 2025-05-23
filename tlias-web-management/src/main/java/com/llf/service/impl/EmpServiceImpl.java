package com.llf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.llf.mapper.EmpExprMapper;
import com.llf.mapper.EmpMapper;
import com.llf.pojo.*;
import com.llf.service.EmpService;
import com.llf.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Transactional
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        // 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        //执行查询
        List<Emp> list = empMapper.list(empQueryParam);
        //解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) list;

        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Override
    public void save(Emp emp) {
        //保存基本信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
        //保存工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            //遍历集合，为empId赋值
            exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);

        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> list) {
        empMapper.deleteByIds(list);

        empExprMapper.deleteByEmpIds(list);
    }

    @Override
    public Emp genName(Integer id) {
        return empMapper.getName(id);

    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateEmpByID(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public List<Emp> Allinfo() {
        return empMapper.Allinfo();
    }

    @Override
    public LoginInfo login(Emp emp) {
       Emp e  =  empMapper.loginByUserNameAndPassWord(emp);
       if (e != null) {
           log.info("登录信息：{}", e);
           // 生成JWT令牌
           Map<String, Object> claims = new HashMap<>();
           claims.put("id", e.getId());
           claims.put("username", e.getUsername());
           String jwt = JwtUtils.generateToken(claims);
           return new LoginInfo(e.getId(), e.getUsername(), e.getName(), jwt);
       }
       return null;


    }



}
