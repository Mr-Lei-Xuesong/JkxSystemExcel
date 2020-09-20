package com.jkx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Mr zhang
 */
@Mapper
@Repository
public interface ModDatabaseDao {

    /**
     * 给数据库添加字段
     * @param colName
     * @param colType
     * @param colNum
     * @param colComment
     * @return 影响条数
     */
    int addCol(@Param("colName") String colName,
               @Param("colType") String colType,
               @Param("colNum") String colNum,
               @Param("colComment") String colComment);

    /**
     * 在映射表，添加数据
     * @param excelName
     * @param colName
     * @param javaType
     * @return
     */
    int addMapper(@Param("excelName") String excelName,
                  @Param("colName") String colName,
                  @Param("javaType") String javaType);

    /**
     * 删除表字段
     * @param colName
     * @return
     */
    int deleteCol(@Param("colName") String colName);
    /**
     * 删除隐射表对应数据
     * @param colName
     * @return
     */
    int deleteMapper(@Param("colName") String colName);
}
