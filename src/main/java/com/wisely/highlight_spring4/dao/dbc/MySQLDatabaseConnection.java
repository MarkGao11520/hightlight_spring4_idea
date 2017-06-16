package com.wisely.highlight_spring4.dao.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by gaowenfeng on 2017/6/2.
 */
public class MySQLDatabaseConnection implements DatabaseConnection{

    private Connection conn = null;
    public MySQLDatabaseConnection() throws Exception{
        try {
            Properties properties = new Properties();   //实例化properties加载类
            properties.load(getClass().getResourceAsStream(
                    "../../../../../jdbcConfig.properties"));   //找到该文件
            String driverName = properties.getProperty("driverClassName");   //获取属性文件中的内容
            String url = properties.getProperty("url");
            String uname = properties.getProperty("username");
            String upwd = properties.getProperty("password");
            Class.forName(driverName);
            this.conn = DriverManager.getConnection(url,uname,upwd);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Connection getConnection() {
        return this.conn;
    }

    @Override
    public void close() throws Exception{
        if(this.conn!=null){
            try {
                this.conn.close();
            }catch (Exception e){
                throw e;
            }
        }
    }
}
