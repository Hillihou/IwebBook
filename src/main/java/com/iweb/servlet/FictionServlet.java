package com.iweb.servlet;

import com.iweb.pojo.Fiction;
import com.iweb.pojo.FictionUser;
import com.iweb.service.FictionService;
import com.iweb.service.impl.FictionServiceImpl;
import com.iweb.util.PageModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FictionServlet extends HttpServlet {
    private FictionService fictionService=new FictionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //获取请求参数之前转码，保证java内不乱码
        req.setCharacterEncoding("UTF-8");
        //得到urlpattern
        String path=req.getServletPath();
        System.out.println(path);
        switch (path){
            case "/queryAll.fiction":
                queryAll(req,resp);
                break;
            case "/toAdd.fiction":
                resp.sendRedirect(req.getContextPath()+"/fiction/fiction_toAdd.html");
                break;
            case "/addorupdate.fiction":
                addorupdate(req,resp);
                break;
            case "/toUpdate.fiction":
                toUpdate(req,resp);
                break;
            case "/toDelete.fiction":
                toDelete(req,resp);
                break;
            default:
                queryAll(req,resp);
                break;
        }
    }

    private void toDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    }

    private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    }

    private void addorupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    }

    private void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int pageNo=req.getParameter("pageNo")==null?1:Integer.parseInt(req.getParameter("pageNo"));
        String likeValue = req.getParameter("likeValue");
        PageModel pageModel = new PageModel();
        pageModel.setPageNo(pageNo);
        pageModel.setLikeValue(likeValue);
        List<Fiction> fictions = fictionService.getFictions(likeValue,pageModel);
        pageModel.setPageData(fictions);
        System.out.println(fictions);

        req.setAttribute("pageModel",pageModel);
        req.getRequestDispatcher("/fiction/fiction_selectBypage.jsp").forward(req, resp);
    }


}
