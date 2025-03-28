package com.llf.mapper;

import com.llf.pojo.Clazz;
import com.llf.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {

    public List<Clazz> list(ClazzQueryParam clazzQueryParam);

    void add(Clazz clazz);

    @Select("SELECT clazz.* from clazz where id = #{id} ")
    Clazz searchById(Integer id);

    void revise(Clazz clazz);

    void delete(Clazz id);
@Select("SELECT * from clazz")
    List<Clazz> All();

    List<Map<String, Object>> countClassData();


//    @Options
//    (useGeneratedKeys = true, keyProperty = "id")
//    @Insert("insert into clazz(name, room, begin_date, end_date, master_id, subject,create_time, update_time)" +
//            "values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId},#{subject},#{createTime},#{updateTime})")
//
//    void insert(Clazz clazz);
}
