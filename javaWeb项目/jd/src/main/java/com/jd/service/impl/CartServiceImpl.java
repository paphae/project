package com.jd.service.impl;

import com.jd.dao.CartDao;
import com.jd.dao.impl.CartDaoImpl;
import com.jd.domain.Cart;
import com.jd.service.CartService;

public class CartServiceImpl implements CartService {
    CartDao cd = new CartDaoImpl();
    @Override
    public boolean insert(Cart cart) {
        return cd.insert(cart);
    }
}
