package edu.njust.mapper;

import edu.njust.entity.User;

/**
 * @description UserMapper
 * @author gy
 **/
public interface UserMapper {

    public User queryByLogin(User user);
    public int addUser(User user);
    public int updateUser(User user);
    public int deleteUser(String uname);
    public User queryUser(String uname);
}
