package com.jkx.service;

import com.jkx.dao.StudentInfoDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface StudentInfoService {

    /**
     * 获取所有学生信息
     * @return
     */
    List<Map<String, String>> getAll();

    int saveAll(@Param("data") List<Map<String, Object>> data,
                @Param("mapper") Map<String, String> mapper);

    int delStudentInfo(@Param("id") int id);
}
