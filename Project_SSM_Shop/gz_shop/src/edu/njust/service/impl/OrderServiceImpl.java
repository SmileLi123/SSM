package edu.njust.service.impl;

import edu.njust.entity.Order;
import edu.njust.mapper.OrderMapper;
import edu.njust.service.OrderService;
import edu.njust.entity.Order;
import edu.njust.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description OrderServiceImpl
 * @author gy
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean addOrder(Order order) {
        int i = orderMapper.addOrder(order);
        return i==0?true:false;
    }

    @Override
    public boolean updateOrder(Order order) {
        int i = orderMapper.updateOrder(order);
        return i==0?true:false;
    }

    @Override
    public boolean deleteOrder(int oid) {
        int i = orderMapper.deleteOrder(oid);
        return i==0?true:false;
    }

    @Override
    public Order queryOrderByOId(int oid) {
        Order order=orderMapper.queryOrderByOId(oid);
        return order;
    }

    @Override
    public List<Order> queryOrderByUname(String uname) {
        List<Order> orders = orderMapper.queryOrderByUname(uname);
        return orders;
    }

    @Override
    public List<Order> queryOrderBySname(String sname) {
        List<Order> orders=orderMapper.queryOrderBySname(sname);
        return orders;
    }

    @Override
    public List<Order> queryOrderByState(String state) {
        List<Order> orders=orderMapper.queryOrderByState(state);
        return orders;
    }

}
