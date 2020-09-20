package com.jkx.service.impl;

import com.jkx.common.util.ExcelTypeUtils;
import com.jkx.dao.StudentInfoDao;
import com.jkx.service.StudentInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Transactional(rollbackFor = Exception.class)
@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    StudentInfoDao studentInfoDao;

    /**
     * 获取所有学生信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Map<String, String>> getAll() {
        return studentInfoDao.getAll();
    }

    /**
     * 批量插入学生信息
     * @param data
     * @param mapper
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveAll(List<Map<String, Object>> data,
                       Map<String, String> mapper) {
        System.out.println(data);
        // 处理映射
        // 把key遍历，写入list
        Set<String> columns = data.get(0).keySet();
        List<String> sortCol = new ArrayList<>(50);
        for (String col: columns) {
            if (col != "" ){
                sortCol.add(mapper.get(col));
            }
        }

        return studentInfoDao.saveAll(data, sortCol);
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delStudentInfo(int id) {
        return studentInfoDao.delStudentInfo(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delSomeStudentInfo(List<String> ids) {
        return studentInfoDao.delSomeStudentInfo(ids);
    }


    /**
     * 插入一条学生信息
     * @param map
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveOne(Map<String, Object> map,
                       Map<String, String> mapper,
                       Map<String, String> databaseType) {
        // 遍历map 把值为null的修改为""
        Map<String, Object> filter = ExcelTypeUtils.filter(map, databaseType);
        // 处理映射
        // 把key为null的过滤掉，并写入list
        Set<String> columns = filter.keySet();
        List<String> sortCol = new ArrayList<>(50);
        for (String col: columns) {
            if (col != "" ){
                sortCol.add(mapper.get(col));
            }
        }
        return studentInfoDao.saveOne(filter, sortCol);
    }



}
