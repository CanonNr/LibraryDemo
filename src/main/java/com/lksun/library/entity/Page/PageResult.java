package com.lksun.library.entity.Page;

import java.util.List;

public class PageResult {

    // 当前页码
    private Integer pageNum;

    // 每页数量
    private Integer pageSize;

    // 数据总条数
    private Integer totalSize;

    // 总页数
    private Integer totalPages;

    // 返回数据
    private List<?> content;

    /**
     * @param content 返回的数据
     * @param pageRequest  分页类
     * @param totalSize 数据的总条数
     */
    public PageResult(List<?> content, PageRequest pageRequest, Integer totalSize){
        this.content = content;
        this.totalSize = totalSize;
        this.pageSize = pageRequest.getPageSize();
        this.pageNum = pageRequest.getPageNum();
        this.totalPages = (int) Math.ceil(this.totalSize / this.pageSize);  // 向上取整并强转为int类型
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalSize=" + totalSize +
                ", totalPages=" + totalPages +
                ", content=" + content +
                '}';
    }
}
