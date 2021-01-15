package com.li.sercive.userSercive;

import com.li.po.CateGory;
import com.li.po.User;
import com.li.utils.PageInfo;

import java.util.List;

public interface UserSercive {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);
    /**
     * 分压查询用户
     * @param pageInfo
     * @param user
     * @return
     */
    List<User> queryPage(PageInfo pageInfo, User user);
    /**
     * 获得分页查询的总页数
     * @param user
     * @return
     */
    int getPageCount(User user);
    /**
     * 通过用户id查询用户
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);
    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(String id);
    /**
     * 注册时检查用户名
     * @param userName
     * @return
     */
    int checkUserName(String userName);
    /**
     * 注册用户
     * @param user
     * @return
     */
    int regUser(User user);
    /**
     * 用户登录
     * @param name
     * @param pwd
     * @return
     */
    User login(String name ,String pwd);
    /**
     * 管理员用户登录
     * @param name
     * @param pwd
     * @return
     */
    User loginBack(String name , String pwd);


}
