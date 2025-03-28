package com.llf.controller;

import com.llf.pojo.ClazzCountOption;
import com.llf.pojo.Result;
import com.llf.pojo.jobOption;
import com.llf.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/report")
@RestController
@Slf4j
public class ReportController {

    @Autowired
    private ReportService reportService;


    @GetMapping("/empJobData")
    public Result getjobs() {
        log.info("查询所有职位: ");
        jobOption jobOption = reportService.getJobNum();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result genderData() {
        log.info("查询所有性别: ");
        List<Map<String, Object>> genderList = reportService.getGenderData();
        return Result.success(genderList);
    }

    @GetMapping("/studentDegreeData")
    public Result studentDegree() {
        log.info("查询所有学生学历: ");
        List<Map> dataList = reportService.getStudentDegreeData();
        return Result.success(dataList);

    }

    @GetMapping("/studentCountData")
    public Result stuCount() {
        log.info("查询所有班级人数: ");
        ClazzCountOption classOption = reportService.getStudentCountData();
        return Result.success(classOption);

    }
}
