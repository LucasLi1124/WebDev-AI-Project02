package com.llf.service.impl;

import com.llf.mapper.DeptMapper;
import com.llf.pojo.Dept;
import com.llf.pojo.Result;
import com.llf.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void DelectById(Integer id) {
        deptMapper.DelectById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept searchById(Integer id) {
        return deptMapper.searchById(id);
    }

    @Override
    public void updateById(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateById(dept);

    }


}
