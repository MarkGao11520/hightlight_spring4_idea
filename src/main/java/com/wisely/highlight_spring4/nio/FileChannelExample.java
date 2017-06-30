package com.wisely.highlight_spring4.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by gaowenfeng on 2017/6/23.
 */
public class FileChannelExample {
    public static void main(String[] args) {
        FileChannel in = null;
        FileChannel out = null;
        try {
            RandomAccessFile aFile = new RandomAccessFile("/Users/gaowenfeng/Desktop/nio/aa.txt","rw");
            in = aFile.getChannel();
//            FileChannel in = new FileInputStream("/Users/gaowenfeng/Desktop/nio/aa.txt").getChannel();
            out = new FileOutputStream("/Users/gaowenfeng/Desktop/nio/bb.txt").getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(3);


            int bytesRead ;
            boolean temp = true;
            while ((bytesRead= in.read(buffer))!=-1){
                System.out.println("Read "+bytesRead);
                buffer.flip();

                while (buffer.hasRemaining()){
                    if(temp)
                        buffer.mark();
                    out.write(buffer);
                    if(temp) {
                        buffer.reset();
                        temp = false;
                    }
         //           System.out.print((char) buffer.get());
                }
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
