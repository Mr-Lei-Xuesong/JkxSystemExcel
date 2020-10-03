package com.jkx.service.impl;

import cn.hutool.json.JSONObject;
import com.jkx.common.form.StudentQueryForm;
import com.jkx.common.util.ExcelTypeUtils;
import com.jkx.dao.StudentInfoDao;
import com.jkx.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * @return 学生信息集合
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Map<String, String>> getAll() {
        return studentInfoDao.getAll();
    }

    /**
     * 通过id获取学生信息
     * @return 学生信息集合
     */
    @Override
    public Map<String, String> queryById(String id) {
        return studentInfoDao.queryById(id);
    }

    @Override
    public List<Map<String, String>> mulQuery(StudentQueryForm form) {
        return studentInfoDao.mulQuery(form);
    }

    @Override
    public List<Map<String, String>> downByColName(List<String> colName) {
        return studentInfoDao.downByColName(colName);
    }

    /**
     * 批量插入学生信息
     * @param data 学生信息
     * @param mapper 映射表；重新排序为跟学生信息表字段一致用于插入
     * @return 保存条数
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
     * @param id 学生id
     * @return 是否成功
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delStudentInfo(int id) {
        return studentInfoDao.delStudentInfo(id);
    }

    /**
     * 批量删除
     * @param ids 学生id集合
     * @return 删除条数
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delSomeStudentInfo(List<String> ids) {
        return studentInfoDao.delSomeStudentInfo(ids);
    }


    /**
     * 插入一条学生信息
     * @param map 学生信息集合
     * @return 是否插入 1:成功， 0:失败
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

    @Override
    public int updateStudentInfo(JSONObject studentInfo) {
        return studentInfoDao.updateStudentInfo(studentInfo);
    }


}
