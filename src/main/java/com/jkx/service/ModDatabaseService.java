package com.jkx.service;


public interface ModDatabaseService {

    int addCol(String colName, String colType, String colNum,
               String colComment, String excelName, String javaType,
               Boolean required, Object o);

    int deleteCol(String colName);

}
