package com.iweb.test;

import com.iweb.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class jdbcTest {
    @Test
    public void test() throws Exception {
        for (int i = 0; i < 10; i++) {
            Connection connection = JDBCUtils.getConnection();
            System.out.println(connection);
            JDBCUtils.closeConnection(connection);
        }
    }
}
