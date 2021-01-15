package com.li.dao.cart.Impl;

import com.li.dao.cart.CartDao;
import com.li.po.Cart;
import com.li.po.CateGory;
import com.li.utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    /**
     * 添加购物车
     * @param cart
     * @return
     */
    public int cartAdd(Cart cart){
        String sql="  INSERT INTO cart(cart_uid,cart_pid,cart_p_filename,cart_p_quantity,cart_p_count,cart_p_name,cart_p_price,cart_valid) VALUES(?,?,?,?,?,?,?,?) ";
        Object[] objects={cart.getCartUid(),cart.getCartPid(),cart.getCartPFilename(),cart.getCartPQuantity(),cart.getCartPCount(),cart.getCartPName(),cart.getCartPPrice(),cart.getCartValid()};
        return BaseDao.excuteUpdate(sql,objects);
    }
    /**
     * 通过用户id查询所有的订单
     * @param id
     * @return
     */
    public List<Cart> queryCartByUid(String id){
        List<Cart> list= new ArrayList<>();
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;
        try {
            //建立连接
            conn= BaseDao.getConnection();
            String sql=" select *from cart where cart_uid=? and cart_valid=1  ";
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            pre.setObject(1,id);
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                Cart cart=new Cart(
                        res.getInt(1),
                        res.getString(2),
                        res.getInt(3),
                        res.getString(4),
                        res.getInt(5),
                        res.getInt(6),
                        res.getString(7),
                        res.getDouble(8),
                        res.getInt(9)
                );
                list.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return list;
    }
    /**
     * 通过用户名和产品id查询购物车
     * @param uid
     * @param pid
     * @return
     */
    public Cart queryCartByUidAndPid(String uid,int pid){
        Cart cart=null;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;
        try {
            //建立连接
            conn= BaseDao.getConnection();
            String sql=" select *from cart where (cart_uid,cart_pid) = (?,?) and cart_valid=1  ";
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            pre.setObject(1,uid);
            pre.setObject(2,pid);
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                 cart=new Cart(
                        res.getInt(1),
                        res.getString(2),
                        res.getInt(3),
                        res.getString(4),
                        res.getInt(5),
                        res.getInt(6),
                        res.getString(7),
                        res.getDouble(8),
                        res.getInt(9)
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return cart;
    }
    /**
     * 修改购物车产品的数量
     * @param cart
     * @return
     */
    public int updateCartCount(Cart cart){
        int pq=cart.getCartPQuantity();
        String sql=" update cart set cart_p_quantity=?  where cart_id=? ";
        Object[] objects={pq,cart.getCartId()};
        return BaseDao.excuteUpdate(sql,objects);
    }
    /**
     * 根据购物车id查询购物车
     * @param id
     * @return
     */
    public Cart findCartById( int id){
        Cart cart=null;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;
        try {
            //建立连接
            conn= BaseDao.getConnection();
            String sql=" select *from cart where cart_id=? and  cart_valid=1";
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            pre.setObject(1,id);

            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                cart=new Cart(
                        res.getInt(1),
                        res.getString(2),
                        res.getInt(3),
                        res.getString(4),
                        res.getInt(5),
                        res.getInt(6),
                        res.getString(7),
                        res.getDouble(8),
                        res.getInt(9)
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return cart;

    }
    /**
     * 删除购物车
     * @param id
     * @return
     */
    public int deleteCart(int id){
        String sql=" delete from cart where cart_id=? ";
        Object[] objects={id};
        return BaseDao.excuteUpdate(sql,objects);
    }
}
