package com.tjetc.dao.impl;

import com.tjetc.dao.ClockDAO;
import com.tjetc.domain.Clock;
import com.tjetc.util.DButil;
import com.tjetc.util.TimeUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ClockDAOImpl implements ClockDAO {
    Connection conn = null;

    @Override
    public boolean insert(String... s) {
        try {
            conn = DButil.getConnection();
            Timestamp timestamp = null;
            long before = TimeUtil.getTodayTime(7, 0, 0);
            long after = TimeUtil.getTodayTime(9, 0, 0);
            int update = 0;
            if (Long.parseLong(s[2]) > before && Long.parseLong(s[2]) < after) {
                timestamp = new Timestamp(Long.parseLong(s[2]));
                update = DButil.update(conn, "insert into clock values(0,?,?,?)", s[0], s[1], timestamp);
            }
            if (update > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteArray(String[] idArray) {
        StringBuilder sql = new StringBuilder("delete from clock where id in (");
        for (String s : idArray) {
            sql.append(s).append(",");
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 1));
        sql.append(")");
        try {
            conn = DButil.getConnection();
            int i = DButil.update(conn, sql.toString());
            if (i > 0) return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateByid(String... s) {
        try {
            conn = DButil.getConnection();
            String t = s[3].replace("T", " ");
            int update = DButil.update(conn, "update clock set uid=?,info=?,ctime=? where id=?", s[1], s[2], t,s[0]);
            if (update > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Clock findById(String id) {
        try {
            conn = DButil.getConnection();
            return DButil.query(conn, Clock.class, "select * from clock where id=?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Clock> findAll() {
        List<Clock> clocks = new ArrayList<>();
        try {
            conn = DButil.getConnection();
            clocks = DButil.queryList(conn, Clock.class, "select * from clock");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clocks;
    }
}
