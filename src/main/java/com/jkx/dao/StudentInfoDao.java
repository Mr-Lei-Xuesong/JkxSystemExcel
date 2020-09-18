package com.jkx.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StudentInfoDao {

    @Select("select * from student_info")
    List<Map<String, String>> getAll();

    /**
     * 保存学生信息
     * @return 保存条数
     */
    int saveAll(@Param("data") List<Map<String, Object>> data,
                @Param("mapper") Map<String, String> mapper,
                @Param("sortCol") List<String> sortCol);


    @Delete("delete from student_info where id = #{id}")
    int delStudentInfo(@Param("id") int id);


    int saveOne();
}
