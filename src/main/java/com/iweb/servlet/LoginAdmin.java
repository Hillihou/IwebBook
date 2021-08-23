package com.iweb.servlet;

import com.iweb.pojo.Managerinfo;
import com.iweb.service.ManagerinfoService;
import com.iweb.service.impl.ManagerinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAdmin extends HttpServlet {
    private ManagerinfoService managerinfoService=new ManagerinfoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Managerinfo managerinfo = managerinfoService.queryManagerByNameAndPassword(username, password);
        if (managerinfo!=null){
            req.getRequestDispatcher("/main.jsp").forward(req, resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/info/faild.jsp");
        }


    }
}
