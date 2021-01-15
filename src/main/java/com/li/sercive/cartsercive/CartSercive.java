package com.li.sercive.cartsercive;

import com.li.po.Cart;

import java.util.List;

public interface CartSercive {
    /**
     * 添加购物车
     * @param cart
     * @return
     */
    int cartAdd(Cart cart);
    /**
     * 通过用户id查询所有的订单
     * @param id
     * @return
     */
    List<Cart> queryCartByUid(String id);
    /**
     * 通过用户名和产品id查询购物车
     * @param uid
     * @param pid
     * @return
     */
    Cart queryCartByUidAndPid(String uid,int pid);
    /**
     * 修改购物车产品的数量
     * @param cart
     * @return
     */
    int updateCartCount(Cart cart);
    /**
     * 根据购物车id查询购物车
     * @param id
     * @return
     */
    Cart findCartById( int id);
    /**
     * 删除购物车
     * @param id
     * @return
     */
    int deleteCart(int id);
}
