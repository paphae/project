package com.tjetc.dao.impl;

import com.tjetc.dao.EncryptedDao;
import com.tjetc.domain.Encrypted;
import com.tjetc.util.DButil;

import java.sql.Connection;
import java.util.List;

public class EncryptedDaoImpl implements EncryptedDao {
    Connection conn = null;
    @Override
    public List<Encrypted> findByUsername(String username) {
        List<Encrypted> query = null;
        try {
            this.conn= DButil.getConnection();
            query = DButil.queryList(this.conn, Encrypted.class,
                    "SELECT e.* FROM `encrypted` e,user u where e.uid=u.id and u.username = ?",
                    username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return query;
    }
}
