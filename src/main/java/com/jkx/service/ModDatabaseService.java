package com.jkx.service;


import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ModDatabaseService {

    int addCol(String colName, String colType, String colNum,
               String colComment, String excelName, String javaType,
               Boolean required, Object o);

    int deleteCol(String colName);

    List<Map<String, String>> listColumn();

}
