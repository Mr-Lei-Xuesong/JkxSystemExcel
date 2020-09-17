package com.jkx.service;

import com.jkx.dao.StudentInfoDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface StudentInfoService {

    /**
     * 获取所有学生信息
     * @return
     */
    List<Map<String, String>> getAll();
}
