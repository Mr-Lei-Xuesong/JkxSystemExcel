package com.jkx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * excel映射表
 * @author lx
 */
@Mapper
@Repository
public interface ExcelMapperDao {

    /**
     * 查询数据库与excel对应的字段名
     * @return map
     */
    List<Map<String,String>> getExcelMapper();

    /**
     * 查询excel字段对应的java类型
     * @return map
     */
    List<Map<String,String>> getType();

}
