package edu.njust.mapper;

import edu.njust.entity.Appraise;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description AppraiseMapper
 * @author gy
 **/
public interface AppraiseMapper {

    public int addAppraise(Appraise appraise);
    public List<Appraise> queryAllAppraiseByCommodity(int cid);
    public List<Appraise> queryAppraiseByUser(String uname);
    public Appraise queryById(int eid);

}
