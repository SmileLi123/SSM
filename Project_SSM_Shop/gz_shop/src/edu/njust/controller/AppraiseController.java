package edu.njust.controller;

import edu.njust.entity.Appraise;
import edu.njust.entity.Commodity;
import edu.njust.entity.Order;
import edu.njust.service.AppraiseService;
import edu.njust.service.CommodityService;
import edu.njust.service.impl.OrderServiceImpl;
import edu.njust.entity.Order;
import edu.njust.service.AppraiseService;
import edu.njust.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 评价
 * @author gy
 */
@RequestMapping(value = "Appraise")
@Controller
public class AppraiseController {

    @Autowired
    private AppraiseService appraiseService;
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private OrderServiceImpl orderService;


    @RequestMapping("addAppraise")
    public void UserAddAppraise(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        int oid=Integer.parseInt(request.getParameter("oid"));
        String uname=request.getParameter("uname");
        String sname=request.getParameter("sname");
        String cname=request.getParameter("cname");
        String grade =request.getParameter("grade");
        String info=request.getParameter("info");
        if(info==null||info.equals("")){
            info="此用户没有填写评价";
        }
        //判断是否已经评论,是跳过,否就执行
        Appraise appraise1 = appraiseService.queryById(oid);
        if (appraise1 == null) {
            Appraise appraise = new Appraise(oid,uname,sname,cname,grade,info);
            boolean b = appraiseService.addAppraise(appraise);
            Order order=orderService.queryOrderByOId(oid);
            order.setState("已评价");
            boolean a=orderService.updateOrder(order);
        }
        request.getRequestDispatcher("/Appraise/userAppraise.form?uname="+uname).forward(request,response);
    }




    @RequestMapping("userAppraise")
    public void userAppraise(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String uname=request.getParameter("uname");
        List<Appraise> appraises=appraiseService.queryAppraiseByUser(uname);
        String state="已收货";
        List<Order> orders=orderService.queryOrderByState(state);
        HttpSession session=request.getSession();
        session.setAttribute("lista",appraises);
        session.setAttribute("uname",uname);
        session.setAttribute("list",orders);
        request.getRequestDispatcher("/view/user_appraise.jsp").forward(request,response);
    }

    @RequestMapping("commodity_appraise")
    public void CommodityAppraise(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        int cid=Integer.parseInt(request.getParameter("cid"));
        List<Appraise> lista = appraiseService.queryAppraiseByCommodity(cid);
        Commodity commodity = commodityService.queryByCid(cid);

        HttpSession session = request.getSession();
        session.setAttribute("lista", lista);
        session.setAttribute("commodity", commodity);
        session.setAttribute("uname", uname);
        session.setAttribute("cid", cid);
        request.getRequestDispatcher("/view/user_commodity_appraise.jsp").forward(request, response);
    }

    @RequestMapping("shopAppraise")
    public void shopAppraise(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname=request.getParameter("sname");
        int cid=Integer.parseInt(request.getParameter("cid"));
        List<Appraise> appraises=appraiseService.queryAppraiseByCommodity(cid);

        Commodity commodity = commodityService.queryByCid(cid);

        HttpSession session = request.getSession();
        session.setAttribute("list",appraises);
        session.setAttribute("commodity", commodity);
        session.setAttribute("sname",sname);
        request.getRequestDispatcher("/view/shop_commodity_appraise.jsp").forward(request, response);
    }

}
