package edu.njust.mapper;

import edu.njust.entity.Order;
import edu.njust.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * @description OrderMapper
 * @author gy
 **/
public interface OrderMapper {

    public int addOrder(Order order);
    public int updateOrder(Order order);
    public int deleteOrder(int oid);

    public Order queryOrderByOId(int oid);
    public List<Order> queryOrderByUname(String uname);
    public List<Order> queryOrderBySname(String sname);
    public List<Order> queryOrderByState(String state);
}
