package com.service;

import com.bean.Province;
import com.bean.User;

import java.util.List;

public interface UserService {
    List<User> insert();
    Integer find(String name);
    List<Province> findProvince();
}
