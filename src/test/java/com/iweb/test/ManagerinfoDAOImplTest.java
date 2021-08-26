package com.iweb.test;

import com.iweb.dao.impl.ManagerinfoDAOImpl;
import com.iweb.pojo.Managerinfo;
import com.iweb.util.PageModel;
import org.junit.Test;

public class ManagerinfoDAOImplTest {
    private ManagerinfoDAOImpl managerinfoDAO=new ManagerinfoDAOImpl();

    @Test
    public void queryManagerByName() {
        System.out.println(managerinfoDAO.queryManagerByName("张三"));
    }

    @Test
    public void queryManagerById() {
        System.out.println(managerinfoDAO.queryManagerById(1));
    }

    @Test
    public void queryManagerByNameAndPassword() {
        System.out.println(managerinfoDAO.queryManagerByNameAndPassword("张三", "123456"));
    }

    @Test
    public void queryAllManagers() {
        System.out.println(managerinfoDAO.queryAllManagers("", new PageModel(1, 2, 1, 1, null, null)));
    }

    @Test
    public void saveOneManager() {
        int i = managerinfoDAO.saveOneManager(new Managerinfo(null, "lolo", "123564", "suso", null));
        System.out.println(i);
    }

    @Test
    public void updateOneManager() {
        System.out.println(managerinfoDAO.updateOneManager(new Managerinfo(14, "loo", "1235614", "suso", null)));
    }

    @Test
    public void deleteOneManager() {
        managerinfoDAO.deleteOneManager(14);
    }
}

