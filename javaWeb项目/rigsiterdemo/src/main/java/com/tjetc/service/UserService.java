package com.tjetc.service;

import com.tjetc.domain.User;
//业务逻辑层
//调用dao中的方法来完成一项功能。
public interface UserService {
    public boolean rigsiter(User user);
    public User login(String username,String password);
    public boolean findbyu(String username);
    public String reset(String uid);
}
