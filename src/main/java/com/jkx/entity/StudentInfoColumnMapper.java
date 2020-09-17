package com.jkx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2020-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("student_info_column_mapper")
public class StudentInfoColumnMapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * excel字段名
     */
    @TableField("excel_name")
    private String excelName;

    /**
     * 数据库字段名
     */
    @TableField("database_name")
    private String databaseName;


}
