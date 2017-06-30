package com.wisely.highlight_spring4.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by gaowenfeng on 2017/6/24.
 */
public class ScatterTest {
    public static void main(String[] args) {
        RandomAccessFile aFile = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            aFile = new RandomAccessFile("/Users/gaowenfeng/Desktop/nio/aa.txt","rw");
            out = new FileOutputStream("/Users/gaowenfeng/Desktop/nio/bb.txt").getChannel();
            in = aFile.getChannel();

            ByteBuffer header = ByteBuffer.allocate(3);
            ByteBuffer body = ByteBuffer.allocate(3);

            ByteBuffer[] bufferArray = {header,body};

            int readChars;
            while ((readChars=(int) in.read(bufferArray))!=-1){
                System.out.println("readChars:"+readChars);

                header.flip();
                body.flip();

//                while (header.hasRemaining())
//                    System.out.print("header:"+(char)header.get()+" ");
//                while (body.hasRemaining())
//                    System.out.print("body:"+(char)body.get()+" ");

                header.clear();
                body.clear();
            }
            out.write(bufferArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
