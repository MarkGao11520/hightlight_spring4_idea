package com.wisely.highlight_spring4.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * Created by gaowenfeng on 2017/6/14.
 */
public class SoftRefQ {
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

    static ReferenceQueue<User> userReferenceQueue = null;

    public static class CheckRefQueue extends Thread{
        @Override
        public void run() {
            while (true){
                if(userReferenceQueue!=null){
                    UserSoftReference obj = null;
                    try {
                        obj = (UserSoftReference) userReferenceQueue.remove();  //跟踪引用队列，打印回收情况
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 自定义了一个自定义的软引用类，扩展软引用的目的是记录User.uid,后续再引用队列中，就一个通过这个uid字段知道哪个User实例被回收了
     */
    public static class UserSoftReference extends SoftReference<User>{
        int uid;

        public UserSoftReference(User referent, ReferenceQueue<? super User> q) {
            super(referent, q);
            uid = referent.id;
        }
    }

    public static void main(String[] args) {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();
        User u = new User(1,"Gwf");
        userReferenceQueue = new ReferenceQueue<User>();
        UserSoftReference userSoftReference = new UserSoftReference(u,userReferenceQueue);   //构造软引用，并指定引用队列
        u = null;
        System.out.println(userSoftReference.get());
        System.gc();
        System.out.println("After GC");
        System.out.println(userSoftReference.get());

        System.out.println("try to create byte array and GC");
        byte[] b = new byte[1024*925*7];
        System.gc();
        System.out.println(userSoftReference.get());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
