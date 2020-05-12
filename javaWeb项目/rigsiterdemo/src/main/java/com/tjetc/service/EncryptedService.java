package com.tjetc.service;

import com.tjetc.domain.Encrypted;

import java.util.List;

public interface EncryptedService {
    List<Encrypted> findByUsername(String username);
}
