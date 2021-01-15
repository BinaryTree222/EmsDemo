package com.li.dao.productdao;

import com.li.po.CateGory;
import com.li.po.Product;
import com.li.utils.PageInfo;

import java.util.List;

public interface ProductDao {
    /**
     * 添加产品
     * @param product
     * @return
     */
    int addProduct(Product product);

    /**
     * 分页查询
     * @param pageInfo
     * @param product
     * @return
     */
    List<Product> queryPage(PageInfo pageInfo ,Product product);

    /**
     * 分页查询条数
     * @param product
     * @return
     */
    int getTotalCount(Product product);

    /**
     * 通过分类查询产品
     * @param cateGory
     * @return
     */
    List<Product> queryProductByCate(CateGory cateGory);

    /**
     * 通过id查询到产品
     * @param id
     * @return
     */
    Product findProductById(int id);

    /**
     * 修改产品
     * @param product
     * @return
     */
    int updateProduct(Product product);
}
