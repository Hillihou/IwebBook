package com.iweb.test;

import com.iweb.dao.impl.FictionDAOImpl;
import com.iweb.util.PageModel;
import junit.framework.TestCase;

public class FictionDAOImplTest extends TestCase {
private FictionDAOImpl fictionDAO=new FictionDAOImpl();
    public void testGetFictions() {
        System.out.println(fictionDAO.getFictions("", new PageModel(1, 2, 1, 1, null, null)));
    }

    public void testQueryById() {

    }

    public void testSaveOne() {
    }

    public void testUpdateOne() {
    }

    public void testDeleteOne() {
    }
}