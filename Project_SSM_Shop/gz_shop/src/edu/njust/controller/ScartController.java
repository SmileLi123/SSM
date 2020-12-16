package edu.njust.controller;


import edu.njust.entity.Commodity;
import edu.njust.entity.Scart;
import edu.njust.service.impl.CommodityServiceImpl;
import edu.njust.service.impl.ScartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RequestMapping(value = "Scart")
@Controller
public class ScartController {

    @Autowired
    private ScartServiceImpl scartService;

    @Autowired
    private CommodityServiceImpl commodityService;

    @RequestMapping("queryByUname")
    public void queryByUname(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String uname=request.getParameter("uname");
        List<Scart> scarts=scartService.queryByUname(uname);
        HttpSession session=request.getSession();
        session.setAttribute("listofscart",scarts);
        session.setAttribute("uname",uname);
        request.getRequestDispatcher("/view/user_scart.jsp").forward(request,response);
    }

    @RequestMapping("deleteScart")
    public void deleteScart(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String uname=request.getParameter("uname");
        int gid=Integer.parseInt(request.getParameter("gid"));
        boolean b=scartService.deleteScart(gid);
        HttpSession session=request.getSession();
        session.setAttribute("uname",uname);
        request.getRequestDispatcher("/Scart/queryByUname.form?uname="+uname).forward(request,response);
    }

    @RequestMapping("add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int gid=Integer.parseInt(request.getParameter("gid"));
        int num=Integer.parseInt(request.getParameter("num"));
        System.out.println("g"+gid+"g");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        Scart scart=scartService.queryByid(gid);
        scart.setNum(num);
        boolean b=scartService.updateScart(scart);
        out.print("0");
        out.flush();
        out.close();
    }

    @RequestMapping("addScart")
    public void addScart(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String uname=request.getParameter("uname");
        int cid=Integer.parseInt(request.getParameter("cid"));
        Scart scart=scartService.queryBycid(cid);
        if(scart==null){
            Commodity commodity=commodityService.queryByCid(cid);
            double price=commodity.getPrice();
            String sname=commodity.getSname();
            String cname=commodity.getCname();
            int num=1;
            Scart scart1=new Scart(uname,cid,sname,cname,price,num);
            boolean b=scartService.addScart(scart1);
            HttpSession session=request.getSession();
            session.setAttribute("uname",uname);
            request.getRequestDispatcher("/Scart/queryByUname.form?uname="+uname).forward(request,response);
        }else {
            int num1=scart.getNum();
            scart.setNum(num1+1);
            boolean b=scartService.updateScart(scart);
            HttpSession session=request.getSession();
            session.setAttribute("uname",uname);
            request.getRequestDispatcher("/Scart/queryByUname.form?uname="+uname).forward(request,response);
        }
    }

}
