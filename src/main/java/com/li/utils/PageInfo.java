package com.li.utils;

public class PageInfo {
    private int totalPageCount;//总页数
    private int pageSize=3;//每页显示3条数据
    private int totalCount;//总记录数
    private int curPageNo=1;//当前页 默认设置为1

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount>0){
            //设置总页数
            if (totalCount%3==0){
                totalPageCount=totalCount/3;
            }else{
                totalPageCount=totalCount/3+1;
            }

        }
        this.totalCount = totalCount;
    }

    public int getCurPageNo() {
        return curPageNo;
    }

    public void setCurPageNo(int curPageNo) {
        this.curPageNo = curPageNo;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "totalPageCount=" + totalPageCount +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", curPageNo=" + curPageNo +
                '}';
    }
}
