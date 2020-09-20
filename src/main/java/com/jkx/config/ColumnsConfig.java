package com.jkx.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * 数据库血神信息表字段配置
 * @author Mr zhang
 */
@Configuration
@PropertySource(value = {"classpath:columns-config.yaml"})
@ConfigurationProperties(prefix = "columns")
@Data
public class ColumnsConfig {
    private Map<String, String> columnsType;

}
