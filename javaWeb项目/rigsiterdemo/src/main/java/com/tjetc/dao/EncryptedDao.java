package com.tjetc.dao;

import com.tjetc.domain.Encrypted;

import java.util.List;

public interface EncryptedDao {
    List<Encrypted> findByUsername(String username);
}
