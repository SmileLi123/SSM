package edu.njust.service.impl;

import edu.njust.entity.Shop;
import edu.njust.mapper.ShopMapper;
import edu.njust.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description ShopServiceImpl
 * @author gy
 **/
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Shop queryByLogin(String name, String password) {
        Shop Shop = new Shop(name,password);
        Shop query = shopMapper.queryByLogin(Shop);
        return query;
    }

    @Override
    public boolean addShop(Shop Shop) {
        int i = shopMapper.addShop(Shop);
        return i==0?true:false;
    }

    @Override
    public boolean updateShop(Shop Shop) {
        int i = shopMapper.updateShop(Shop);
        return i==0?true:false;
    }

    @Override
    public boolean deleteShop(String sname) {
        int i = shopMapper.deleteShop(sname);
        return i==0?true:false;
    }

    @Override
    public Shop queryBySname(String sname) {
        Shop Shop = shopMapper.queryBySname(sname);
        return Shop;
    }
}
