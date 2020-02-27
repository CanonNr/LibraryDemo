package com.lksun.library.entity;

import javax.persistence.*;

@Entity
@Table(name="types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "pid")
    private Integer pid;

    @Column(name = "level")
    private Integer level;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", pid=" + pid +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
