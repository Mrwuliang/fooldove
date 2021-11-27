package com.dao;

import com.bean.Province;
import com.bean.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

    @Resource(name = "jdbcTemplates")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> insert() {
        String sql = "select * from users";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public Integer find(String name) {
        String sql = "select count(*) from users where name=?";
        Integer update = jdbcTemplate.queryForObject(sql, Integer.class, name);
        return update;
    }

    @Override
    public List<Province> findProvince() {
        String sql = "select * from province";
        List<Province> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return query;
    }
}
