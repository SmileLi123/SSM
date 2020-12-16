package edu.njust.mapper;


import edu.njust.entity.Commodity;
import edu.njust.entity.Scart;
import edu.njust.entity.Scart;

import java.util.List;

public interface ScartMapper {

    public List<Scart> queryByUname(String uname);
    public int deleteScart(int gid);
    public int addScart(Scart scart);
    public Scart queryByid(int id);
    public int updateScart(Scart scart);
    public Scart queryBycid(int cid);
}
