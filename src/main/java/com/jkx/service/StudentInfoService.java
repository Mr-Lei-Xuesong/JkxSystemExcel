package com.jkx.service;

import cn.hutool.json.JSONObject;
import com.jkx.common.form.StudentQueryForm;

import java.util.List;
import java.util.Map;

/**
 * @author Mr zhang
 */
public interface StudentInfoService {

    /**
     * 获取所有学生信息
     * @return 学生信息集合
     */
    List<Map<String, String>> getAll();

    /**
     * 通过id获取学生信息
     * @param id 学生id
     * @return 学生信息集合
     */
    Map<String, String> queryById(String id);

    /**
     * 多条件查询
     * @param form 查询条件表单
     * @return 学生数据
     */
    List<Map<String, String>> mulQuery(StudentQueryForm form);

    /**
     * 获取下载的数据
     * @param colName 列名
     * @return  List<Map<String, String>>
     */
    List<Map<String, String>> downByColName(List<String> colName);

    /**
     * 批量插入学生信息
     * @param data 学生信息
     * @param mapper 映射表；重新排序为跟学生信息表字段一致用于插入
     * @return 保存条数
     */
    int saveAll(List<Map<String, Object>> data,
                Map<String, String> mapper);

    /**
     * 删除学生信息
     * @param id 学生id
     * @return 是否成功
     */
    int delStudentInfo(int id);

    /**
     * 批量删除
     * @param ids 学生id集合
     * @return 删除条数
     */
    int delSomeStudentInfo(List<String> ids);

    /**
     * 插入一条学生信息
     * @param map 学生信息集合
     * @param databaseType 数据库类型
     * @param mapper 映射
     * @return 是否插入 1:成功， 0:失败
     */
    int saveOne(Map<String, Object> map,
                Map<String, String> mapper,
                Map<String, String> databaseType);

    /**
     * 修改学生信息
     * @param studentInfo 学生信息
     * @return 是否修改成功 0为不成功，1成功
     */
    int updateStudentInfo(JSONObject studentInfo);

}
