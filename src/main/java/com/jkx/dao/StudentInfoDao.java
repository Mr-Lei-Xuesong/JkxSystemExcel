package com.jkx.dao;

import cn.hutool.json.JSONObject;
import com.jkx.common.form.StudentQueryForm;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lx
 */
@Mapper
@Repository
public interface StudentInfoDao {

    /**
     * 获取全部
     * @return 列表
     */
    List<Map<String, String>> getAll();

    /**
     * 保存学生信息
     * @param data 数据
     * @param sortCol 插入列排序
     * @return 保存条数
     */
    int saveAll(@Param("data") List<Map<String, Object>> data,
                @Param("sortCol") List<String> sortCol);

    /**
     * 通过id获取学生信息
     * @param id 学生id
     * @return 学生信息集合
     */
    Map<String, String> queryById(@Param("id") String id);

    /**
     * 多条件查询
     * @param form 查询条件表单
     * @return 学生数据
     */
    List<Map<String, String>> mulQuery(StudentQueryForm form);

    /**
     * 获取下载的数据
     * @param colName 字段名
     * @return  List<Map<String, String>>
     */
    List<Map<String, String>> downByColName(List<String> colName);

    /**
     * 删除学生信息通过id
     * @param id id
     * @return 删除条数
     */
    @Delete("delete from student_info where id = #{id}")
    int delStudentInfo(@Param("id") int id);

    /**
     * 批量删除
     * @param ids id列表
     * @return 影响条数
     */
    int delSomeStudentInfo(@Param("ids") List<String> ids);


    /**
     * 插入一条学生信息
     * @param data 学生信息
     * @param sortCol 插入列的顺序
     * @return 影响条数
     */
    int saveOne(@Param("data") Map<String, Object> data,
                @Param("sortCol") List<String> sortCol);

    /**
     * 修改学生信息
     * @param studentInfo 学生信息
     * @return 是否修改成功 0为不成功，1成功
     */
    int updateStudentInfo(@Param("studentInfo") JSONObject studentInfo);

}
