package edu.njust.controller;

import edu.njust.entity.Commodity;
import edu.njust.entity.Shop;
import edu.njust.entity.User;
import edu.njust.service.ShopService;
import edu.njust.service.impl.CommodityServiceImpl;
import edu.njust.service.impl.ShopServiceImpl;
import edu.njust.service.impl.UserServiceImpl;
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
import java.rmi.ServerException;
import java.util.List;
import java.util.Map;

/**
 * @description 登录
 * @author gy
 */
@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ShopServiceImpl ShopService;

    @Autowired
    private CommodityServiceImpl commodityService;

    @RequestMapping(value = "login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("loginname");
        String password = request.getParameter("password");
        String people = request.getParameter("people");
        HttpSession session = request.getSession();
        if (name == "" ) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if( password == ""){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            boolean temp = false;
            if ("user".equals(people)) {
                User user = userService.queryByLogin(name, password);
                if (user != null) {
                    temp = true;
                    List<Commodity> commodities = commodityService.queryAllCommodity();
                    session.setAttribute("list", commodities);
                    session.setAttribute("uname", name);
                    response.sendRedirect("/view/user_commodity.jsp");
                }
            } else if ("admin".equals(people)) {
                    Shop Shop = ShopService.queryByLogin(name, password);
                    if (Shop != null) {
                        temp = true;
                        List<Commodity> commodities = commodityService.queryAllCommodityByShop(name);
                        session.setAttribute("lists", commodities);
                        session.setAttribute("sname", name);
                        request.getRequestDispatcher("/view/shop_commodity.jsp").forward(request, response);

                    }
                }
            if (!temp) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }

    }

    @RequestMapping(value = "logincheck")
    public void logincheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("loginname");
        String password = request.getParameter("password");
        String people = request.getParameter("people");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        if (name == "" ) {
            out.print("0");
            out.close();
            out.flush();
        } if( password == ""){
            out.print("1");
            out.close();
            out.flush();
        } else {
            boolean temp = false;
            if ("user".equals(people)) {
                User user = userService.queryByLogin(name, password);
                if (user != null) {
                    temp = true;
                    List<Commodity> commodities = commodityService.queryAllCommodity();
                    session.setAttribute("list", commodities);
                    session.setAttribute("uname", name);
                    response.sendRedirect("/view/user_commodity.jsp");
                }
            } else if ("admin".equals(people)) {
                Shop Shop = ShopService.queryByLogin(name, password);
                if (Shop != null) {
                    temp = true;
                    List<Commodity> commodities = commodityService.queryAllCommodityByShop(name);
                    session.setAttribute("lists", commodities);
                    session.setAttribute("sname", name);
                    request.getRequestDispatcher("/view/shop_commodity.jsp").forward(request, response);

                }
            }
            if (!temp) {
                out.print("2");
                out.close();
                out.flush();
            }
        }

    }
}
