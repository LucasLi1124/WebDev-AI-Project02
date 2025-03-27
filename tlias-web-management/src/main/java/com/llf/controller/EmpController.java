package com.llf.controller;

import com.llf.pojo.*;
import com.llf.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/emps")
@RestController
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;


    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询，当前页码：{}，每页条数：{}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);

    }
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("添加员工：{}", emp);
        empService.save(emp);
        return Result.success();
    }
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> list){
        log.info("删除员工：{}", list);
        empService.delete(list);
        return Result.success();

    }
    @GetMapping("/{id}")
    public Result getName(@PathVariable Integer id){
        log.info("根据id查询员工：{}", id);
        Emp empo =  empService.genName(id);
        return Result.success(empo);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息：{}", emp);
        empService.updateEmpByID(emp);
        return Result.success();
    }


}

