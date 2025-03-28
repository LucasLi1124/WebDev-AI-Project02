package com.llf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.llf.mapper.ClazzMapper;
import com.llf.mapper.StudentMapper;
import com.llf.pojo.Clazz;
import com.llf.pojo.ClazzQueryParam;
import com.llf.pojo.PageResult;
import com.llf.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.llf.exception.BusinessException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public PageResult<Clazz> search(ClazzQueryParam clazzQueryParam) {

        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());

        List<Clazz> list = clazzMapper.list(clazzQueryParam);
        Page<Clazz> c = (Page<Clazz>) list;
        return new PageResult<Clazz>(c.getTotal(), c.getResult());
    }

    @Override
    public void add(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());

        clazzMapper.add(clazz);
    }

    @Override
    public Clazz searchById(Integer id) {
        return clazzMapper.searchById(id);
    }

    @Override
    public void revise(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.revise(clazz);
    }

    @Override
    public void delete(Clazz id) {
        Integer count = studentMapper.countByClazzId(id);
        if(count > 0){
            throw new BusinessException("班级下有学员, 不能直接删除~");
        }
//        2. 如果没有, 再删除班级信息
        clazzMapper.delete(id);
    }

    @Override
    public List<Clazz> All() {
        return clazzMapper.All();

    }
}
