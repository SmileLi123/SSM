package edu.njust.mapper;

import edu.njust.entity.Commodity;
import edu.njust.entity.Shop;

import java.util.List;

/**
 * @description CommodityMapper
 * @author gy
 **/
public interface CommodityMapper {

    public int addCommodity(Commodity commodity);
    public List<Commodity> queryAllCommodity();
    public List<Commodity> queryAllCommodityByShop(String sname);
    public int updateCommodity(Commodity commodity);
    public int deleteCommodityById(int cid);
    public Commodity queryByCid(int cid);
    public List<Commodity> queryByName(String name);
}
