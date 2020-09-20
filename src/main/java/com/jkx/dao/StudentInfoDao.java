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

    List<Map<String, String>> getAll();

    /**
     * 保存学生信息
     * @return 保存条数
     */
    int saveAll(@Param("data") List<Map<String, Object>> data,
                @Param("sortCol") List<String> sortCol);


    /**
     * 删除学生信息通过id
     * @param id
     * @return
     */
    @Delete("delete from student_info where id = #{id}")
    int delStudentInfo(@Param("id") int id);

    /**
     * 批量删除
     * @param ids id列表
     * @return
     */
    int delSomeStudentInfo(@Param("ids") List<String> ids);


    /**
     * 插入一条学生信息
     * @param data
     * @return
     */
    int saveOne(@Param("data") Map<String, Object> data,
                @Param("sortCol") List<String> sortCol);

}
