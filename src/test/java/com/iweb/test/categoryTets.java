package com.iweb.test;

import com.iweb.dao.impl.CategoryDAOImpl;
import com.iweb.pojo.Category;
import com.iweb.util.PageModel;
import org.junit.Test;

import java.util.List;

public class categoryTets {
    @Test
    public void test(){
        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        PageModel pageModel = new PageModel();
        pageModel.setPageSize(6);
        pageModel.setPageNo(1);

        List<Category> allCategory = categoryDAO.getAllCategory("",pageModel);
        allCategory.forEach(System.out::println);

    }

    @Test
    public void test1(){
        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        Category info = categoryDAO.queryById(1);
        System.out.println(info);

    }

    @Test
    public void test2(){
        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        System.out.println(categoryDAO.saveOne(new Category(1, "童话小说", null, "给孩子看的小说")));

    }

}
