package com.iweb.dao.impl;

import com.iweb.dao.BaseDAO;
import com.iweb.dao.ManagerinfoDAO;
import com.iweb.pojo.Managerinfo;
import com.iweb.util.PageModel;

import java.util.List;

public class ManagerinfoDAOImpl extends BaseDAO implements ManagerinfoDAO {


    /**
     * 通过姓名查找管理员，验证用户名
     *
     * @param ManagerName
     * @return
     */
    @Override
    public Managerinfo queryManagerByName(String ManagerName) {
        String sql="SELECT managerId,manageruserName,managerPassword,managerfullname,createTime FROM managerinfo WHERE manageruserName LIKE ?";
        return queryForOne(Managerinfo.class,sql,ManagerName);
    }

    /**
     * 根据id找管理员
     *
     * @param ManagerId
     * @return
     */
    @Override
    public Managerinfo queryManagerById(Integer ManagerId) {
        String sql="SELECT managerId,manageruserName,managerPassword,managerfullname,createTime FROM managerinfo WHERE managerId=?";
        return queryForOne(Managerinfo.class,sql,ManagerId);
    }

    /**
     * 通过用户名和昵称查找管理员，登录
     *
     * @param ManagerName
     * @param password
     * @return
     */
    @Override
    public Managerinfo queryManagerByNameAndPassword(String ManagerName, String password) {
        String sql="SELECT managerId,manageruserName,managerPassword,managerfullname,createTime FROM managerinfo WHERE manageruserName LIKE ? and managerPassword LIKE ?";
        return queryForOne(Managerinfo.class,sql,ManagerName,password);
    }

    /**
     * 查询所有管理员
     *
     * @param likeValue
     * @param pageModel
     * @return
     */
    @Override
    public List<Managerinfo> queryAllManagers(String likeValue, PageModel pageModel) {
        StringBuffer sql=new StringBuffer("SELECT managerId,manageruserName,managerPassword,managerfullname,createTime FROM managerinfo ");
        StringBuffer sqlCount=new StringBuffer("SELECT COUNT(*) FROM managerinfo ");
        int pageSize = pageModel.getPageSize();
        int pageNo = pageModel.getPageNo();

        if (likeValue!=null&&!"".equals(likeValue)){
            sql.append("WHERE manageruserName LIKE ? or managerfullname LIKE ? or managerId LIKE ? ");
            sql.append(" order by managerId desc LIMIT "+(pageNo-1)*pageSize+","+pageSize);
            sqlCount.append("WHERE manageruserName LIKE ? or managerfullname LIKE ? or managerId LIKE ? ");
            Long count = (Long) queryForSingleValue(sqlCount.toString(), "%" + likeValue + "%", "%" + likeValue + "%", "%" + likeValue + "%");
            if (count==null){
                pageModel.setRecordCount(1);
            }else {
                pageModel.setRecordCount(count.intValue());
            }
            return queryForList(Managerinfo.class,sql.toString(),"%" + likeValue + "%", "%" + likeValue + "%", "%" + likeValue + "%");
        }else{
            sql.append(" order by managerId desc LIMIT "+(pageNo-1)*pageSize+","+pageSize);
            Long count = (Long) queryForSingleValue(sqlCount.toString());
            if (count==null){
                pageModel.setRecordCount(1);
            }else {
                pageModel.setRecordCount(count.intValue());
            }
            return queryForList(Managerinfo.class,sql.toString());
        }




    }

    /**
     * 保存一个管理员
     *
     * @param managerinfo
     * @return
     */
    @Override
    public int saveOneManager(Managerinfo managerinfo) {
        String sql="INSERT into managerinfo(manageruserName,managerPassword,managerfullname,createTime) VALUES(?,?,?,NOW())";
        return update(sql,managerinfo.getManageruserName(),managerinfo.getManagerPassword(),managerinfo.getManagerfullname());
    }

    /**
     * 修改管理员
     *
     * @param managerinfo
     * @return
     */
    @Override
    public int updateOneManager(Managerinfo managerinfo) {
        String sql="UPDATE managerinfo SET manageruserName=?,managerPassword=?,managerfullname=? WHERE managerId=?";
        return update(sql,managerinfo.getManageruserName(),managerinfo.getManagerPassword(),managerinfo.getManagerfullname(),managerinfo.getManagerId());
    }

    /**
     * 删除管理员
     *
     * @param managerId
     * @return
     */
    @Override
    public int deleteOneManager(Integer managerId) {
        String sql="DELETE FROM managerinfo WHERE managerId=?";
        return update(sql,managerId);
    }
}
