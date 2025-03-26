package com.llf.service;

import com.llf.pojo.Emp;
import com.llf.pojo.EmpExpr;
import com.llf.pojo.EmpQueryParam;
import com.llf.pojo.PageResult;

import java.util.List;

public interface EmpService {

    PageResult page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> list);
}
