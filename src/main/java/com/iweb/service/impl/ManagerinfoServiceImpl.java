package com.iweb.service.impl;

import com.iweb.dao.ManagerinfoDAO;
import com.iweb.dao.impl.ManagerinfoDAOImpl;
import com.iweb.pojo.Managerinfo;
import com.iweb.service.ManagerinfoService;
import com.iweb.util.PageModel;

import java.util.List;

public class ManagerinfoServiceImpl implements ManagerinfoService {
    private ManagerinfoDAO managerinfoDAO=new ManagerinfoDAOImpl();
    /**
     * 检查用户名是否可用
     * null表示可以用，非null表示不可以用
     * @param ManagerName
     * @return
     */
    @Override
    public Managerinfo queryManagerByName(String ManagerName) {
        return managerinfoDAO.queryManagerByName(ManagerName);
    }

    /**
     * 根据id找管理员
     *
     * @param ManagerId
     * @return
     */
    @Override
    public Managerinfo queryManagerById(Integer ManagerId) {
        return managerinfoDAO.queryManagerById(ManagerId);

    }

    /**
     * 登录，null表示失败，非空表示成功
     *
     * @param ManagerName
     * @param password
     * @return
     */
    @Override
    public Managerinfo queryManagerByNameAndPassword(String ManagerName, String password) {
        return managerinfoDAO.queryManagerByNameAndPassword(ManagerName,password);
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
        return managerinfoDAO.queryAllManagers(likeValue,pageModel);
    }

    /**
     * 保存一个管理员
     *
     * @param managerinfo
     * @return
     */
    @Override
    public int saveOneManager(Managerinfo managerinfo) {
        return managerinfoDAO.saveOneManager(managerinfo);
    }

    /**
     * 修改管理员
     *
     * @param managerinfo
     * @return
     */
    @Override
    public int updateOneManager(Managerinfo managerinfo) {
        return managerinfoDAO.updateOneManager(managerinfo);
    }

    /**
     * 删除管理员
     *
     * @param managerId
     * @return
     */
    @Override
    public int deleteOneManager(Integer managerId) {
        return managerinfoDAO.deleteOneManager(managerId);
    }
}
