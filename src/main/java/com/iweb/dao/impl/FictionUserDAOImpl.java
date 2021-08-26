package com.iweb.dao.impl;

import com.iweb.dao.BaseDAO;
import com.iweb.dao.FictionUserDAO;

import com.iweb.pojo.Category;
import com.iweb.pojo.FictionUser;
import com.iweb.pojo.Managerinfo;
import com.iweb.util.PageModel;

import java.util.List;

public class FictionUserDAOImpl extends BaseDAO implements FictionUserDAO {

    /**
     * 获取所有用户
     *
     * @param likeValue
     * @param pageModel
     * @return
     */
    @Override
    public List<FictionUser> getAllUsers(String likeValue, PageModel pageModel) {
        StringBuffer sql=new StringBuffer("SELECT userId,userName,userPassword,userfullname,movephone,memberdaycount FROM fictionuser ");
        StringBuffer sqlCount=new StringBuffer("SELECT COUNT(*) FROM fictionuser ");
        int pageSize = pageModel.getPageSize();
        int pageNo = pageModel.getPageNo();

        if (likeValue!=null&&!"".equals(likeValue)){
            sql.append("WHERE userId LIKE ? or userName LIKE ? or userfullname LIKE ? or movephone LIKE ? ");
            sql.append(" order by userId desc LIMIT "+(pageNo-1)*pageSize+","+pageSize);
            sqlCount.append("WHERE userId LIKE ? or userName LIKE ? or userfullname LIKE ? or movephone LIKE ? ");
            Long count = (Long) queryForSingleValue(sqlCount.toString(), "%" + likeValue + "%", "%" + likeValue + "%", "%" + likeValue + "%");
            if (count==null){
                pageModel.setRecordCount(1);
            }else {
                pageModel.setRecordCount(count.intValue());
            }
            return queryForList(FictionUser.class,sql.toString(),"%" + likeValue + "%", "%" + likeValue + "%", "%" + likeValue + "%");
        }else{
            sql.append(" order by userId desc LIMIT "+(pageNo-1)*pageSize+","+pageSize);
            Long count = (Long) queryForSingleValue(sqlCount.toString());
            if (count==null){
                pageModel.setRecordCount(1);
            }else {
                pageModel.setRecordCount(count.intValue());
            }
            return queryForList(FictionUser.class,sql.toString());
        }
    }

    /**
     * 通过id获取用户
     *
     * @param id
     * @return
     */
    @Override
    public FictionUser queryById(Integer id) {
        String sql="SELECT userId,userName,userPassword,userfullname,movephone,memberdaycount FROM fictionuser where userId=?";
        return queryForOne(FictionUser.class,sql,id);
    }

    /**
     * 保存用户
     *
     * @param fictionUser
     * @return
     */
    @Override
    public int saveOne(FictionUser fictionUser) {
        String sql="INSERT INTO fictionuser(userName,userPassword,userfullname,movephone,memberdaycount) VALUES(?,?,?,?,?)";
        return update(sql,fictionUser.getUserName(),fictionUser.getUserPassword(),fictionUser.getUserFullName(),fictionUser.getMovephone(),fictionUser.getMemberdayCount());
    }

    /**
     * 更新用户
     *
     * @param fictionUser
     * @return
     */
    @Override
    public int updateOne(FictionUser fictionUser) {
        String sql="UPDATE fictionuser SET userfullname=?,movephone=?,memberdaycount=? WHERE userId=?";
        return update(sql,fictionUser.getUserFullName(),fictionUser.getMovephone(),fictionUser.getMemberdayCount(),fictionUser.getUserId());
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public int deleteOne(Integer id) {
        String sql="DELETE FROM fictionuser WHERE userId=?";
        return update(sql,id);
    }
}
