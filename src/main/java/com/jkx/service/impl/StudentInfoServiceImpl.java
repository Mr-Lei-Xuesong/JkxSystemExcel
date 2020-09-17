package com.jkx.service.impl;

import com.jkx.dao.StudentInfoDao;
import com.jkx.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    StudentInfoDao studentInfoDao;

    @Override
    public List<Map<String, String>> getAll() {
        return studentInfoDao.getAll();
    }
}
