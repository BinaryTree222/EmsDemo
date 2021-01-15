package com.li.dao.userdao.Impl;

import com.li.dao.userdao.UserDao;
import com.li.po.User;
import com.li.utils.BaseDao;
import com.li.utils.PageInfo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /**
     * 添加用户
     */
    public int addUser(User user){
        String sql="INSERT INTO yahui(user_id,user_name,user_password,user_sex,user_birthday,user_email,user_mobile,user_address,user_status)VALUES(?,?,?,?,?,?,?,?,?)";
        Object[] objects={user.getUserId(),user.getUserName(),user.getUserPassword(),user.getUserSex(),user.getUserBirthday(),user.getUserEmail(),user.getUserMobile(),user.getUserAddress(),user.getUserStatus()};
        return BaseDao.excuteUpdate(sql,objects);
    }
    /**
     * 分压查询用户
     * @param pageInfo
     * @param user
     * @return
     */
    public List<User> queryPage(PageInfo pageInfo, User user){
        List<User> list=new ArrayList<User>();
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;

        try {
            //建立连接
            conn=BaseDao.getConnection();
            String sql="SELECT *FROM yahui WHERE 1=1 ";
            if (user!=null){
              //添加条件查询
                //条件为用户名，模糊查询
                if (user.getUserId()!=null){
                    sql=sql+"  and user_id like ?  ";
                }
            }
            sql=sql+"  limit ?,? ";
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            int num=1;
            if (user!=null){
                //添加条件查询
                //条件为用户名，模糊查询
                if (user.getUserId()!=null){
                    pre.setObject(num++,"%"+user.getUserId()+"%");
                }
            }
            int begin=(pageInfo.getCurPageNo()-1)*pageInfo.getPageSize();
            int end=pageInfo.getPageSize();
            pre.setObject(num++,begin);
            pre.setObject(num++,end);
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                User user1=new User();
                user1.setUserId(res.getString(1));
                user1.setUserName(res.getString(2));
                user1.setUserPassword(res.getString(3));
                user1.setUserSex(res.getString(4));
                user1.setUserBirthday(res.getDate(5));
                user1.setUserEmail(res.getString(7));
                user1.setUserMobile(res.getString(8));
                user1.setUserAddress(res.getString(9));
                user1.setUserStatus(res.getInt(10));
                list.add(user1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return list;
    }
    /**
     * 获得分页查询的总页数
     * @param user
     * @return
     */
    public int getPageCount(User user){
        int i=0;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;

        try {
            //建立连接
            conn=BaseDao.getConnection();
            String sql="SELECT count(*)FROM yahui WHERE 1=1 ";
            if (user!=null){
              //添加条件查询
                //条件为用户名，模糊查询
                if (user.getUserId()!=null){
                    sql=sql+" and user_id like ?  ";
                }
            }

            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            if (user!=null){
                //添加条件查询
                //条件为用户名，模糊查询
                if (user.getUserId()!=null){
                    pre.setObject(1, "%"+user.getUserId()+"%");
                }
            }
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                i=res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return i;
    }
    /**
     * 通过用户id查询用户
     * @param id
     * @return
     */
    public User findUserById(String id){
        User user=null;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;

        try {
            //建立连接
            conn=BaseDao.getConnection();
            String sql="SELECT *FROM yahui WHERE user_id= ? ";
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            pre.setObject(1,id);
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                user=new User();
                user.setUserId(res.getString(1));
                user.setUserName(res.getString(2));
                user.setUserPassword(res.getString(3));
                user.setUserSex(res.getString(4));
                user.setUserBirthday(res.getDate(5));
                user.setUserEmail(res.getString(7));
                user.setUserMobile(res.getString(8));
                user.setUserAddress(res.getString(9));
                user.setUserStatus(res.getInt(10));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return user;
    }
    /**
     * 修改用户
     * @param user
     * @return
     */
    public int updateUser(User user){
        String sql="UPDATE  yahui SET user_name=?,user_password=?,user_sex=?,user_birthday=?,user_email=?,user_mobile=?,user_address=?  WHERE user_id= ?";
        Object[] objects={user.getUserName(),user.getUserPassword(),user.getUserSex(),user.getUserBirthday(),user.getUserEmail(),user.getUserMobile(),user.getUserAddress(),user.getUserId()};
        return BaseDao.excuteUpdate(sql,objects);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteUser(String id){
        String sql=" delete from yahui where user_id= ? ";
        Object[] objects={id};
        return BaseDao.excuteUpdate(sql,objects);
    }
    /**
     * 注册时检查用户名
     * @param userName
     * @return
     */
    public int checkUserName(String userName){
        int i=0;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;

        try {
            //建立连接
            conn=BaseDao.getConnection();
            String sql="SELECT count(*)FROM yahui WHERE user_id=? ";


            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            pre.setObject(1,userName);
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                i=res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return i;

    }
    /**
     * 注册用户
     * @param user
     * @return
     */
    public int regUser(User user){
        String sql="INSERT INTO yahui(user_id,user_name,user_password,user_sex,user_birthday,user_email,user_mobile,user_address,user_status)VALUES(?,?,?,?,?,?,?,?,?)";
        Object[] objects={user.getUserId(),user.getUserName(),user.getUserPassword(),user.getUserSex(),user.getUserBirthday(),user.getUserEmail(),user.getUserMobile(),user.getUserAddress(),user.getUserStatus()};
        return BaseDao.excuteUpdate(sql,objects);
    }
    /**
     * 用户登录
     * @param name
     * @param pwd
     * @return
     */
    public User login(String name ,String pwd){

       User user=null;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;

        try {
            //建立连接
            conn=BaseDao.getConnection();
            String sql="select * from yahui where user_id=? and user_password=? ";
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            pre.setObject(1,name);
            pre.setObject(2,pwd);
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                user=new User();
                user.setUserId(res.getString(1));
                user.setUserName(res.getString(2));
                user.setUserPassword(res.getString(3));
                user.setUserSex(res.getString(4));
                user.setUserBirthday(res.getDate(5));
                user.setUserEmail(res.getString(7));
                user.setUserMobile(res.getString(8));
                user.setUserAddress(res.getString(9));
                user.setUserStatus(res.getInt(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return user;
    }
    /**
     * 管理员用户登录
     * @param name
     * @param pwd
     * @return
     */
    public User loginBack(String name , String pwd){
        User user=null;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;

        try {
            //建立连接
            conn=BaseDao.getConnection();
            String sql="select * from yahui where (user_id,user_password,user_status)=(?,?,2)  ";
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            pre.setObject(1,name);
            pre.setObject(2,pwd);
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                user=new User();
                user.setUserId(res.getString(1));
                user.setUserName(res.getString(2));
                user.setUserPassword(res.getString(3));
                user.setUserSex(res.getString(4));
                user.setUserBirthday(res.getDate(5));
                user.setUserEmail(res.getString(7));
                user.setUserMobile(res.getString(8));
                user.setUserAddress(res.getString(9));
                user.setUserStatus(res.getInt(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return user;
    }
}
