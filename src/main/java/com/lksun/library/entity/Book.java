package com.lksun.library.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_id")
    private Integer type_id;

    @Column(name = "press_name")
    private String press_name;

    @Column(name = "author")
    private String author;

    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "remark")
    private String remark;

    @Column(name = "status")
    private Integer status;
    private final Integer lend = 0;  // 借出
    private final Integer InStock = 1;  // 在库


    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "update_time")
    private Date update_time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getPress_name() {
        return press_name;
    }

    public void setPress_name(String press_name) {
        this.press_name = press_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getLend() {
        return lend;
    }

    public Integer getInStock() {
        return InStock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type_id=" + type_id +
                ", press_name='" + press_name + '\'' +
                ", author='" + author + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
