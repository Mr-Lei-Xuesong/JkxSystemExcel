package com.jkx.service;

import org.apache.ibatis.annotations.Param;

public interface ModDatabaseService {

    int addCol(String colName,
               String colType,
               String colNum,
               String colComment,
               String excelName,
               String javaType);

    int deleteCol(String colName);

}
