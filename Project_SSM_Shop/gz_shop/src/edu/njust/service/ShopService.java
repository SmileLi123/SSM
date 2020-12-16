package edu.njust.service;

import edu.njust.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description: ShopService
 * @author gy
 **/
public interface ShopService {

    public Shop queryByLogin(String name,String password);
    public boolean addShop(Shop Shop);
    public boolean updateShop(Shop Shop);
    public boolean deleteShop(String sname);
    public Shop queryBySname(String sname);
}
