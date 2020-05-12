package com.jd.dao;

import com.jd.domain.User;

public interface UserDao {
    boolean insert(User user);
    User findById(int id);
    boolean findByUsername(String username);
    User findByUsernameAndPassword(String username,String password);
}
