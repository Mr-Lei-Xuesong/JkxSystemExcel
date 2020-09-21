package com.jkx.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * 数据库学生信息表字段配置
 * @author Mr zhang
 */
@Configuration
@PropertySource(value = {"classpath:columns-config.properties"})
@ConfigurationProperties(prefix = "columns")
@Data
public class ColumnsConfig {
    /**
     * java类型映射
     * { str : java.lang.String }
     */
    private Map<String, String> columnJavaType;
    /**
     *  数据库字段大小必要性映射
     * { str : true }
     */
    private Map<String, Boolean> sizeRequired;

    /**
     *  数据库字段类型映射
     * { str : varchar }
     */
    private Map<String, String> columnDatabaseType;

    /**
     * 数据库字段的默认值
     * { str : "" }
     */
    private Map<String, Object> columnDefault;

}
