package com.llf.controller;

import com.llf.pojo.Dept;
import com.llf.pojo.Result;

import com.llf.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result result() {
        log.info("查询全部的部门数据");
        List<Dept> depts = deptService.findAll();
        return Result.success(depts);

    }

    @DeleteMapping
    public Result delect(Integer id) {
        //System.out.println("根据ID删除部门" + id);
        log.info("根据ID删除部门: {}", id);
        deptService.DelectById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        //System.out.println("添加部门：" + dept);
        log.info("添加部门: {}", dept);
        deptService.add(dept);
        return Result.success();

    }

    @GetMapping("{id}")
    public Result search(@PathVariable Integer id) {
        //System.out.println("根据ID查询的部门是： " + id);
        log.info("根据ID查询的部门是： {}", id);
        Dept result = deptService.searchById(id);
        return Result.success(result);

    }
    @PutMapping
    public Result update(@RequestBody Dept dept){
        //System.out.println("修改部门：" + dept);
        log.info("修改部门: {}", dept);
        deptService.updateById(dept);
        return Result.success();
    }
}
