package com.iweb.service;

import com.iweb.pojo.Fiction;
import com.iweb.util.PageModel;

import java.util.List;

public interface FictionService {
    /**
     * 获取所有小说
     * @param likeValue
     * @param pageModel
     * @return
     */
    public List<Fiction> getFictions(String likeValue, PageModel pageModel);

    /**
     * 通过id获取小说
     * @param id
     * @return
     */
    public Fiction queryById(Integer id);


    /**
     * 保存小说
     * @param fiction
     * @return
     */
    public int saveOne(Fiction fiction);

    /**
     * 更新小说
     * @param fiction
     * @return
     */
    public int updateOne(Fiction fiction);

    /**
     * 删除小说
     * @param id
     * @return
     */
    public int deleteOne(Integer id);

}
