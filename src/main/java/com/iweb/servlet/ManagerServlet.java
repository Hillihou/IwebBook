package com.iweb.servlet;

import com.iweb.pojo.Category;
import com.iweb.pojo.Managerinfo;
import com.iweb.service.ManagerinfoService;
import com.iweb.service.impl.ManagerinfoServiceImpl;
import com.iweb.util.PageModel;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ManagerServlet extends HttpServlet {
    private ManagerinfoService managerinfoService=new ManagerinfoServiceImpl();
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
            case "/queryAll.manager":
                queryAll(req,resp);
                break;
            case "/toAdd.manager":
                resp.sendRedirect(req.getContextPath()+"/manager/manager_toAdd.jsp");
                break;
            case "/addorupdate.manager":
                addorupdate(req,resp);
                break;
            case "/toUpdate.manager":
                toUpdate(req,resp);
                break;
            case "/toDelete.manager":
                toDelete(req,resp);
                break;
            case "/changePassword.manager":
                changePassword(req,resp);
                break;
            case "/toUpdatePassword.manager":
                toUpdatePassword(req,resp);
                break;
            default:
                break;
        }
    }

    private void queryAll(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        int pageNo=req.getParameter("pageNo")==null?1:Integer.parseInt(req.getParameter("pageNo"));
        String likeValue = req.getParameter("likeValue");
        PageModel pageModel = new PageModel();
        pageModel.setPageNo(pageNo);
        pageModel.setLikeValue(likeValue);
        List<Managerinfo> allCategory = managerinfoService.queryAllManagers(likeValue,pageModel);
        System.out.println(allCategory);
        pageModel.setPageData(allCategory);
        req.setAttribute("pageModel",pageModel);
        req.getRequestDispatcher("/manager/manager_selectByPage.jsp").forward(req, resp);
    }
    private void toDelete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String managerId = req.getParameter("managerId");
        Managerinfo managerinfo = managerinfoService.queryManagerById(Integer.valueOf(managerId));
        int i=managerinfoService.deleteOneManager(managerinfo.getManagerId());
        if (i>0){
            resp.sendRedirect(req.getContextPath()+"/queryAll.manager");
        }else {
            resp.sendRedirect(req.getContextPath()+"/errorpage/errorPage.jsp");
        }
    }
    private void toUpdate(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String managerId = req.getParameter("managerId");
        Managerinfo managerinfo = managerinfoService.queryManagerById(Integer.valueOf(managerId));
        req.setAttribute("managerinfo",managerinfo);
        req.getRequestDispatcher("/manager/manager_toAdd.jsp").forward(req, resp);
    }
    private void toUpdatePassword(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String managerId = req.getParameter("managerId");
        Managerinfo managerinfo = managerinfoService.queryManagerById(Integer.valueOf(managerId));
        req.setAttribute("managerinfo",managerinfo);
        req.getRequestDispatcher("/manager/manager_toUpdatePassword.jsp").forward(req, resp);
    }

    private void changePassword(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Integer managerId = Integer.valueOf(req.getParameter("managerId"));
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        System.out.println(newPassword);
        Managerinfo managerinfo = managerinfoService.queryManagerById(managerId);
        int i=-1;
        if (!oldPassword.equals(managerinfo.getManagerPassword())){
            System.out.println("原密码错误");
            // TODO: 2021/8/20 这里要加上ajax来动态验证密码准确性

        }else {
            managerinfo.setManagerPassword(newPassword);
            i = managerinfoService.updateOneManager(managerinfo);
        }
        if (i>0){
            resp.sendRedirect(req.getContextPath()+"/queryAll.manager");
        }else {
            resp.sendRedirect(req.getContextPath()+"/errorpage/errorPage.jsp");
        }
    }

    private void addorupdate(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession session=req.getSession();
        Object myflag = session.getAttribute("myflag");
        String flag = req.getParameter("flag");
        //如果有flag就删除
        if (myflag!=null&&!"".equals(myflag)&&myflag.equals(flag)){
            session.removeAttribute("myflag");
        }else {
            //重复提交
            resp.sendRedirect(req.getContextPath()+"/queryAll.manager");
            return;
        }
        String manageruserName = req.getParameter("manageruserName");
        // TODO: 2021/8/20 这里要验证用户名是否重复，方便后面修改
        String password = req.getParameter("password1");
        String managerfullname = req.getParameter("managerfullname");
        Integer managerId=null;
        if (req.getParameter("managerId")!=null&&!"".equals(req.getParameter("managerId"))){
            managerId = Integer.valueOf(req.getParameter("managerId"));
        }
        int i =-1;
        Managerinfo managerinfo = new Managerinfo(managerId, manageruserName, password, managerfullname, null);

        if (managerId!=null&&!"".equals(managerId)){
            i = managerinfoService.updateOneManager(managerinfo);
        }else {
            i = managerinfoService.saveOneManager(managerinfo);
        }
        if (i>0){
            resp.sendRedirect(req.getContextPath()+"/queryAll.manager");
        }else {
            resp.sendRedirect(req.getContextPath()+"/errorpage/errorPage.jsp");
        }
    }

}
