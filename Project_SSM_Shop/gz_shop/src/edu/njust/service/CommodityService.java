package edu.njust.service;

import edu.njust.entity.Commodity;

import java.util.List;

/**
 * @description CommodityService
 * @author gy
 **/
public interface CommodityService {

    public boolean addCommodity(Commodity commodity);
    public boolean updateCommodity(Commodity commodity);
    public List<Commodity> queryAllCommodity();
    public List<Commodity> queryAllCommodityByShop(String sname);
    public boolean deleteCommodityById(int cid);
    public Commodity queryByCid(int cid);
    public List<Commodity> queryByName(String name);
    public List<Commodity> queryAllCommodityByCategory(String caname);
}
