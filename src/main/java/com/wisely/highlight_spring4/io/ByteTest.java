package com.wisely.highlight_spring4.io;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Test;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by gaowenfeng on 2017/6/21.
 */
public class ByteTest
{
    public void byteInputStreamTest(){
        String str = "高文峰爱姜丹";
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
        FileOutputStream outputStream = new FileOutputStream("/Users/gaowenfeng/desktop/aa.txt");
        byte buffer[] = new byte[1024];

        int len;

            while ((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
                out.writeTo(outputStream);
                System.out.println(new String(buffer,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void doSequence() {
        // 创建一个合并流的对象
        SequenceInputStream sis = null;
        // 创建输出流。
        BufferedOutputStream bos = null;
        try {
            // 构建流集合。
            Vector<InputStream> vector = new Vector<InputStream>();
            vector.addElement(new FileInputStream("/Users/gaowenfeng/desktop/io/file/hello1.txt"));
            vector.addElement(new FileInputStream("/Users/gaowenfeng/desktop/aa.txt"));
            Enumeration<InputStream> e = vector.elements();

            sis = new SequenceInputStream(e);

            bos = new BufferedOutputStream(new FileOutputStream("/Users/gaowenfeng/desktop/bb.txt"));
            // 读写数据
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = sis.read(buf)) != -1) {
                bos.write(buf, 0, len);
                bos.flush();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (sis != null)
                    sis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
