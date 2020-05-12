package com.tjetc.dao;

import com.tjetc.domain.User;

public interface UserDAO {
    public boolean findbyu(String username);
    public boolean insert(User user);
    public User findbyup(String username,String password);
    public String reset(String uid);
}
