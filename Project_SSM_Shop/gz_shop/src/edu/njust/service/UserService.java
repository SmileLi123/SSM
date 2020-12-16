package edu.njust.service;

import edu.njust.entity.User;
import edu.njust.entity.User;

/**
 * @description UserService
 * @author gy
 **/
public interface UserService {

    public User queryByLogin(String name,String password);
    public boolean addUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(String uname);
    public User queryUser(String uname);
}
