package com.tjetc.service.impl;

import com.tjetc.dao.UserDAO;
import com.tjetc.dao.impl.UserDAOImpl;
import com.tjetc.service.UserService;
import com.tjetc.domain.User;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();
    @Override
    public boolean rigsiter(User user) {
        boolean realflag= false;
        //readflag 真代表注册成功 假代表注册失败。
        boolean flag = userDAO.findbyu(user.getUsername());
        //flag 真 你注册用已存在，假的你注册用户可以注册。
        if (user.getUsername().equals("")||user.getUsername()==null)return false;
        if (user.getPassword().equals("")||user.getPassword()==null)return false;
        if(!flag){
            boolean insert = userDAO.insert(user);
            if(insert){
                realflag=true;
            }

        }
        return  realflag;
    }

    @Override
    public User login(String username, String password) {
        return userDAO.findbyup(username,password);
    }

    @Override
    public boolean findbyu(String username) {
        return userDAO.findbyu(username);
    }

    @Override
    public String reset(String uid) {
        return userDAO.reset(uid);
    }
}
