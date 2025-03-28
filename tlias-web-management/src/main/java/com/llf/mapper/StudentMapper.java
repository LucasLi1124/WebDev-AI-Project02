package com.llf.mapper;

import com.llf.pojo.Clazz;
import com.llf.pojo.Student;
import com.llf.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    public List<Student> list(StudentQueryParam studentQueryParam);


    void add(Student student);

    @Select("select * from student where id = #{id}")
    Student searchById(Integer id);

    void revise(Student student);

    void delete(List<Integer> ids);

    @Update("update student set violation_count = violation_count + 1 , violation_score = violation_score + #{score} , update_time = now() where id = #{id}")
    void violation(Integer id, Integer score);


    List<Map<String, Object>> getStudentCount();


    @MapKey("name")
    List<Map> countStudentDegreeData();

    @Select("select count(*) from student where clazz_id = #{id}")
    Integer countByClazzId(Clazz id);

    void insertBatch(List<Student> studentList);

}
