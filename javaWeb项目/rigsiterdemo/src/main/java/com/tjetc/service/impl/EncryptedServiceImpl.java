package com.tjetc.service.impl;

import com.tjetc.dao.EncryptedDao;
import com.tjetc.dao.impl.EncryptedDaoImpl;
import com.tjetc.domain.Encrypted;
import com.tjetc.service.EncryptedService;

import java.util.List;

public class EncryptedServiceImpl implements EncryptedService {
    EncryptedDao ed = new EncryptedDaoImpl();
    @Override
    public List<Encrypted> findByUsername(String username) {
        return ed.findByUsername(username);
    }
}
