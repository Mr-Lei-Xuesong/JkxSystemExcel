package com.jkx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StudentInfoDao {

    @Select("select * from student_info")
    List<Map<String, String>> getAll();
}
