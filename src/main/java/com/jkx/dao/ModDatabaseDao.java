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
     * @param colName 数据库字段名字
     * @param colType 数据字段类型
     * @param colNum 数据库字段大小
     * @param colComment 数据库字段注释
     * @param required 是否需要大小
     * @param o 默认值
     * @return 影响条数
     */
    int addCol(@Param("colName") String colName, @Param("colType") String colType,
               @Param("colNum") String colNum, @Param("colComment") String colComment,
               @Param("required") Boolean required,@Param("o") Object o);

    /**
     * 在映射表，添加数据
     * @param excelName excel名字
     * @param colName 数据库字段名
     * @param javaType 数据库类型对应的java类型
     * @return 影响条数
     */
    int addMapper(@Param("excelName") String excelName,
                  @Param("colName") String colName,
                  @Param("javaType") String javaType);

    /**
     * 删除表字段
     * @param colName
     * @return 影响条数
     */
    int deleteCol(@Param("colName") String colName);
    /**
     * 删除隐射表对应数据
     * @param colName
     * @return 影响条数
     */
    int deleteMapper(@Param("colName") String colName);
}
