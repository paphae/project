package com.jd.service;

import com.jd.domain.User;

//业务逻辑层
//调用dao中的方法来完成一项功能。
public interface UserService {
    boolean insert(User user);
    User findById(int id);
    boolean findByUsername(String username);
    User findByUsernameAndPassword(String username,String password);
}
