package com.wisely.highlight_spring4.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by gaowenfeng on 2017/6/21.
 */
public class ObjectInputStreamTest implements Serializable{

    class User implements Serializable{
        private int id;
        private String name;

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
    public void objectTest(){
        ObjectInputStream in=null;
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("/Users/gaowenfeng/desktop/io/file/hello.txt"));
            out.writeObject(new User(1,"gwf"));
            out.writeObject(new User(2,"gzf"));
            out.writeObject(new User(3,"cfs"));
            in = new ObjectInputStream(new FileInputStream("/Users/gaowenfeng/desktop/io/file/hello.txt"));

            for(int i=0;i<3;i++)
                System.out.println(in.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testPushBack() throws IOException {
        String str = "hello,rollenholt";
        PushbackInputStream push = null; // 声明回退流对象
        ByteArrayInputStream bat = null; // 声明字节数组流对象
        bat = new ByteArrayInputStream(str.getBytes());
        push = new PushbackInputStream(bat); // 创建回退流对象，将拆解的字节数组流传入
        int temp = 0;
        while ((temp = push.read()) != -1) { // push.read()逐字节读取存放在temp中，如果读取完成返回-1
            if (temp == ',') { // 判断读取的是否是逗号
                push.unread(temp); //回到temp的位置
                temp = push.read(); //接着读取字节
                System.out.print("(回退" + (char) temp + ") "); // 输出回退的字符
            } else {
                System.out.print((char) temp); // 否则输出字符
            }
        }
    }
}
