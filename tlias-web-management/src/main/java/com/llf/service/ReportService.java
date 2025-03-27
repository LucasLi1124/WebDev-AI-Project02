package com.llf.service;


import com.llf.pojo.Emp;
import com.llf.pojo.jobOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;


public interface ReportService {


    jobOption getJobNum();

    List<Map<String, Object>> getGenderData();
}
