package com.wisely.highlight_spring4.gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by gaowenfeng on 2017/6/14.
 */
public class SoftRef {
    public static class User{
        public int id;
        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        User u = new User(1,"gwf");   //强引用
        WeakReference<User> userWeakReference = new WeakReference<User>(u);  //建立弱引用
        SoftReference<User> userSoftReference = new SoftReference<User>(u);  //建立软引用
        u = null;  //去除强引用

        System.out.println(userSoftReference.get());
        System.out.println(userWeakReference.get());
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftReference.get());
        System.out.println(userWeakReference.get());

        byte[] b = new byte[1024*930*7];
        System.gc();
        System.out.println(userSoftReference.get());
        System.out.println(userWeakReference.get());
    }
}
