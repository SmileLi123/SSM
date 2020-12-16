package edu.njust.service;

import edu.njust.entity.Appraise;

import java.util.List;
import java.util.Map;

/**
 * @description AppraiseService
 * @author gy
 **/
public interface AppraiseService {

    public boolean addAppraise(Appraise appraise);
    public List<Appraise> queryAppraiseByCommodity(int cid);
    public List<Appraise> queryAppraiseByUser(String uname);
    public Appraise queryById(int oid);
}
