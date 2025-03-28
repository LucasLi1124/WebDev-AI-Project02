package com.llf.service;

import com.llf.pojo.Clazz;
import com.llf.pojo.ClazzQueryParam;
import com.llf.pojo.PageResult;

import java.util.List;

public interface ClazzService {


    PageResult search(ClazzQueryParam clazzQueryParam);

    void add(Clazz clazz);

    Clazz searchById(Integer id);

    void revise(Clazz clazz);

    void delete(Clazz id);

    List<Clazz> All();
}
