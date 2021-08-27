package com.iweb.service.impl;

import com.iweb.dao.FictionDAO;
import com.iweb.dao.impl.FictionDAOImpl;
import com.iweb.pojo.Fiction;
import com.iweb.service.FictionService;
import com.iweb.util.PageModel;

import java.util.List;

public class FictionServiceImpl implements FictionService {
    private FictionDAO fictionDAO=new FictionDAOImpl();
    @Override
    public List<Fiction> getFictions(String likeValue, PageModel pageModel) {
        return fictionDAO.getFictions(likeValue,pageModel);
    }

    @Override
    public Fiction queryById(Integer id) {
        return null;
    }

    @Override
    public int saveOne(Fiction fiction) {
        return 0;
    }

    @Override
    public int updateOne(Fiction fiction) {
        return 0;
    }

    @Override
    public int deleteOne(Integer id) {
        return 0;
    }
}
