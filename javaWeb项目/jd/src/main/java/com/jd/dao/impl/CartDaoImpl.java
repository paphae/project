package com.jd.dao.impl;

import com.jd.dao.CartDao;
import com.jd.domain.Cart;
import com.jd.util.DButil;

import java.sql.Connection;

public class CartDaoImpl implements CartDao {
    Connection conn = null;
    @Override
    public boolean insert(Cart cart) {
        boolean flag = false;
        try {
            this.conn= DButil.getConnection();
            int update = DButil.update(this.conn,
                    "insert into cart values(?,?,?,?)",
                    0,cart.getUid(),cart.getPid(),cart.getNumber());
            if(update>0){
                flag =true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
