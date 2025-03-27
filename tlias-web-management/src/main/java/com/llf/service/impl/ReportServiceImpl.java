package com.llf.service.impl;

import com.llf.mapper.EmpMapper;
import com.llf.pojo.Emp;
import com.llf.pojo.jobOption;
import com.llf.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;


    @Override
    public jobOption getJobNum() {
        //调用mapper
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new jobOption(jobList,dataList);

    }

    @Override
    public List<Map<String, Object>> getGenderData() {
         return empMapper.countEmpGenderData();

    }
}

