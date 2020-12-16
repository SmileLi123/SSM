package edu.njust.service.impl;

import edu.njust.entity.Appraise;
import edu.njust.mapper.AppraiseMapper;
import edu.njust.service.AppraiseService;
import edu.njust.mapper.AppraiseMapper;
import edu.njust.service.AppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description AppraiseServiceImpl
 * @author gy
 **/
@Service
public class AppraiseServiceImpl implements AppraiseService {

    @Autowired
    private AppraiseMapper appraiseMapper;

    @Override
    public boolean addAppraise(Appraise appraise) {
        int i = appraiseMapper.addAppraise(appraise);
        System.out.println("i = " + i);
        return i==1?true:false;
    }

    @Override
    public List<Appraise> queryAppraiseByCommodity(int cid) {
        List<Appraise> appraises = appraiseMapper.queryAllAppraiseByCommodity(cid);

        return appraises;
    }

    @Override
    public List<Appraise> queryAppraiseByUser(String uname) {
        List<Appraise> appraise = appraiseMapper.queryAppraiseByUser(uname);
        return appraise;
    }

    @Override
    public Appraise queryById(int oid) {
        Appraise appraise = appraiseMapper.queryById(oid);
        return appraise;
    }

}
