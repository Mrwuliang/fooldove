package com.Test;

import com.bean.User;
import com.configuration.SpringConfiguration;
import com.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
//@ContextConfiguration(name = "applicationContext.xml")
public class Test {
        @Autowired
        private UserService userDao;

        @org.junit.Test
        public void test1(){
            List<User> insert = userDao.insert();
            System.out.println(insert);
        }

}
