package edu.njust.service;

import edu.njust.entity.Commodity;
import edu.njust.entity.Scart;

import java.util.List;

/**
 * Created by gy on 2020/10/1.
 */
public interface ScartService {

    public List<Scart> queryByUname(String uname);
    public boolean deleteScart(int cid);
    public boolean addScart(Scart scart);
    public boolean updateScart(Scart scart);
    public Scart queryByid(int gid);
    public Scart queryBycid(int cid);
}
