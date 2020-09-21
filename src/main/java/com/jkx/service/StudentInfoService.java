package com.jkx.service;

import java.util.List;
import java.util.Map;

public interface StudentInfoService {

    /**
     * 获取所有学生信息
     * @return 学生信息集合
     */
    List<Map<String, String>> getAll();

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
     * @return 是否插入 1:成功， 0:失败
     */
    int saveOne(Map<String, Object> map,
                Map<String, String> mapper,
                Map<String, String> databaseType);

}
