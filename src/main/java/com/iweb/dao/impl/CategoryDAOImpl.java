package com.iweb.dao.impl;

import com.iweb.dao.BaseDAO;
import com.iweb.dao.CategoryDAO;
import com.iweb.pojo.Category;
import com.iweb.util.PageModel;
import jdk.nashorn.internal.objects.annotations.Where;

import java.sql.Date;
import java.util.List;

public class CategoryDAOImpl extends BaseDAO implements CategoryDAO {


    /**
     * 查询全部类别
     *
     * @return
     */
    @Override
    public List<Category> getAllCategory(String likeValue, PageModel pageModel) {
        StringBuffer sql=new StringBuffer("select categoryid,categoryName,createTime,`desc` from Category ");
        int pageSize = pageModel.getPageSize();
        int pageNo = pageModel.getPageNo();

        StringBuffer sqlCount=new StringBuffer("select count(*) from Category ");
        if (likeValue!=null && !"".equals(likeValue)){
            sqlCount.append("where categoryid like ? or categoryName like ? or `desc` like ? ");
            Long count = (Long) queryForSingleValue(sqlCount.toString(),"%"+likeValue+"%","%"+likeValue+"%","%"+likeValue+"%");
            if (count==null){
                pageModel.setRecordCount(1);
            }else {
                pageModel.setRecordCount(count.intValue());
            }
        }else {
            Long count = (Long) queryForSingleValue(sqlCount.toString());
            if (count==null){
                pageModel.setRecordCount(1);
            }else {
                pageModel.setRecordCount(count.intValue());
            }
        }


        if (likeValue!=null && !"".equals(likeValue)){
            sql.append("where categoryid like ? or categoryName like ? or `desc` like ? ");
            sql.append(" order by categoryid desc LIMIT "+(pageNo-1)*pageSize+","+pageSize);
            return queryForList(Category.class,sql.toString(),"%"+likeValue+"%","%"+likeValue+"%","%"+likeValue+"%");
        }else {
            sql.append(" order by categoryid desc LIMIT "+(pageNo-1)*pageSize+","+pageSize);
            return queryForList(Category.class,sql.toString());
        }




    }

    /**
     * -根据id查询类别
     *
     * @param id
     */
    @Override
    public Category queryById(Integer id) {
        String sql="select categoryid,categoryName,createTime,`desc` from Category where categoryid=?";
        return queryForOne(Category.class,sql,id);
    }

    /**
     * 保存一个记录
     *
     * @param category
     */
    @Override
    public int saveOne(Category category) {
        String sql="insert into Category(categoryName,createTime,`desc`) values(?,NOW(),?)";
        return update(sql,category.getCategoryName(),category.getDesc());
    }

    /**
     * 修改一个记录
     *
     * @param category
     * @return
     */
    @Override
    public int updateOne(Category category) {
        String sql="update Category set categoryName=? ,`desc`=? where categoryid=?";
        return update(sql,category.getCategoryName(),category.getDesc(),category.getCategoryId());
    }

    /**
     * 删除一条记录
     *
     * @param id
     * @return
     */
    @Override
    public int deleteOne(Integer id) {
        String sql="delete from Category where categoryid=?";
        return update(sql,id);
    }
}
