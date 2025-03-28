package com.llf.controller;

import com.llf.pojo.Clazz;
import com.llf.pojo.ClazzQueryParam;
import com.llf.pojo.PageResult;
import com.llf.pojo.Result;
import com.llf.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
@Slf4j
public class ClazzController {
    @Autowired
    private ClazzService clazzService;


    @GetMapping
    public Result search(ClazzQueryParam clazzQueryParam) {
        log.info("查询班级信息：{}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.search(clazzQueryParam);
      return Result.success(pageResult);

    }
    @PostMapping
    public Result add(@RequestBody Clazz clazz) {
        log.info("添加班级信息：{}", clazz);
        clazzService.add(clazz);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result search(@PathVariable Integer id){
        log.info("根据ID查询班级信息：{}", id);
        Clazz list =  clazzService.searchById(id);
        return Result.success(list);
    }
    @PutMapping
    public Result revise(@RequestBody Clazz clazz){
        log.info("修改班级信息：{}", clazz);
        clazzService.revise(clazz);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Clazz id){
        log.info("删除班级信息：{}", id);
        clazzService.delete(id);
        return Result.success();
    }
    @GetMapping("/list")
    public Result All(){
        log.info("查询所有班级信息");
        List<Clazz> list = clazzService.All();
        return Result.success(list);
    }

}
