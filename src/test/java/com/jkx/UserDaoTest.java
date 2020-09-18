package com.jkx;

import com.jkx.dao.IUsersDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTest {
    @Autowired
    IUsersDao usersDao;

    @Test
    void findByAccount(){
        System.out.println(usersDao.findByAccount("admin"));

    }
}
