package com.li.po;

/**
 * 产品实体
 */
public class Product {
    private int   pId;// INT(10) NOT NULL AUTO_INCREMENT COMMENT '产品id',
    private String pName;// VARCHAR(50) NOT NULL COMMENT '产品名字',
    private String pDes;// VARCHAR(400) NOT NULL COMMENT '产品描述',
    private double   pPrice;// DOUBLE(7,2) NOT NULL COMMENT '产品价格',
    private int   pCount;//INT(6) NOT NULL COMMENT '产品的数量',
    private int  pCate1;//INT(5) NOT NULL COMMENT '一级分类',
    private int   pCate2;// INT(5) NOT NULL COMMENT '二级分类',
    private String pPfilename;//VARCHAR(50) NOT NULL COMMENT '产品的图片名',

    public Product() {
    }

    public Product(int pId, String pName, String pDes, double pPrice, int pCount, int pCate1, int pCate2, String pPfilename) {
        this.pId = pId;
        this.pName = pName;
        this.pDes = pDes;
        this.pPrice = pPrice;
        this.pCount = pCount;
        this.pCate1 = pCate1;
        this.pCate2 = pCate2;
        this.pPfilename = pPfilename;
    }

    public Product(String pName, String pDes, double pPrice, int pCount, int pCate1, int pCate2, String pPfilename) {
        this.pName = pName;
        this.pDes = pDes;
        this.pPrice = pPrice;
        this.pCount = pCount;
        this.pCate1 = pCate1;
        this.pCate2 = pCate2;
        this.pPfilename = pPfilename;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDes() {
        return pDes;
    }

    public void setpDes(String pDes) {
        this.pDes = pDes;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public int getpCount() {
        return pCount;
    }

    public void setpCount(int pCount) {
        this.pCount = pCount;
    }

    public int getpCate1() {
        return pCate1;
    }

    public void setpCate1(int pCate1) {
        this.pCate1 = pCate1;
    }

    public int getpCate2() {
        return pCate2;
    }

    public void setpCate2(int pCate2) {
        this.pCate2 = pCate2;
    }

    public String getpPfilename() {
        return pPfilename;
    }

    public void setpPfilename(String pPfilename) {
        this.pPfilename = pPfilename;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pDes='" + pDes + '\'' +
                ", pPrice=" + pPrice +
                ", pCount=" + pCount +
                ", pCate1=" + pCate1 +
                ", pCate2=" + pCate2 +
                ", pPfilename='" + pPfilename + '\'' +
                '}';
    }
}
