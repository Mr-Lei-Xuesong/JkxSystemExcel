package com.jkx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lx
 */
@SpringBootApplication
@EnableTransactionManagement
public class JkxSystemExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(JkxSystemExcelApplication.class, args);
    }

}
