package edu.njust.service.impl;

import edu.njust.entity.Commodity;
import edu.njust.mapper.CategoryMapper;
import edu.njust.mapper.CommodityMapper;
import edu.njust.service.CommodityService;
import edu.njust.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description CommodityServiceImpl
 * @author gy
 **/
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Commodity> queryAllCommodityByCategory(String caname) {
        List<Commodity> commodities= categoryMapper.queryAllCommodityByCategory(caname);
        return commodities;
    }


    @Override
    public boolean addCommodity(Commodity commodity) {
        int i = commodityMapper.addCommodity(commodity);
        return i==0?true:false;
    }

    @Override
    public boolean updateCommodity(Commodity commodity) {
        int i = commodityMapper.updateCommodity(commodity);
        return i==0?true:false;
    }

    @Override
    public List<Commodity> queryAllCommodity() {
        List<Commodity> commodities = commodityMapper.queryAllCommodity();
        return commodities;
    }

    @Override
    public List<Commodity> queryAllCommodityByShop(String sname) {
        List<Commodity> commodities = commodityMapper.queryAllCommodityByShop(sname);
        return commodities;
    }

    @Override
    public boolean deleteCommodityById(int cid) {
        int i = commodityMapper.deleteCommodityById(cid);
        System.out.println("i = " + i);
        return i==0?true:false;
    }

    @Override
    public Commodity queryByCid(int cid) {
        Commodity commodity = commodityMapper.queryByCid(cid);
        return commodity;
    }

    @Override
    public List<Commodity> queryByName(String cname) {
        List<Commodity> commodities = commodityMapper.queryByName(cname);
        return commodities;
    }
}
