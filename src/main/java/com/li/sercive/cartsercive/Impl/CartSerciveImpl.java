package com.li.sercive.cartsercive.Impl;

import com.li.dao.cart.CartDao;
import com.li.dao.cart.Impl.CartDaoImpl;
import com.li.po.Cart;
import com.li.sercive.cartsercive.CartSercive;

import java.util.List;

public class CartSerciveImpl implements CartSercive {
   private CartDao cartDao=new CartDaoImpl();
    /**
     * 添加购物车
     * @param cart
     * @return
     */
    public int cartAdd(Cart cart){
        return cartDao.cartAdd(cart);
    }
    /**
     * 通过用户id查询所有的订单
     * @param id
     * @return
     */
    public List<Cart> queryCartByUid(String id){
        return cartDao.queryCartByUid(id);
    }
    /**
     * 通过用户名和产品id查询购物车
     * @param uid
     * @param pid
     * @return
     */
    public Cart queryCartByUidAndPid(String uid,int pid){
        return cartDao.queryCartByUidAndPid(uid, pid);
    }
    /**
     * 修改购物车产品的数量
     * @param cart
     * @return
     */
    public int updateCartCount(Cart cart){
        return cartDao.updateCartCount(cart);
    }
    /**
     * 根据购物车id查询购物车
     * @param id
     * @return
     */
    public Cart findCartById( int id){
        return cartDao.findCartById(id);
    }
    /**
     * 删除购物车
     * @param id
     * @return
     */
    public int deleteCart(int id){
        return cartDao.deleteCart(id);
    }

}
