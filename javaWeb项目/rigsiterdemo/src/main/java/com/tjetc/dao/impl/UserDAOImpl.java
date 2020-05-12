package com.tjetc.dao.impl;

import com.tjetc.dao.UserDAO;
import com.tjetc.domain.User;
import com.tjetc.util.DButil;
import com.tjetc.util.MD5Utils;
import sun.security.provider.MD5;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

public class UserDAOImpl implements UserDAO {
    private Connection conn ;
    @Override
    public boolean findbyu(String username) {
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
    public boolean insert(User user) {
        boolean flag = false;
        try {
            this.conn=DButil.getConnection();
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
    public User findbyup(String username, String password) {
        User query = null;
        try {
            this.conn= DButil.getConnection();
            query = DButil.query(this.conn, User.class,
                    "select * from user where username = ? and password = ? ",
                    username,password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public String reset(String uid) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append((char)(random.nextInt(94)+33));
        }
        boolean flag = false;
        try {
            conn = DButil.getConnection();
            int update = DButil.update(conn, "UPDATE user set `password`=? where user.id=?", MD5Utils.getMD5(str.toString()), uid);
            if(update>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (flag){
            return str.toString();
        }
        return null;
    }
}
