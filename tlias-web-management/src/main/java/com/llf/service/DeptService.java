package com.llf.service;

import com.llf.mapper.DeptMapper;
import com.llf.pojo.Dept;
import com.llf.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void DelectById(Integer id);

    void add(Dept dept);


    Dept searchById(Integer id);

    void updateById(Dept dept);
}
