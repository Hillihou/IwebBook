package com.iweb.service;

import com.iweb.pojo.Category;
import com.iweb.util.PageModel;

import java.util.List;

public interface CategoryService {
    /**
     * 查询全部类别
     * @return
     */
    public List<Category> getAllCategory(String likeValue, PageModel pageModel);

    /**
     * -根据id查询类别
     */
    public Category queryById(Integer id);


    /**
     * 保存一个记录
     */
    public int saveOne(Category category);

    /**
     * 修改一个记录
     * @param category
     * @return
     */
    public int updateOne(Category category);

    /**
     * 删除一条记录
     * @param id
     * @return
     */
    public int deleteOne(Integer id);
}
