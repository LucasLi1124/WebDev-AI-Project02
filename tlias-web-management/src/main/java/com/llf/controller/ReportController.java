package com.llf.controller;

import com.llf.pojo.Emp;
import com.llf.pojo.Result;
import com.llf.pojo.jobOption;
import com.llf.service.EmpService;
import com.llf.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.ResolutionSyntax;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    public Result genderData(){
        log.info("查询所有性别: ");
        List<Map<String, Object>> genderList = reportService.getGenderData();
        return Result.success(genderList);
    }
}
