package edu.njust.mapper;

import edu.njust.entity.Commodity;
import edu.njust.entity.Commodity;

import java.util.List;

/**
 * Created by gy on 2020/9/26.
 */
public interface CategoryMapper {
    public List<Commodity> queryAllCommodityByCategory(String caname);
}
