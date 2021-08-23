package com.iweb.dao;

import com.iweb.pojo.Managerinfo;
import com.iweb.util.PageModel;

import java.util.List;

public interface ManagerinfoDAO {

    /**
     * 通过姓名查找管理员，验证用户名
     * @param ManagerName
     * @return
     */
    public Managerinfo queryManagerByName(String ManagerName);

    /**
     * 根据id找管理员
     * @param ManagerId
     * @return
     */
    public Managerinfo queryManagerById(Integer ManagerId);

    /**
     * 通过用户名和昵称查找管理员，登录
     * @param ManagerName
     * @param password
     * @return
     */
    public Managerinfo queryManagerByNameAndPassword(String ManagerName,String password);

    /**
     * 查询所有管理员
     * @return
     */
    public List<Managerinfo> queryAllManagers(String likeValue, PageModel pageModel);

    /**
     * 保存一个管理员
     * @return
     */
    public int saveOneManager(Managerinfo managerinfo);

    /**
     * 修改管理员
     * @param managerinfo
     * @return
     */
    public int updateOneManager(Managerinfo managerinfo);


    /**
     * 删除管理员
     * @param managerId
     * @return
     */
    public int deleteOneManager(Integer managerId);


}
