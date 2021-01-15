package com.li.dao.productdao.Impl;

import com.li.dao.productdao.ProductDao;
import com.li.po.CateGory;
import com.li.po.Product;
import com.li.po.User;
import com.li.utils.BaseDao;
import com.li.utils.PageInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class ProductDaoImpl implements ProductDao {
    /**
     * 添加产品
     * @param product
     * @return
     */
    public int addProduct(Product product){
        String sql=" INSERT INTO product(product_name,product_des,Product_price,Product_count,Product_cate1,Prodct_cate2,Product_pfilename)VALUES(?,?,?,?,?,?,?) ";
        Object[] objects={product.getpName(),product.getpDes(),product.getpPrice(),product.getpCount(),product.getpCate1(),product.getpCate2(),product.getpPfilename()};
        return BaseDao.excuteUpdate(sql,objects);

    }
    /**
     * 分页查询
     * @param pageInfo
     * @param product
     * @return
     */
    public List<Product> queryPage(PageInfo pageInfo , Product product){
        List<Product> list=new ArrayList<Product>();
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;

        try {
            //建立连接
            conn=BaseDao.getConnection();
            String sql="SELECT *FROM product WHERE 1=1 ";
            if (product!=null){
                //添加条件查询

            }
            sql=sql+"  limit ?,? ";
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            int num=1;
            if (product!=null){
                //添加条件查询

            }
            int begin=(pageInfo.getCurPageNo()-1)*pageInfo.getPageSize();
            int end=pageInfo.getPageSize();
            pre.setObject(num++,begin);
            pre.setObject(num++,end);
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                Product product1=new Product();
                product1.setpId(res.getInt(1));
              product1.setpName(res.getString(2));
              product1.setpDes(res.getString(3));
              product1.setpPrice(res.getDouble(4));
              product1.setpCount(res.getInt(5));
              product1.setpCate1(res.getInt(6));
              product1.setpCate2(res.getInt(7));
              product1.setpPfilename(res.getString(8));
              list.add(product1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return list;

    }
    /**
     * 分页查询条数
     * @param product
     * @return
     */
    public int getTotalCount(Product product){
        int i=0;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;
        try {
            //建立连接
            conn=BaseDao.getConnection();
            String sql="SELECT count(*)FROM product WHERE 1=1 ";
            if (product!=null){
                //添加条件查询
            }
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            int num=1;
            if (product!=null){
                //添加条件查询
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
     * 通过分类查询产品
     * @param cateGory
     * @return
     */
    public List<Product> queryProductByCate(CateGory cateGory){
        List<Product> list=new ArrayList<Product>();
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;

        try {
            //建立连接
            conn=BaseDao.getConnection();
            String sql="SELECT *FROM product ";
            if (cateGory!=null){
                sql=sql+"  WHERE product_cate1=? and product_cate2=?  ";
                //预处理sql语句
                pre=conn.prepareStatement(sql);
                //占位符赋值
                pre.setObject(1,cateGory.getCateId());
                pre.setObject(2,cateGory.getCateParentId());
            }else{
                //预处理sql语句
                pre=conn.prepareStatement(sql);
            }
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                Product product1=new Product();
                product1.setpId(res.getInt(1));
                product1.setpName(res.getString(2));
                product1.setpDes(res.getString(3));
                product1.setpPrice(res.getDouble(4));
                product1.setpCount(res.getInt(5));
                product1.setpCate1(res.getInt(6));
                product1.setpCate2(res.getInt(7));
                product1.setpPfilename(res.getString(8));
                list.add(product1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return list;

    }
    /**
     * 通过id查询到产品
     * @param id
     * @return
     */
    public Product findProductById(int id){
        Product product=null;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet res=null;

        try {
            //建立连接
            conn=BaseDao.getConnection();
            String sql="SELECT *FROM product where product_id=? ";
            //预处理sql语句
            pre=conn.prepareStatement(sql);
            //占位符赋值
            pre.setObject(1,id);
            //执行sql语句
            res=pre.executeQuery();
            //遍历
            while(res.next()){
                product=new Product();
                product.setpId(res.getInt(1));
                product.setpName(res.getString(2));
                product.setpDes(res.getString(3));
                product.setpPrice(res.getDouble(4));
                product.setpCount(res.getInt(5));
                product.setpCate1(res.getInt(6));
                product.setpCate2(res.getInt(7));
                product.setpPfilename(res.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pre,res);
        }
        return product;
    }
    /**
     * 修改产品
     * @param product
     * @return
     */
    public int updateProduct(Product product){
        String sql=" UPDATE product SET product_name=?,product_des=?,product_price=?,product_count=?,product_cate1=?,product_cate2=?,product_pfilename=?  WHERE product_id=? ";
        Object[] objects={product.getpName(),product.getpDes(),product.getpPrice(),product.getpCount(),product.getpCate1(),product.getpCate2(),product.getpPfilename(),product.getpId()};
        return BaseDao.excuteUpdate(sql,objects);
    }

}
