package edu.njust.service.impl;

import edu.njust.entity.User;
import edu.njust.mapper.UserMapper;
import edu.njust.service.UserService;
import edu.njust.mapper.UserMapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description UserServiceImpl
 * @author gy
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryByLogin(String name,String password) {
        User user = new User(name,password);
        User query = userMapper.queryByLogin(user);
//        System.out.println("query = " + query);
//        System.out.println(query==null);

        return query;
    }

    @Override
    public boolean addUser(User user) {
        int i = userMapper.addUser(user);
        return i==0?true:false;
    }

    @Override
    public boolean updateUser(User user) {
        int i = userMapper.updateUser(user);
        return i==0?true:false;
    }

    @Override
    public boolean deleteUser(String uname) {
        int i = userMapper.deleteUser(uname);
        return i==0?true:false;
    }

    @Override
    public User queryUser(String uname) {
        User user = userMapper.queryUser(uname);
        return user;
    }
}
