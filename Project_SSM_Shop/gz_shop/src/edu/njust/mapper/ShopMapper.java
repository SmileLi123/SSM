package edu.njust.mapper;

import edu.njust.entity.Shop;

import java.util.List;

/**
 * @description ShopMapper
 * @author gy 
 **/
public interface ShopMapper {

    public Shop queryByLogin(Shop Shop);
    public int addShop(Shop Shop);
    public int updateShop(Shop Shop);
    public int deleteShop(String sname);
    public Shop queryBySname(String sname);

}
