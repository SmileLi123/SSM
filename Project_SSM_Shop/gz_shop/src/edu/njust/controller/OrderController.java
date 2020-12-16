package edu.njust.controller;

import edu.njust.entity.*;
import edu.njust.service.impl.CommodityServiceImpl;
import edu.njust.service.impl.OrderServiceImpl;
import edu.njust.service.impl.ScartServiceImpl;
import edu.njust.service.impl.UserServiceImpl;
import edu.njust.entity.Order;
import edu.njust.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description 订单
 * @author gy
 **/
@RequestMapping(value = "Order")
@Controller
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private CommodityServiceImpl commodityService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ScartServiceImpl scartService;

    @RequestMapping("queryByOid")
    public String queryByOid(@RequestParam("uname") String uname,@RequestParam("oid") int oid,
                             Map<String,Object> map){
        Order order=orderService.queryOrderByOId(oid);
        map.put("uname",uname);
        map.put("order",order);
        return "user_order_info";
    }

    @RequestMapping("addOrderfromCom")
    public String addOrderfromCom(@RequestParam("uname") String uname, @RequestParam("cid") int cid,
                                  Map<String,Object> map){
        Commodity commodity=commodityService.queryByCid(cid);
        User user=userService.queryUser(uname);
        map.put("user",user);
        map.put("commodity",commodity);
        return "user_add_order";
    }

    @RequestMapping("addOrderfromScart")
    public String addOrderfromScart(@RequestParam("uname") String uname,@RequestParam("cid") int cid,@RequestParam("gid") int gid,
                                    Map<String,Object> map ,HttpServletRequest request){
        Commodity commodity=commodityService.queryByCid(cid);
        User user=userService.queryUser(uname);
        Scart scart=scartService.queryByid(gid);
        String gid1=Integer.toString(gid);
        map.put("scart",scart);
        map.put("user",user);
        map.put("commodity",commodity);
        request.getSession().setAttribute("gid1",gid1);
        return "user_add_order";
    }


    @RequestMapping("updateOrderByUser")
    public void updateOrderByUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        int oid=Integer.parseInt(request.getParameter("oid"));
        Order order=orderService.queryOrderByOId(oid);
        String state=order.getState();
        if(state.equals("已发货")){
            order.setState("已收货");
            boolean a=orderService.updateOrder(order);
        }
        request.getRequestDispatcher("/Order/userOrder.form?uname="+uname).forward(request,response);
    }

    @RequestMapping("updateOrderByShop")
    public void updateOrderByShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname=request.getParameter("sname");
        int oid=Integer.parseInt(request.getParameter("oid"));
        Order order=orderService.queryOrderByOId(oid);
        String state=order.getState();
        if(state.equals("待发货")){
            order.setState("已发货");
            boolean a=orderService.updateOrder(order);
        }
        request.getRequestDispatcher("/Order/shopOrder.form?sname="+sname).forward(request,response);
    }



    @RequestMapping("userOrder")
    public void UserOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        List<Order> orders=orderService.queryOrderByUname(uname);
        List<Order> list=new ArrayList<>();
        List<Order> lista=new ArrayList<>();
        List<Order> listb=new ArrayList<>();
        List<Order> listc=new ArrayList<>();
        for(int i=0;i<orders.size();i++){
            Order order=orders.get(i);
            String state=order.getState();
            if(state.equals("待发货")){
                list.add(order);
            }else if(state.equals("已发货")){
                lista.add(order);
            }else if(state.equals("已收货")){
                listb.add(order);
            }else if(state.equals("已评价")){
                listc.add(order);
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("list", list);
        session.setAttribute("lista",lista);
        session.setAttribute("listb",listb);
        session.setAttribute("listc",listc);
        session.setAttribute("uname", uname);
        request.getRequestDispatcher("/view/user_order.jsp").forward(request, response);
    }


    @RequestMapping("shopOrder")
    public void SHopOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname=request.getParameter("sname");
        List<Order> orders = orderService.queryOrderBySname(sname);
        List<Order> daifahuo=new ArrayList<>();
        List<Order> other=new ArrayList<>();
        for(int i=0;i<orders.size();i++){
            Order order=orders.get(i);
            String state=order.getState();
            if(state.equals("待发货")){
                daifahuo.add(order);
            }else{
                other.add(order);
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("daifahuo",daifahuo);
        session.setAttribute("list", other);
        session.setAttribute("sname", sname);
        request.getRequestDispatcher("/view/shop_order.jsp").forward(request, response);
    }

    @RequestMapping("addOrder")
    public void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        User user=userService.queryUser(uname);
        String hname=request.getParameter("hname");
        String sname=request.getParameter("sname");
        int cid=Integer.parseInt(request.getParameter("cid"));
        HttpSession session=request.getSession();
        Commodity commodity=commodityService.queryByCid(cid);
        String cname=commodity.getCname();
        double price=commodity.getPrice();
        String hphone=request.getParameter("hphone");
        String haddress=request.getParameter("haddress");
        String temp1=request.getParameter("num");
        if(temp1==null||temp1.equals("")){
            session.setAttribute("commodity",commodity);
            session.setAttribute("user",user);
            session.setAttribute("error","提交订单失败，请输入商品数量");
            request.getRequestDispatcher("/view/user_add_order.jsp").forward(request,response);
        }else{
            int num=Integer.parseInt(temp1);
            String temp=request.getParameter("gid");
            if(temp==null||temp.equals("")){

            }else{
                int gid=Integer.parseInt(temp);
                Scart scart=scartService.queryByid(gid);
                num=scart.getNum();
                boolean a=scartService.deleteScart(gid);
            }
            double tprice=price*num;
            String state="待发货";
            Order order = new Order(uname,hname,sname,cid,cname,hphone,haddress,num,tprice,state);
            boolean b = orderService.addOrder(order);
            session.setAttribute("uname",uname);
            request.getRequestDispatcher("/Order/userOrder.form?uname="+uname).forward(request, response);
        }
    }

    @RequestMapping("deleteOrder")
    public void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        int oid=Integer.parseInt(request.getParameter("oid"));
        Order order=orderService.queryOrderByOId(oid);
        if("待发货".equals(order.getState())){
            boolean b = orderService.deleteOrder(oid);
            request.getRequestDispatcher("/Order/userOrder.form?uname="+uname).forward(request, response);
        }else{
            request.getRequestDispatcher("/Order/userOrder.form?uname="+uname).forward(request, response);
        }
    }

    @RequestMapping("checkOrder")
    public void checkOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        int oid=Integer.parseInt(request.getParameter("oid"));
        Order order=orderService.queryOrderByOId(oid);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        if("待发货".equals(order.getState())){
            out.print("0");
            out.flush();
            out.close();
        }if("已发货".equals(order.getState())){
            out.print("1");
            out.flush();
            out.close();
        }
    }
}
