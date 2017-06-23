package com.wisely.highlight_spring4.mybatis.pojo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by gaowenfeng on 2017/5/17.
 */
public class User {
    private long id;
    private String username;
    private String password;
    private Integer roleid;
    private Role role;

    private byte id1;
    private short id2;
    private int id3;
    private char id4;
    private boolean id5;



    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
