package com.llf.service;


import com.llf.pojo.ClazzCountOption;
import com.llf.pojo.jobOption;

import java.util.List;
import java.util.Map;


public interface ReportService {


    jobOption getJobNum();

    List<Map<String, Object>> getGenderData();

    ClazzCountOption getStudentCountData();

    List<Map> getStudentDegreeData();
}
