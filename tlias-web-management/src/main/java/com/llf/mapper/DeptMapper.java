package com.llf.mapper;

import com.llf.pojo.Dept;
import com.llf.pojo.Result;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("Select id, name, create_time, update_time from dept order by update_time DESC")
    List<Dept> findAll();

    @Delete("Delete from dept where id = #{id}")
    void DelectById(Integer id);

    @Insert("insert into dept(name, create_time, update_time) value (#{name} , #{createTime}, #{updateTime})")
    void add(Dept dept);

    @Select("Select id, name, create_time, update_time from dept where id = #{id}")
    Dept searchById(Integer id);

    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void updateById(Dept dept);
}
