package com.wisely.highlight_spring4.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by gaowenfeng on 2017/6/21.
 */
public class FileTest {
    @Test
    public void testFile(){
        File dir = new File("/Users/gaowenfeng/desktop/io/file/");
        File file = new File("/Users/gaowenfeng/desktop/io/file/hello.txt");
        try {
            if(!file.exists()) {
               // dir.mkdir();    //创建当前目录
                dir.mkdirs();    //创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
                System.out.println(file.createNewFile());  //创建文件，如果路径不存在会抛异常，如果存在就不创建
                System.out.println(file.getParent());  //获取父路径
                System.out.println(file.getPath());    //获取路径，含当前文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
