package com.iweb.service;

import com.iweb.pojo.FictionUser;
import com.iweb.pojo.Managerinfo;
import com.iweb.util.PageModel;

import java.util.List;

public interface FictionUserService {
    /**
     * 获取所有用户
     * @param likeValue
     * @param pageModel
     * @return
     */
    public List<FictionUser> getAllUsers(String likeValue, PageModel pageModel);

    /**
     * 通过id获取用户
     * @param id
     * @return
     */
    public FictionUser queryById(Integer id);


    /**
     * 保存用户
     * @param fictionUser
     * @return
     */
    public int saveOne(FictionUser fictionUser);

    /**
     * 更新用户
     * @param fictionUser
     * @return
     */
    public int updateOne(FictionUser fictionUser);

    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteOne(Integer id);
}
