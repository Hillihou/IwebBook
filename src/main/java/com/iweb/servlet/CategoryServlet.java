package com.iweb.servlet;
import com.iweb.pojo.Category;
import com.iweb.service.CategoryService;
import com.iweb.service.impl.CategoryServiceImpl;
import com.iweb.util.PageModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
 public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService=new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
     }
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getParameter()

         //获取请求参数之前转码，保证java内不乱码
        req.setCharacterEncoding("UTF-8");
        //得到urlpattern
        String path=req.getServletPath();
        System.out.println(path);
        switch (path){
            case "/queryAll.category":
                queryAll(req,resp);
                break;
            case "/toAdd.category":
                resp.sendRedirect(req.getContextPath()+"/category_toAdd.jsp");
                break;
            case "/addorupdate.category":
                addorupdate(req,resp);
                break;
            case "/toUpdate.category":
                toUpdate(req,resp);
                break;
            case "/toDelete.category":
                toDelete(req,resp);
                break;
            case "/logout.category":
                toLogout(req, resp);
                break;
            default:
                queryAll(req,resp);
                break;
        }
     }
     /**
     * 查询列表，解耦合
     */
    private void queryAll(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        int pageNo=req.getParameter("pageNo")==null?1:Integer.parseInt(req.getParameter("pageNo"));
        String likeValue = req.getParameter("likeValue");
        PageModel pageModel = new PageModel();
        pageModel.setPageNo(pageNo);
        pageModel.setLikeValue(likeValue);
        List<Category> allCategory = categoryService.getAllCategory(likeValue,pageModel);
        pageModel.setPageData(allCategory);
        req.setAttribute("pageModel",pageModel);
        req.getRequestDispatcher("/categoryList.jsp").forward(req, resp);
    }
     private void addorupdate(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
         HttpSession session=req.getSession();
         Object myflag = session.getAttribute("myflag");
         String flag = req.getParameter("flag");
         //如果有flag就删除
         if (myflag!=null&&!"".equals(myflag)&&myflag.equals(flag)){
             session.removeAttribute("myflag");
         }else {
             //重复提交
             resp.sendRedirect(req.getContextPath()+"/queryAll.category");
             return;
         }
         String categoryName = req.getParameter("categoryName");
        String description = req.getParameter("description");
        Integer categoryId=null;
        if (req.getParameter("categoryId")!=null&&!"".equals(req.getParameter("categoryId"))){
            categoryId = Integer.valueOf(req.getParameter("categoryId"));
        }
        int i =-1;
           Category category = new Category(categoryId,categoryName,null,description);
         if (categoryId!=null&&!"".equals(categoryId)){
            i = categoryService.updateOne(category);
        }else {
            i = categoryService.saveOne(category);
        }
         if (i>0){
            resp.sendRedirect(req.getContextPath()+"/queryAll.category");
        }else {
            resp.sendRedirect(req.getContextPath()+"/errorpage/errorPage.jsp");
        }
     }
     private void toUpdate(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String categoryId = req.getParameter("categoryId");
        Category category = categoryService.queryById(Integer.valueOf(categoryId));
        req.setAttribute("category",category);
        req.getRequestDispatcher("/category_toAdd.jsp").forward(req, resp);
     }
     private void toDelete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String categoryId = req.getParameter("categoryId");
        Category category = categoryService.queryById(Integer.valueOf(categoryId));
        int i=categoryService.deleteOne(category.getCategoryId());
        if (i>0){
            resp.sendRedirect(req.getContextPath()+"/queryAll.category");
        }else {
            resp.sendRedirect(req.getContextPath()+"/errorpage/errorPage.jsp");
        }
    }
    private void toLogout(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
}
