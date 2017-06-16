package com.wisely.highlight_spring4.activiti.pojo;

import java.io.Serializable;

/**
 * Created by gaowenfeng on 2017/6/8.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 8379071759772449529L;
    private Integer id;
    private String name;
    private String education;

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
}
