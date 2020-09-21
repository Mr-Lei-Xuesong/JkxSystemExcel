package com.jkx.service.impl;

import com.jkx.dao.ModDatabaseDao;
import com.jkx.service.ModDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Mr zhang
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ModDatabaseServiceImpl implements ModDatabaseService {

    @Autowired
    ModDatabaseDao modDatabaseDao;

    /**
     *
     * @param colName
     * @param databaseType
     * @param colNum
     * @param colComment
     * @return 影响条数
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

}
