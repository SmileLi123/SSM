package edu.njust.controller;

import edu.njust.entity.Shop;
import edu.njust.service.impl.ShopServiceImpl;
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
import java.util.Map;

/**
 * @description 店家
 * @author gy
 **/
@RequestMapping(value = "Shop")
@Controller
public class ShopController {

    @Autowired
    private ShopServiceImpl ShopService;

    @RequestMapping("register")
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String sname=request.getParameter("sname");
        HttpSession session=request.getSession();
        if(sname==null||sname.equals("")){
            request.getRequestDispatcher("/view/shop_register.jsp").forward(request, response);
        }
        Shop shop1=ShopService.queryBySname(sname);
        if(shop1!=null){
            request.getRequestDispatcher("/view/shop_register.jsp").forward(request, response);
        }else{
            String password=request.getParameter("password");
            if(password==null||password.equals("")){
                session.setAttribute("sname",sname);
                request.getRequestDispatcher("/view/shop_register.jsp").forward(request, response);
            }else {
                String phone = request.getParameter("phone");
                if(phone==null||phone.equals("")){
                    session.setAttribute("sname",sname);
                    session.setAttribute("password",password);
                    request.getRequestDispatcher("/view/shop_register.jsp").forward(request, response);
                }else {
                    String describtion = request.getParameter("describtion");
                    Shop Shop = new Shop(sname, password, phone, describtion.trim());
                    boolean b = ShopService.addShop(Shop);
                    response.sendRedirect("/index.jsp");
                }
        }}
    }

    @RequestMapping("check")
    public void UserCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("sname");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        if(name==null||name.equals("")){
            out.print("1");//用户名为空
            out.flush();
            out.close();
        }else{
            Shop shop1=ShopService.queryBySname(name);
            if(shop1!=null) {//用户名存在
                out.print("0");
                out.flush();
                out.close();
            }
        }
    }

    @RequestMapping("checkpd")
    public void UserCheckpd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        PrintWriter out1 = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        if(password==null||password.equals("")){
            out1.print("1");//用户名为空
            out1.flush();
            out1.close();
        }
    }

    @RequestMapping("checkall")
    public void checkall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("sname");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        if(name==null||name.equals("")){
            out.print("0");//用户名为空
            out.flush();
            out.close();
        }else{
            Shop shop1=ShopService.queryBySname(name);
            if(shop1==null) {
                String password = request.getParameter("password");
                if (password == null || password.equals("")) {
                    out.print("1");//密码为空
                    out.flush();
                    out.close();}
                else {
                    String phone = request.getParameter("phone");
                    if(phone == null || phone.equals("")) {
                        out.print("2");//手机号为空
                        out.flush();
                        out.close();
                    }
                    else{
                        out.print("3");//注册成功
                        out.flush();
                        out.close();
                    }
                }
            }
        }
    }
    @RequestMapping("shopInfo")
    public void shopInfo(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String uname=request.getParameter("uname");
        String sname=request.getParameter("sname");
        Shop shop=ShopService.queryBySname(sname);
        HttpSession session=request.getSession();
        session.setAttribute("shop",shop);
        session.setAttribute("uname",uname);
        response.sendRedirect("/view/user_showshopinfo.jsp");
    }

    @RequestMapping("info")
    public String shopInfo(@RequestParam("sname") String sname, Map<String, Object> map) {
        Shop Shop = ShopService.queryBySname(sname);
        map.put("shop", Shop);
        map.put("sname", sname);
        return "shop_info";
    }

    @RequestMapping("update")
    public void UserUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String sname=request.getParameter("sname");
        String password=request.getParameter("password");
        if (password == null ||password.equals("")) {
            session.setAttribute("sname", sname);
            request.getRequestDispatcher("/Shop/info.form").forward(request, response);
        }else {
            String sphone=request.getParameter("sphone");
            Shop shop=ShopService.queryBySname(sname);
            shop.setPassword(password);
            boolean a=ShopService.updateShop(shop);
            if(sphone == null || sphone.equals("")){
                session.setAttribute("sname", sname);
                request.getRequestDispatcher("/Shop/info.form").forward(request, response);
            }else {
                String describtion = request.getParameter("describtion");
                shop.setSphone(sphone);
                shop.setdescribtion(describtion);
                boolean c=ShopService.updateShop(shop);
                session.setAttribute("sname", sname);
                request.getRequestDispatcher("/Shop/info.form").forward(request, response);
            }
        }
    }
    @RequestMapping("updatecheck")
    public void ShopUpdatecheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname = request.getParameter("sname");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        Shop shop=ShopService.queryBySname(sname);
        String password = request.getParameter("password");
        if (password == null || password.equals("")) {
            out.print("0");//密码为空
            out.flush();
            out.close();}
        else {
            String sphone = request.getParameter("sphone");
            if(sphone == null || sphone.equals("")) {
                out.print("1");//手机号为空
                out.flush();
                out.close();
            }
            else{
                    out.print("2");//修改成功
                    out.flush();
                    out.close();

            }
        }
    }

    @RequestMapping("logout")
    public void Logout(HttpServletRequest request, HttpServletResponse response)throws IOException{
        HttpSession session=request.getSession();
        session.removeAttribute("sname");
        session.invalidate();
        response.sendRedirect("/index.jsp");
    }

    @RequestMapping("delete")
    public void delete(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String sname=request.getParameter("sname");
        boolean b = ShopService.deleteShop(sname);
        response.sendRedirect("/index.jsp");
    }
}
