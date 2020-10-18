package com.jkx.service.impl;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jkx.common.form.StudentQueryForm;
import com.jkx.dao.StudentInfoDao;
import com.jkx.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Mr zhang
 */

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
            if (!"".equals(col)){
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
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                map.put(entry.getKey(), "");
            }
            if ("".equals(entry.getKey())) {
                continue;
            }
            // 获取字段对应的类型
            // 如果是 java.util.Date 类型，并且没有值，就设置为当前日期
            boolean judgeTime = "java.util.Date".equals(entry.getKey())
                    && StringUtils.isBlank((CharSequence) entry.getValue());
            if (judgeTime) {
                LocalDate localDate = LocalDate.now();
                map.put(entry.getKey(), localDate);
            }
        }
        // 过滤 key 为null的值
        map = map.entrySet().stream()
                .filter((e) -> !StringUtils.isBlank(e.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        // 遍历map 把值为null的修改为""
        // Map<String, Object> filter = ExcelTypeUtils.filter(map, databaseType);
        // 处理映射
        // 把key为null的过滤掉，并写入list
        Set<String> columns = map.keySet();
        List<String> sortCol = new ArrayList<>(50);
        for (String col: columns) {
            if (!"".equals(col)){
                sortCol.add(col);
            }
        }
        return studentInfoDao.saveOne(map, sortCol);
    }

    @Override
    public int updateStudentInfo(JSONObject studentInfo) {
        return studentInfoDao.updateStudentInfo(studentInfo);
    }


}
