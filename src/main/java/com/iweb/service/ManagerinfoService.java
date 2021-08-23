package com.iweb.service;

import com.iweb.pojo.Managerinfo;
import com.iweb.util.PageModel;

import java.util.List;

public interface ManagerinfoService {

    /**
     * 检查用户名是否可用
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
     * 登录，null表示失败，非空表示成功
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
