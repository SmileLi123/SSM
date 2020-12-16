package edu.njust.service.impl;


import edu.njust.entity.Commodity;
import edu.njust.entity.Scart;
import edu.njust.mapper.ScartMapper;
import edu.njust.service.ScartService;
import edu.njust.entity.Scart;
import edu.njust.mapper.ScartMapper;
import edu.njust.service.ScartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScartServiceImpl implements ScartService {

    @Autowired
    private ScartMapper scartMapper;

    @Override
    public List<Scart> queryByUname(String uname) {
        List<Scart> scarts= scartMapper.queryByUname(uname);
        return scarts;
    }

    @Override
    public boolean deleteScart(int gid) {
        int i=scartMapper.deleteScart(gid);
        return i==0?true:false;
    }

    @Override
    public boolean addScart(Scart scart) {
        int i=scartMapper.addScart(scart);
        return i==0?true:false;
    }

    @Override
    public boolean updateScart(Scart scart) {
        int i=scartMapper.updateScart(scart);
        return i==0?true:false;
    }

    @Override
    public Scart queryByid(int gid) {
        Scart scart=scartMapper.queryByid(gid);
        return scart;
    }

    @Override
    public Scart queryBycid(int cid) {
        Scart scart=scartMapper.queryBycid(cid);
        return scart;
    }
}
