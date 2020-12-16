package edu.njust.controller;

import edu.njust.entity.User;
import edu.njust.service.impl.UserServiceImpl;
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
import java.util.Map;
/**
 * @description 用户控制
 * @author gy
 **/
@RequestMapping(value = "User")
@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("register")
    public void UserRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("uname");
        HttpSession session=request.getSession();
        if (name == null ||name.equals("")) {
            request.getRequestDispatcher("/view/user_register.jsp").forward(request,response);
        }else {
            User user1 =userService.queryUser(name);
            if (user1 != null) {
                request.getRequestDispatcher("/view/user_register.jsp").forward(request, response);
            } else {
                String password = request.getParameter("password");
                if (password == null || password.equals("")) {
                    session.setAttribute("uname",name);
                    request.getRequestDispatcher("/view/user_register.jsp").forward(request, response);
                }else{
                    String phone = request.getParameter("phone");
                    if(phone == null || phone.equals("")){
                        session.setAttribute("uname",name);
                        session.setAttribute("password",password);
                        request.getRequestDispatcher("/view/user_register.jsp").forward(request, response);
                    }else {
                        String email = request.getParameter("email");
                        String address = request.getParameter("address");
                        if(address==null||address.equals("")){
                            session.setAttribute("uname",name);
                            session.setAttribute("password",password);
                            session.setAttribute("phone",phone);
                            session.setAttribute("email",email);
                            request.getRequestDispatcher("/view/user_register.jsp").forward(request, response);
                        }else {
                            User user = new User(name, password, phone, email, address);
                            boolean b = userService.addUser(user);
                            response.sendRedirect("/index.jsp");
                        }
                    }
                }
            }
        }
    }

    @RequestMapping("checkall")
    public void checkall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("uname");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        if (name == null || name.equals("")) {
            out.print("0");  //用户名为空
            out.flush();
            out.close();
        }
        User user1 = userService.queryUser(name);
        if (user1 == null) {
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
                 else{  String address = request.getParameter("address");
                        if (address == null || address.equals("")) {
                                out.print("3");//地址为空
                                out.flush();
                                out.close();
                        } else {
                            out.print("4");//注册成功
                            out.flush();
                            out.close();
                }
            }
            }
        }
    }

    @RequestMapping("check")
    public void UserCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("uname");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        if(name==null||name.equals("")){
            out.print("1");//用户名为空
            out.flush();
            out.close();
        }else{
            User user1 =userService.queryUser(name);
            if(user1!=null) {//用户名存在
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


    @RequestMapping("info")
    public String UserInfo(@RequestParam("uname") String uname, Map<String, Object> map) {
        User user = userService.queryUser(uname);
        map.put("user", user);
        map.put("uname", uname);
        return "user_info";
    }


    @RequestMapping("update")
    public void UserUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        HttpSession session=request.getSession();
        String password=request.getParameter("password");
        if (password == null ||password.equals("")) {
            session.setAttribute("uname", uname);
            request.getRequestDispatcher("/User/info.form").forward(request,response);
        }else {
            String phone=request.getParameter("phone");
            User user1=userService.queryUser(uname);
            user1.setPassword(password);
            boolean a=userService.updateUser(user1);
            if(phone == null || phone.equals("")){
                session.setAttribute("uname", uname);
                request.getRequestDispatcher("/User/info.form").forward(request, response);
            }else {
                String email = request.getParameter("email");
                user1.setPhone(phone);
                user1.setEmail(email);
                boolean c=userService.updateUser(user1);
                String address = request.getParameter("address");
                if(address==null||address.equals("")){
                    session.setAttribute("uname", uname);
                    request.getRequestDispatcher("/User/info.form").forward(request, response);
                }else {
                    user1.setaddress(address);
                    boolean b = userService.updateUser(user1);
                    session.setAttribute("uname", uname);
                    request.getRequestDispatcher("/User/info.form").forward(request, response);
                }
            }
        }
    }

    @RequestMapping("updatecheck")
    public void UserUpdatecheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("uname");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        User user1 = userService.queryUser(name);
            String password = request.getParameter("password");
            if (password == null || password.equals("")) {
                out.print("0");//密码为空
                out.flush();
                out.close();}
            else {
                String phone = request.getParameter("phone");
                if(phone == null || phone.equals("")) {
                    out.print("1");//手机号为空
                    out.flush();
                    out.close();
                }
                else{  String address = request.getParameter("address");
                    if (address == null || address.equals("")) {
                        out.print("2");//地址为空
                        out.flush();
                        out.close();
                    } else {
                        out.print("3");//修改成功
                        out.flush();
                        out.close();

                }
            }
        }
    }
    @RequestMapping("logout")
    public void Logout(HttpServletRequest request, HttpServletResponse response)throws IOException{
        HttpSession session=request.getSession();
        session.removeAttribute("uname");
        session.invalidate();
        response.sendRedirect("/index.jsp");
    }

    @RequestMapping("delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname=request.getParameter("uname");
        boolean b = userService.deleteUser(uname);
        response.sendRedirect("/index.jsp");
    }

}
