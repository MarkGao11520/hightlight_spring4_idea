package com.wisely.highlight_spring4.mybatis.pojo;

import java.util.List;

/**
 * Created by gaowenfeng on 2017/5/17.
 */
public class Role {
    private long id;

    private String name;

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
