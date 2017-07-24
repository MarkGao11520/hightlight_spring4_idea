package com.wisely.highlight_spring4.io;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gaowenfeng on 2017/6/21.
 */
public class FileInputStreamTest {
    File file = new File("/Users/gaowenfeng/desktop/io/file/hello.txt");
    File dir = new File("/Users/gaowenfeng/desktop/io/file");

    @Test
    public void testFileOutputStream() {
        try {
            if(!file.exists()){
                dir.mkdirs();
                file.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(file);
            byte buy[] = "我有一只小毛驴,我从来也不骑".getBytes();
            outputStream.write(buy);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileInputStrea() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte byt[] = new byte[22];  //缓冲区
            int len;
            while ((len = fileInputStream.read(byt)) != -1) {   //len的作用是防止最后一次读取的长度小于字符数组
                System.out.println("文本长度为:" + len);
                System.out.println("文本信息为:" + new String(byt, 0, len));  //一个汉字占三个字节，一个字母或者数字一个字节
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void testInOut() {
        byte[] buffer = new byte[512];   //一次取出的字节数大小,缓冲区大小
        int numberRead = 0;
        BufferedInputStream input = null;
        BufferedOutputStream out = null;
        try {
            input = new BufferedInputStream(new FileInputStream("/Users/gaowenfeng/downloads/双人.png"));
            out = new BufferedOutputStream(new FileOutputStream("/Users/gaowenfeng/desktop/双人.png")); //如果文件不存在会自动创建
            while ((numberRead = input.read(buffer)) != -1) {  //numberRead的目的在于防止最后一次读取的字节小于buffer长度，
                out.write(buffer, 0, numberRead);       //否则会自动被填充0
                out.flush();
            }
        } catch (final IOException e) {
            // TODO自动生成的 catch 块
            e.printStackTrace();
        } finally {
            try {
                input.close();
                out.close();
            } catch (IOException e) {
                // TODO自动生成的 catch 块
                e.printStackTrace();
            }

        }
    }
}
