package com.iweb.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    /**
     * 获取数据库连接池连接
     */
    private static DataSource ds;
    static {
        try {
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception{
        Connection conn = ds.getConnection();
        return conn;
    }

//    public static Connection getConnection() throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/fiction?rewriteBatchedStatements=true","root","123456");
//    }

    public static void closeConnection(Connection connection){
        DbUtils.closeQuietly(connection);
    }


}
