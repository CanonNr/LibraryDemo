package com.lksun.library.entity.Page;

public class PageRequest {
    private int pageNum;

    private int pageSize;

    public int getPageNum() {

        return pageNum;
    }
    public void setPageNum(int pageNum) {

        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
