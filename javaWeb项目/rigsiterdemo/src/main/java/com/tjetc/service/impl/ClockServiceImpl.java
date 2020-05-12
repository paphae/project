package com.tjetc.service.impl;

import com.tjetc.dao.ClockDAO;
import com.tjetc.dao.impl.ClockDAOImpl;
import com.tjetc.domain.Clock;
import com.tjetc.service.ClockService;

import java.util.List;

public class ClockServiceImpl implements ClockService {
    ClockDAO cd = new ClockDAOImpl();
    @Override
    public boolean insert(String... s) {
        return cd.insert(s);
    }

    @Override
    public boolean deleteArray(String[] idArray) {
        return cd.deleteArray(idArray);
    }

    @Override
    public boolean updateByid(String... s) {
        return cd.updateByid(s);
    }

    @Override
    public Clock findById(String id) {
       return cd.findById(id);
    }

    @Override
    public List<Clock> findAll() {
        return cd.findAll();
    }
}
