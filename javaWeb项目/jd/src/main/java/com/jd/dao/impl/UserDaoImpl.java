package com.jd.dao.impl;


import com.jd.dao.UserDao;
import com.jd.domain.User;
import com.jd.util.DButil;

import java.sql.Connection;

public class UserDaoImpl implements UserDao {
    Connection conn = null;
    @Override
    public boolean insert(User user) {
        boolean flag = false;
        try {
            this.conn= DButil.getConnection();
            int update = DButil.update(this.conn,
                    "insert into user(username,password) values(?,?)",
                    user.getUsername(), user.getPassword());
            if(update>0){
                flag =true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User findById(int id) {
        try {
            this.conn= DButil.getConnection();
            return DButil.query(this.conn, User.class,
                    "select * from user where id = ? ",
                    id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean findByUsername(String username) {
        boolean flag = false;
        try {
            this.conn= DButil.getConnection();
            User query = DButil.query(this.conn, User.class,
                    "select * from user where username = ? ",
                    username);
            if(query!=null){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        boolean flag = false;
        try {
            this.conn= DButil.getConnection();
            return DButil.query(this.conn, User.class,
                    "select * from user where username = ? and password = ? ",
                    username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
