package com.jd.service.impl;


import com.jd.dao.UserDao;
import com.jd.dao.impl.UserDaoImpl;
import com.jd.domain.User;
import com.jd.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao ud = new UserDaoImpl();

    @Override
    public boolean insert(User user) {
        return ud.insert(user);
    }

    @Override
    public User findById(int id) {
        return ud.findById(id);
    }

    @Override
    public boolean findByUsername(String username) {
        return ud.findByUsername(username);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return ud.findByUsernameAndPassword(username,password);
    }
}
