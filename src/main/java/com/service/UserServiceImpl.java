package com.service;

import com.bean.Province;
import com.bean.User;
import com.dao.UserDAO;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDAO userDao;

    @Override
    public List<User> insert() {
        return userDao.insert();
    }

    @Override
    public Integer find(String name) {
        return userDao.find(name);
    }

    @Override
    public List<Province> findProvince() {
        return userDao.findProvince();
    }
}
