package com.iweb.service.impl;

import com.iweb.dao.CategoryDAO;
import com.iweb.dao.impl.CategoryDAOImpl;
import com.iweb.pojo.Category;
import com.iweb.service.CategoryService;
import com.iweb.util.PageModel;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO=new CategoryDAOImpl();
    /**
     * 查询全部类别
     *
     * @return
     */
    @Override
    public List<Category> getAllCategory(String likeValue, PageModel pageModel) {
        List<Category> allCategory = categoryDAO.getAllCategory(likeValue, pageModel);
        if (allCategory==null){
            System.out.println("空的");
        }
        return allCategory;
    }

    /**
     * -根据id查询类别
     *
     * @param id
     */
    @Override
    public Category queryById(Integer id) {
        return categoryDAO.queryById(id);
    }

    /**
     * 保存一个记录
     *
     * @param category
     */
    @Override
    public int saveOne(Category category) {
        return categoryDAO.saveOne(category);
    }

    /**
     * 修改一个记录
     *
     * @param category
     * @return
     */
    @Override
    public int updateOne(Category category) {
        return categoryDAO.updateOne(category);
    }

    /**
     * 删除一条记录
     *
     * @param id
     * @return
     */
    @Override
    public int deleteOne(Integer id) {
        return categoryDAO.deleteOne(id);
    }
}
