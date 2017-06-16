package com.wisely.highlight_spring4.mybatis.mapper;

import com.wisely.highlight_spring4.mybatis.pojo.Role;
import com.wisely.highlight_spring4.mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by gaowenfeng on 2017/5/24.
 */
public interface UserMapper {
    @Select("select *  FROM sys_role WHERE id=#{id}")
    Role findRoleByid(int id);

    @Select("select * from sys_user where roleid = #{roleid}")
    List<User> finUserByRoleId(int roleid);

    /**
     * 一对一
     * @return
     */
    @Select("select * from sys_user")
    @Results({
            @Result(column = "roleid",property = "role",one = @One(select = "findRoleByid"))
    }

    )
    List<User> findUser();

    @Select("select * from sys_user where id = #{id}")
    User findUserOne(Long id);

    /**
     * 一对多
     * @return
     */
    @Select("select * from sys_role")
    @Results(
            @Result(column = "id",property = "users",many = @Many(select = "finUserByRoleId"))
    )
    List<Role> findRole();

    @Delete("delete from sys_user where id = #{id}")
    int deleteUserById(int id);

    @Update("update sys_user set username = #{username} where id = #{id} ")
    int updateUserById(User user);

    @Insert("insert into sys_user(username,password,roleid) values(#{username},#{password},#{roleid})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertUser(User user);

    @Insert("<script>INSERT into sys_user(password,username) VALUES\n" +
            "        <foreach collection=\"list\" item=\"item\" separator=\",\">\n" +
            "        (#{item.password},#{item.username})\n" +
            "        </foreach></script>")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertUserBatch(List<User> users);

    @Select("call simple_into(#{roleid})")
    @Options(useCache = true)
    int testCall(int roleid);
}
