package com.iweb.servlet;

import com.iweb.pojo.Category;
import com.iweb.pojo.FictionUser;
import com.iweb.service.FictionUserService;
import com.iweb.service.impl.FictionUserServiceImpl;
import com.iweb.util.PageModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class FictionUserServlet extends HttpServlet {
    private FictionUserService fictionUserService=new FictionUserServiceImpl();

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
            case "/queryAll.fictionuser":
                queryAll(req,resp);
                break;
            case "/toAdd.fictionuser":
                resp.sendRedirect(req.getContextPath()+"/fictionUser_toEdit.jsp");
                break;
            case "/addorupdate.fictionuser":
                addorupdate(req,resp);
                break;
            case "/toUpdate.fictionuser":
                toUpdate(req,resp);
                break;
            case "/toDelete.fictionuser":
                toDelete(req,resp);
                break;
            default:
                queryAll(req,resp);
                break;
        }
    }

    private void toDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String userId = req.getParameter("userId");
        FictionUser fictionUser = fictionUserService.queryById(Integer.valueOf(userId));
        int i=fictionUserService.deleteOne(fictionUser.getUserId());
        if (i>0){
            resp.sendRedirect(req.getContextPath()+"/queryAll.fictionuser");
        }else {
            resp.sendRedirect(req.getContextPath()+"/errorpage/errorPage.jsp");
        }
    }



    private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String userId = req.getParameter("userId");
        FictionUser fictionUser = fictionUserService.queryById(Integer.valueOf(userId));
        req.setAttribute("fictionUser",fictionUser);
        req.getRequestDispatcher("/fictionUser/fictionUser_toEdit.jsp").forward(req, resp);

    }

    private void addorupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session=req.getSession();
        Object myflag = session.getAttribute("myflag");
        String flag = req.getParameter("flag");
        //如果有flag就删除
        if (myflag!=null&&!"".equals(myflag)&&myflag.equals(flag)){
            session.removeAttribute("myflag");
        }else {
            //重复提交
            resp.sendRedirect(req.getContextPath()+"/queryAll.fictionuser");
            return;
        }
        String userFullName = req.getParameter("userFullName");
        String movephone = req.getParameter("movephone");
        String memberdayCount = req.getParameter("memberdayCount");
        Integer userId=null;
        if (req.getParameter("userId")!=null&&!"".equals(req.getParameter("userId"))){
            userId = Integer.valueOf(req.getParameter("userId"));
        }
        int i =-1;
        FictionUser fictionUser = new FictionUser(userId,null,null,userFullName,movephone,Integer.valueOf(memberdayCount));
        if (userId!=null&&!"".equals(userId)){
            i = fictionUserService.updateOne(fictionUser);
        }else {
            i = fictionUserService.saveOne(fictionUser);
        }
        if (i>0){
            resp.sendRedirect(req.getContextPath()+"/queryAll.fictionuser");
        }else {
            resp.sendRedirect(req.getContextPath()+"/errorpage/errorPage.jsp");
        }

    }

    private void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int pageNo=req.getParameter("pageNo")==null?1:Integer.parseInt(req.getParameter("pageNo"));
        String likeValue = req.getParameter("likeValue");
        PageModel pageModel = new PageModel();
        pageModel.setPageNo(pageNo);
        pageModel.setLikeValue(likeValue);
        List<FictionUser> allUsers = fictionUserService.getAllUsers(likeValue,pageModel);
        pageModel.setPageData(allUsers);
        System.out.println(allUsers);

        req.setAttribute("pageModel",pageModel);
        req.getRequestDispatcher("/fictionUser/FictionUser_selectByPage.jsp").forward(req, resp);
    }

}
