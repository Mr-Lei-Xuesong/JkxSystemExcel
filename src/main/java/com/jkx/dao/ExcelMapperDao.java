package com.jkx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * excel映射表
 */

@Mapper
@Repository
public interface ExcelMapperDao {

    List<Map<String,String>> getExcelMapper();

}
