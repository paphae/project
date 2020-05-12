package com.tjetc.dao;



import com.tjetc.domain.Clock;

import java.util.List;

public interface ClockDAO {
    boolean insert(String...s);
    public boolean deleteArray(String[] idArray);
    public boolean updateByid(String...s);
    public List<Clock> findAll();
    public Clock findById(String id);
}
