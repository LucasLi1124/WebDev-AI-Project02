package com.llf.service;

import com.llf.pojo.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface EmpService {

    PageResult page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> list);

    Emp genName(Integer id);

    void updateEmpByID(Emp emp);


}
