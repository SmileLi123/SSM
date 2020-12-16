package edu.njust.controller;

import edu.njust.entity.Commodity;
import edu.njust.entity.Order;
import edu.njust.service.impl.CommodityServiceImpl;
import edu.njust.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @description 商品
 **/
@Controller
@RequestMapping(value = "Commodity")
public class CommodityController {

    @Autowired
    private CommodityServiceImpl commodityService;

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("CommodityInfo")
    public void CommodityInfo(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String uname=request.getParameter("uname");
        int oid=Integer.parseInt(request.getParameter("oid"));
        Order order=orderService.queryOrderByOId(oid);
        int cid=order.getCid();
        HttpSession session=request.getSession();
        Commodity commodity=commodityService.queryByCid(cid);
        if(commodity==null){
            session.setAttribute("uname",uname);
            session.setAttribute("error1","该商品已下架");
            response.sendRedirect("/Order/userOrder.form?uname="+uname);
        }else {
            session.setAttribute("commodity",commodity);
            session.setAttribute("uname",uname);
            response.sendRedirect("/view/user_showcommodityinfo.jsp");
        }
    }

    @RequestMapping(value = "queryByCName")
    public void queryByCName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name=request.getParameter("name");
        String cname=request.getParameter("cname");
        List<Commodity> commodities = commodityService.queryByName(cname);
        HttpSession session = request.getSession();
        session.setAttribute("list", commodities);
        session.setAttribute("name", name);
        request.getRequestDispatcher("/view/user_commodity.jsp").forward(request, response);
    }

    @RequestMapping("updateByShop")
    public String updateByShop(@RequestParam("sname") String sname, @RequestParam("cid") int cid,
                               Map<String,Object> map){
        Commodity commodity = commodityService.queryByCid(cid);
        map.put("sname",sname);
        map.put("commodity",commodity);
        return "shop_update_commodity";
    }


    @RequestMapping("updateCommodity")
    public void updateCommodity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname=request.getParameter("sname");
        int cid=Integer.parseInt(request.getParameter("cid"));
        Commodity c1=commodityService.queryByCid(cid);
        String cname=request.getParameter("cname");
        String caname=request.getParameter("caname");
        double price= Double.parseDouble(request.getParameter("price"));
        String describtion=request.getParameter("describtion");
        if("cloth".equals(caname)){
            caname="服装";
            request.getSession().setAttribute("error2",null);
        }else if("goods".equals(caname)){
            caname="百货";
            request.getSession().setAttribute("error2",null);
        }else if("shoes".equals(caname)){
            caname="鞋靴";
            request.getSession().setAttribute("error2",null);
        }else if("packet".equals(caname)){
            caname="Ïä°ü";
            request.getSession().setAttribute("error2",null);
        }else if("electric".equals(caname)){
            caname="家电";
            request.getSession().setAttribute("error2",null);
        }else if("null".equals(caname)){
            String caname1=c1.getCaname();
            Commodity commodity1=new Commodity(cid,cname,caname1,price,describtion);
            boolean a=commodityService.updateCommodity(commodity1);
            request.getSession().setAttribute("error2", "修改失败，请选择商品类型");
            request.getRequestDispatcher("/Commodity/updateByShop.form?sname="+sname+"&cid="+cid).forward(request, response);
        }
        Commodity commodity = new Commodity(cid,sname,cname,caname,price,describtion);
        boolean b = commodityService.updateCommodity(commodity);
        request.getRequestDispatcher("/Commodity/shopCommodity.form?sname="+sname).forward(request, response);
    }

    @RequestMapping("deleteByShop")
    public void deleteByShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname=request.getParameter("sname");
        int cid=Integer.parseInt(request.getParameter("cid"));
        boolean i = commodityService.deleteCommodityById(cid);
        request.getRequestDispatcher("/Commodity/shopCommodity.form?sname="+sname).forward(request, response);
    }

    @RequestMapping("userCommodity")
    public void userCommodity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        List<Commodity> commodities = commodityService.queryAllCommodity();
        HttpSession session = request.getSession();
        session.setAttribute("list",commodities);
        session.setAttribute("uname",uname);
        request.getRequestDispatcher("/view/user_commodity.jsp").forward(request, response);
    }

    @RequestMapping("shopCommodity")
    public void shopCommodity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname=request.getParameter("sname");
        List<Commodity> commodities = commodityService.queryAllCommodityByShop(sname);
        HttpSession session = request.getSession();
        session.setAttribute("lists",commodities);
        session.setAttribute("sname",sname);
        request.getRequestDispatcher("/view/shop_commodity.jsp").forward(request, response);
    }

    @RequestMapping("addCommodity")
    public void addCommodity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname= request.getParameter("sname");
        String cname=request.getParameter("cname");
        String caname=request.getParameter("caname");
        if("cloth".equals(caname)){
            caname="服装";
        }else if("goods".equals(caname)){
            caname="百货";
        }else if("shoes".equals(caname)){
            caname="鞋靴";
        }else if("packet".equals(caname)){
            caname="Ïä°ü";
        }else if("electric".equals(caname)){
            caname="家电";
        }
        String price1=request.getParameter("price");
        double price=Double.parseDouble(price1);
        String describtion=request.getParameter("describtion");
        Commodity commodity = new Commodity(sname,cname,caname,price,describtion);
        boolean b = commodityService.addCommodity(commodity);
        request.getRequestDispatcher("/Commodity/shopCommodity.form?sname="+sname).forward(request, response);
    }

    @RequestMapping("cloth")
    public void cloth(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String uname=request.getParameter("uname");
        String caname="服装";
        List<Commodity> commodities=commodityService.queryAllCommodityByCategory(caname);
        HttpSession session=request.getSession();
        session.setAttribute("list", commodities);
        session.setAttribute("uname", uname);
        request.getRequestDispatcher("/view/user_commodity.jsp").forward(request, response);
    }

    @RequestMapping("goods")
    public void goods(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String uname=request.getParameter("uname");
        String caname="百货";
        List<Commodity> commodities=commodityService.queryAllCommodityByCategory(caname);
        HttpSession session=request.getSession();
        session.setAttribute("list", commodities);
        session.setAttribute("uname", uname);
        request.getRequestDispatcher("/view/user_commodity.jsp").forward(request, response);
    }

    @RequestMapping("shoes")
    public void shoes(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String uname=request.getParameter("uname");
        String caname="鞋靴";
        List<Commodity> commodities=commodityService.queryAllCommodityByCategory(caname);
        HttpSession session=request.getSession();
        session.setAttribute("list", commodities);
        session.setAttribute("uname", uname);
        request.getRequestDispatcher("/view/user_commodity.jsp").forward(request, response);
    }

    @RequestMapping("packet")
    public void packet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String uname=request.getParameter("uname");
        String caname="Ïä°ü";
        List<Commodity> commodities=commodityService.queryAllCommodityByCategory(caname);
        HttpSession session=request.getSession();
        session.setAttribute("list", commodities);
        session.setAttribute("uname", uname);
        request.getRequestDispatcher("/view/user_commodity.jsp").forward(request, response);
    }

    @RequestMapping("electric")
    public void electric(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String uname=request.getParameter("uname");
        String caname="家电";
        List<Commodity> commodities=commodityService.queryAllCommodityByCategory(caname);
        HttpSession session=request.getSession();
        session.setAttribute("list", commodities);
        session.setAttribute("uname", uname);
        request.getRequestDispatcher("/view/user_commodity.jsp").forward(request, response);
    }

}
