package com.li.dao.categorydao.Impl;

import com.li.dao.categorydao.CateGoryDao;
import com.li.po.CateGory;
import com.li.utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CateGoryDaoImpl implements CateGoryDao {
    /**
     * 查询分类
     * @param cateGory
     * @return
     */
    public List<CateGory> queryClass(CateGory cateGory){
        List<CateGory> list=new ArrayList<CateGory>();
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;

        try {
            //建立连接
            conn= BaseDao.getConnection();
            String sql="SELECT *FROM category WHERE 1=1 ";
            if (cateGory!=null){
                //添加条件查询

            }
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            int num=1;
            if (cateGory!=null){
                //添加条件查询

            }
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                CateGory cateGory1=new CateGory(res.getInt(1),res.getString(2),res.getInt(3));
                list.add(cateGory1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return list;
    }
    /**
     * 添加分类
     * @param name
     * @param id
     * @return
     */
    public int addCate(String name ,int id){
        String sql="insert into category(cate_name,cate_parent_id) values(?,?) " ;
        Object[] objects={name,id};
        return  BaseDao.excuteUpdate(sql,objects);
    }
    /**
     * 通过id查找分类
     * @param id
     * @return
     */
    public CateGory findCateById(int id){
        CateGory cateGory=null;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;
        try {
            //建立连接
            conn= BaseDao.getConnection();
            String sql="SELECT *FROM category WHERE cate_id=? ";
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            pre.setObject(1,id);
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                cateGory=new CateGory(res.getInt(1),res.getString(2),res.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return cateGory;
    }
    /**
     * 修改分类
     * @param cateGory
     * @return
     */
    public int updateCate(CateGory cateGory){
        String sql =" update category set cate_name=?,cate_parent_id=? where cate_id=? ";
        Object[] objects={cateGory.getCateName(),cateGory.getCateParentId(),cateGory.getCateId()};
        return BaseDao.excuteUpdate(sql,objects);
    }

    /**
     * 通过id查询子分类的数量
     * @param id
     * @return
     */
    public int queryCateCount(int id){
        int i=0;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;
        try {
            //建立连接
            conn= BaseDao.getConnection();
            String sql="SELECT count(*)FROM category WHERE cate_parent_id=? ";
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            pre.setObject(1,id);
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
     * 通过分类id删除分类
     * @param id
     * @return
     */
    public int deleteCate(int id){
        String sql="delete from category where cate_id=?  ";
        Object[] objects={id};
        return BaseDao.excuteUpdate(sql,objects);
    }
}
