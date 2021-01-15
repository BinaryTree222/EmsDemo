package com.li.sercive.productsercive.Impl;

import com.li.dao.productdao.Impl.ProductDaoImpl;
import com.li.dao.productdao.ProductDao;
import com.li.po.CateGory;
import com.li.po.Product;
import com.li.sercive.productsercive.ProductSercive;
import com.li.utils.PageInfo;

import java.util.List;

public class ProductSerciveImpl implements ProductSercive {
    private ProductDao productDao=new ProductDaoImpl();
    /**
     * 添加产品
     * @param product
     * @return
     */
    public int addProduct(Product product){
        return productDao.addProduct(product);
    }
    /**
     * 分页查询
     * @param pageInfo
     * @param product
     * @return
     */
    public List<Product> queryPage(PageInfo pageInfo , Product product){
        return productDao.queryPage(pageInfo, product);
    }

    /**
     * 分页查询条数
     * @param product
     * @return
     */
    public int getTotalCount(Product product){
        return productDao.getTotalCount(product);
    }
    /**
     * 通过分类查询产品
     * @param cateGory
     * @return
     */
    public List<Product> queryProductByCate(CateGory cateGory){
        return productDao.queryProductByCate(cateGory);
    }
    /**
     * 通过id查询到产品
     * @param id
     * @return
     */
    public Product findProductById(int id){
        return productDao.findProductById(id);
    }
    /**
     * 修改产品
     * @param product
     * @return
     */
    public int updateProduct(Product product){
        return productDao.updateProduct(product);
    }
}
