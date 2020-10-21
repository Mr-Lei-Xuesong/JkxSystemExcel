package com.jkx.service;

import java.util.List;
import java.util.Map;

/**
 * @author Mr zhang
 */
public interface ModDatabaseService {

    /**
     * 添加数据库列
     * @param colName 列名
     * @param colType 列类型
     * @param colNum 列大小
     * @param colComment 列
     * @param excelName excel列名
     * @param javaType java类型
     * @param required 是否需要列大小
     * @param o 默认值
     * @return 修改数
     */
    int addCol(String colName, String colType, String colNum,
               String colComment, String excelName, String javaType,
               Boolean required, Object o);

    /**
     * 删除列
     * @param colName 列名
     * @return 是否成功
     */
    int deleteCol(String colName);

    List<Map<String, String>> listColumn();

}
