package com.jkx.service.impl;

import com.jkx.dao.ModDatabaseDao;
import com.jkx.service.ModDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * @author Mr zhang
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ModDatabaseServiceImpl implements ModDatabaseService {

    @Autowired
    ModDatabaseDao modDatabaseDao;

    /**
     * 在学生信息库中插入字段，更新映射表
     * @param colName 数据库字段名
     * @param databaseType 数据库类型
     * @param colNum 类型大小
     * @param colComment 类型注释
     * @return 总影响条数
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addCol(String colName, String databaseType, String colNum,
                      String colComment, String excelName, String javaType,
                      Boolean required, Object o) {
        int result = modDatabaseDao.addCol(colName, databaseType, colNum, colComment, required, o);
        int result1 = modDatabaseDao.addMapper(excelName, colName, javaType);

        if (result != 0 && result1 != 0) {
            return result+result1;
        }
        return 0;
    }

    /**
     * 在学生信息库中删除字段，更新映射表
     * @param colName 列名
     * @return 总影响条数
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteCol(String colName) {
        int i = modDatabaseDao.deleteCol(colName);
        int i1 = modDatabaseDao.deleteMapper(colName);
        if (i != 0 && i1 != 0) {
            return i+i1;
        }
        return 0;
    }

    /**
     * 查询映射表的数据库字段
     * @return List<Map<String, String>>
     */
    @Override
    public List<Map<String, String>> listColumn() {
        return modDatabaseDao.listColumn();
    }

}
