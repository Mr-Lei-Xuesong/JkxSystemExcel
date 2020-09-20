package com.jkx;

import com.jkx.config.ColumnsConfig;
import com.jkx.dao.IUsersDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Map;

@SpringBootTest
public class UserDaoTest {
    @Autowired
    IUsersDao usersDao;

    @Autowired
    ColumnsConfig columnsConfig;

    @Test
    void findByAccount(){
        System.out.println(columnsConfig);
    }
}
