package com.jkx.service;

import java.util.List;
import java.util.Map;

public interface StudentInfoService {

    /**
     * 获取所有学生信息
     * @return
     */
    List<Map<String, String>> getAll();

    int saveAll(List<Map<String, Object>> data,
                Map<String, String> mapper);

    int delStudentInfo(int id);

    int delSomeStudentInfo(List<String> ids);

    int saveOne(Map<String, Object> map,
                Map<String, String> mapper,
                Map<String, String> databaseType);

}
