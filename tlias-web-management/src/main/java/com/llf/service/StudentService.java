package com.llf.service;

import com.llf.pojo.PageResult;
import com.llf.pojo.Student;
import com.llf.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult search(StudentQueryParam studentQueryParam);

    void add(Student student);

    Student searchById(Integer id);

    void revise(Student student);

    void delete(List<Integer> ids);

    void violation(Integer id, Integer score);
}
