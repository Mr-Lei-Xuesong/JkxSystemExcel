package com.jkx.service.impl;

import com.jkx.dao.StudentInfoDao;
import com.jkx.service.StudentInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    StudentInfoDao studentInfoDao;

    @Override
    public List<Map<String, String>> getAll() {
        return studentInfoDao.getAll();
    }

    @Override
    public int saveAll(List<Map<String, Object>> data, Map<String, String> mapper) {
        System.out.println(data);
        // 映射排序
        // 根据List<Map..> 把数据库映射字段排序生成list
        Set<String> columns = data.get(0).keySet();
        List<String> sortCol = new ArrayList<>(50);
        int count = 0;
        for (String col: columns) {
            System.out.println(col == "");
            if (col != "" ){
                sortCol.add(mapper.get(col));
                count++;
            }
        }
        System.out.println(sortCol.size());

        return studentInfoDao.saveAll(data, mapper, sortCol);
    }

    @Override
    public int delStudentInfo(@Param("id") int id) {
        return studentInfoDao.delStudentInfo(id);
    }
}
