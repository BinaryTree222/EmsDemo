package com.li.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String user;
    private static String pwd;

    static{
        //创建properties对象
        Properties p=new Properties();
        //读取db配置文件
        //资源路劲
        String path="db.properties";
        //加载资源
        InputStream inputStream=BaseDao.class.getClassLoader().getResourceAsStream(path);
        //properties加载资源
        try {
          p.load(inputStream );
        } catch (IOException e) {
            e.printStackTrace();
        }
        //赋值
        driver=p.getProperty("driver");
        url=p.getProperty("url");
        user=p.getProperty("user");
        pwd=p.getProperty("pwd");

        //加载驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    //得到连接
    public static Connection getConnection(){
        Connection c=null;
        try {
            c= DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    //close all
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //封装DML
    public static int excuteUpdate(String sql,Object[] objects){
        int i=0;
        //得到连接
        Connection connection=getConnection();
        //执行语句
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            //占位符赋值
            for (int j=0;j<objects.length;j++){
                preparedStatement.setObject(j+1,objects[j]);
            }
            //执行
            i=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,preparedStatement,null);
        }
        return i;
    }


}
