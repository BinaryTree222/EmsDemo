package com.li.sercive.categorysercive;

import com.li.po.CateGory;

import java.util.List;

public interface CateGorySercive {
    /**
     * 查询分类
     * @param cateGory
     * @return
     */
    List<CateGory> queryClass(CateGory cateGory);
    /**
     * 添加分类
     * @param name
     * @param id
     * @return
     */
    int addCate(String name ,int id);

    /**
     * 通过id查找分类
     * @param id
     * @return
     */
    CateGory findCateById(int id);
    /**
     * 修改分类
     * @param cateGory
     * @return
     */
    int updateCate(CateGory cateGory);
    /**
     * 通过id查询子分类的数量
     * @param id
     * @return
     */
    int queryCateCount(int id);
    /**
     * 通过分类id删除分类
     * @param id
     * @return
     */
    int deleteCate(int id);
}
