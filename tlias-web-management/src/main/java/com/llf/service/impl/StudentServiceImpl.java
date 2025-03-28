package com.llf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.llf.mapper.StudentMapper;
import com.llf.pojo.PageResult;
import com.llf.pojo.Student;
import com.llf.pojo.StudentQueryParam;
import com.llf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult search(StudentQueryParam studentQueryParam) {
        //设置分页参数
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());


        //执行查询
        List<Student> list = studentMapper.list(studentQueryParam);
        Page<Student> p = (Page<Student>) list;


        //解析查询结果，并封装
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }

    @Override
    public void add(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.add(student);
    }

    @Override
    public Student searchById(Integer id) {
        return studentMapper.searchById(id);
    }

    @Override
    public void revise(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.revise(student);

    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.delete(ids);
    }

    @Override
    public void violation(Integer id, Integer score) {
        studentMapper.violation(id,score);
    }


}
