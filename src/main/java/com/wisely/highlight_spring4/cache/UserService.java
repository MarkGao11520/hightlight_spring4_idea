package com.wisely.highlight_spring4.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaowenfeng on 2017/4/30.
 */
@Service
public class UserService {

    @Autowired
    private CacheManager cacheManager;

    private Map<Integer,User> users = new HashMap<Integer, User>();

    /**
     * 构造代码块
     */
    {
        users.put(1,new User(1,"gwf"));
        users.put(2,new User(2,"jd"));
    }

    /**添加缓存**/
    @Cacheable(value = "users1")
    public User getUser(Integer id){
        System.out.println("User with id "+id+" requested");
        return users.get(id);
    }

    /**添加缓存**/
    @CachePut(value = "users",key = "#user.id")
    public User putUser(User user){
        users.put(user.getId(),user);
        return user;
    }

    /**逐出缓存**/
    @CacheEvict(value = "users")
    public void removeUser(int id){
        users.remove(id);
    }

    /**
     * 编程式
     */
    @PostConstruct
    public void setUp(){
        Cache userCache = cacheManager.getCache("users1");
        for(Integer key:users.keySet()){
            userCache.put(key,users.get(key));
        }
    }


}
