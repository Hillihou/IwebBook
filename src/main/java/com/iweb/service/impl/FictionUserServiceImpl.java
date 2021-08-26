package com.iweb.service.impl;

import com.iweb.dao.FictionUserDAO;
import com.iweb.dao.impl.FictionUserDAOImpl;
import com.iweb.pojo.FictionUser;
import com.iweb.pojo.Managerinfo;
import com.iweb.service.FictionUserService;
import com.iweb.util.PageModel;

import java.util.List;

public class FictionUserServiceImpl implements FictionUserService {
        private FictionUserDAO fictionUserDAO=new FictionUserDAOImpl();

    /**
     * 获取所有用户
     *
     * @param likeValue
     * @param pageModel
     * @return
     */
    @Override
    public List<FictionUser> getAllUsers(String likeValue, PageModel pageModel) {
        return fictionUserDAO.getAllUsers(likeValue,pageModel);
    }

    /**
     * 通过id获取用户
     *
     * @param id
     * @return
     */
    @Override
    public FictionUser queryById(Integer id) {
        return fictionUserDAO.queryById(id);
    }

    /**
     * 保存用户
     *
     * @param fictionUser
     * @return
     */
    @Override
    public int saveOne(FictionUser fictionUser) {
        return fictionUserDAO.saveOne(fictionUser);
    }

    /**
     * 更新用户
     *
     * @param fictionUser
     * @return
     */
    @Override
    public int updateOne(FictionUser fictionUser) {
        return fictionUserDAO.updateOne(fictionUser);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public int deleteOne(Integer id) {
        return fictionUserDAO.deleteOne(id);
    }
}
