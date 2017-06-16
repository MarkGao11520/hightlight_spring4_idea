package com.wisely.highlight_spring4.dao.dao.impl;

import com.wisely.highlight_spring4.dao.dao.IUserDao;
import com.wisely.highlight_spring4.dao.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaowenfeng on 2017/6/2.
 */
public class UserDaoImpl implements IUserDao{
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    public UserDaoImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(User user) throws Exception {
        boolean flag = true;
        String sql = "insert into sys_user(username,password) values(?,?)";
        this.pstmt = this.connection.prepareStatement(sql);
        this.pstmt.setString(1,user.getUname());
        this.pstmt.setString(2,user.getPassword());
        if(this.pstmt.executeUpdate()>0){
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    @Override
    public List<User> findAll() throws Exception {
        List<User> all = new ArrayList<>();
        String sql = "select * from sys_user";
        this.pstmt = this.connection.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt(1));
            user.setUname(rs.getString(2));
            user.setPassword(rs.getString(3));
            all.add(user);
        }
        this.pstmt.close();
        return all;
    }
}
