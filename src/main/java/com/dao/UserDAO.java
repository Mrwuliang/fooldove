package com.dao;

import com.bean.Province;
import com.bean.User;

import java.util.List;

public interface UserDAO {
    List<User> insert();
    Integer find(String name);
    List<Province> findProvince();
}
