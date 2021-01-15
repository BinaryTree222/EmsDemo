package com.li.sercive.categorysercive.Impl;

import com.li.dao.categorydao.CateGoryDao;
import com.li.dao.categorydao.Impl.CateGoryDaoImpl;
import com.li.po.CateGory;
import com.li.sercive.categorysercive.CateGorySercive;

import java.util.List;

public class CateGorySerciveImpl implements CateGorySercive {
    private CateGoryDao cateGoryDao=new CateGoryDaoImpl();
    /**
     * 查询分类
     * @param cateGory
     * @return
     */
    public List<CateGory> queryClass(CateGory cateGory){
        return  cateGoryDao.queryClass(cateGory);

    }
    /**
     * 添加分类
     * @param name
     * @param id
     * @return
     */
    public int addCate(String name ,int id){
        return cateGoryDao.addCate(name, id);
    }

    /**
     * 通过id查找分类
     * @param id
     * @return
     */
    public CateGory findCateById(int id){
        return cateGoryDao.findCateById(id);
    }
    /**
     * 修改分类
     * @param cateGory
     * @return
     */
    public int updateCate(CateGory cateGory){
        return cateGoryDao.updateCate(cateGory);
    }
    /**
     * 通过id查询子分类的数量
     * @param id
     * @return
     */
    public int queryCateCount(int id){
        return cateGoryDao.queryCateCount(id);
    }
    /**
     * 通过分类id删除分类
     * @param id
     * @return
     */
    public int deleteCate(int id){
        return cateGoryDao.deleteCate(id);
    }

}
