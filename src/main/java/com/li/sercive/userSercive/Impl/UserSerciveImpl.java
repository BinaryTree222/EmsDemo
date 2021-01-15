package com.li.sercive.userSercive.Impl;

import com.li.dao.userdao.Impl.UserDaoImpl;
import com.li.dao.userdao.UserDao;
import com.li.po.User;
import com.li.sercive.userSercive.UserSercive;
import com.li.utils.PageInfo;

import java.util.List;

public class UserSerciveImpl implements UserSercive {
    private UserDao userDao=new UserDaoImpl();
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user){
        return userDao.addUser(user);
    }
    /**
     * 分压查询用户
     * @param pageInfo
     * @param user
     * @return
     */
    public List<User> queryPage(PageInfo pageInfo, User user){
        return userDao.queryPage(pageInfo, user);
    }
    /**
     * 获得分页查询的总页数
     * @param user
     * @return
     */
    public int getPageCount(User user){
        return userDao.getPageCount(user);
    }
    /**
     * 通过用户id查询用户
     * @param id
     * @return
     */
    public User findUserById(String id){
        return userDao.findUserById(id);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    public int updateUser(User user){
        return userDao.updateUser(user);
    }
    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteUser(String id){
        return userDao.deleteUser(id);
    }
    /**
     * 注册时检查用户名
     * @param userName
     * @return
     */
    public int checkUserName(String userName){
        return userDao.checkUserName(userName);
    }
    /**
     * 注册用户
     * @param user
     * @return
     */
    public int regUser(User user){
        return userDao.regUser(user);
    }
    /**
     * 用户登录
     * @param name
     * @param pwd
     * @return
     */
    public User login(String name ,String pwd){
        return userDao.login(name, pwd);
    }
    /**
     * 管理员用户登录
     * @param name
     * @param pwd
     * @return
     */
    public User loginBack(String name , String pwd){
        return userDao.loginBack(name, pwd);
    }

}
