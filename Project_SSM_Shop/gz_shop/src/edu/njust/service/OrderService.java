package edu.njust.service;

import edu.njust.entity.Order;
import edu.njust.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * @description OrderService
 * @author gy
 **/
public interface OrderService {

    public boolean addOrder(Order order);
    public boolean updateOrder(Order order);
    public boolean deleteOrder(int oid);
    public Order queryOrderByOId(int oid);
    public List<Order> queryOrderByUname(String uname);
    public List<Order> queryOrderBySname(String sname);
    public List<Order> queryOrderByState(String state);
}
