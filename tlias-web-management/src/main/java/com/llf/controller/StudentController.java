package com.llf.controller;

import com.llf.pojo.PageResult;
import com.llf.pojo.Result;
import com.llf.pojo.Student;
import com.llf.pojo.StudentQueryParam;
import com.llf.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping
    public Result search(StudentQueryParam studentQueryParam) {
        log.info("查询学生信息：{}", studentQueryParam);
        PageResult<Student> pageResult =  studentService.search(studentQueryParam);
        return Result.success(pageResult);
    }
    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("添加学生信息：{}", student);
        studentService.add(student);
        return Result.success();

    }
    @GetMapping("/{id}")
    public Result sid(@PathVariable Integer id) {
       Student s =  studentService.searchById(id);
        return Result.success(s);
    }
    @PutMapping
    public Result revise(@RequestBody Student student) {
        log.info("修改学生信息：{}", student);
        studentService.revise(student);
        return Result.success();
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除学生信息：{}", ids);
        studentService.delete(ids);
        return Result.success();
    }
    @PutMapping("/violation/{id}/{score}")
    public Result viola(@PathVariable Integer id, @PathVariable Integer score){
        log.info("修改学生信息和分数：{}，{}", id, score);
        studentService.violation(id,score);
        return Result.success();
    }
}
