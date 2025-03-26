package com.llf.mapper;

import com.llf.pojo.Emp;
import com.llf.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {


    //@Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id order by e.update_time desc ")
    public List<Emp> list(EmpQueryParam empQueryParam);

    @Options
            (useGeneratedKeys = true, keyProperty = "id")// 获取生成的主键---主键返回
    @Insert
            ("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
                    "values (#{username},#{name},#{gender},#{phone},#{job},#{salary}, #{image},#{entryDate},#{deptId},#{createTime}, #{updateTime})")
    void insert(Emp emp);


    void deleteByIds(List<Integer> ids);
}
