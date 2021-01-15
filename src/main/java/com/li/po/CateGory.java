package com.li.po;

/**
 * 分类实体
 */
public class CateGory {
    private int cateId;//分类id
    private  String cateName;//分类名称
    private  int cateParentId;//分类父id

    public CateGory() {
    }

    public CateGory(String cateName, int cateParentId) {
        this.cateName = cateName;
        this.cateParentId = cateParentId;
    }

    public CateGory(int cateId, String cateName, int cateParentId) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.cateParentId = cateParentId;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getCateParentId() {
        return cateParentId;
    }

    public void setCateParentId(int cateParentId) {
        this.cateParentId = cateParentId;
    }

    @Override
    public String toString() {
        return "CateGory{" +
                "cateId=" + cateId +
                ", cateName='" + cateName + '\'' +
                ", CateParentId=" + cateParentId +
                '}';
    }
}
