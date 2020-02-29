package com.lksun.library.entity.Page;

public class PageRequest {
    // 当前页数 默认为1
    private int pageNum = 1;

    // 每页显示的数量 默认为5
    private int pageSize = 5;

    private int offSet;

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

    public int getOffSet() {
        return (this.pageNum - 1) * this.pageSize;
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    @Override
    public String toString() {
        return "PageRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", offSet=" + offSet +
                '}';
    }
}
