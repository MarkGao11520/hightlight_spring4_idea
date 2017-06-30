package com.wisely.highlight_spring4.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by gaowenfeng on 2017/6/24.
 */
public class TransFerTest {
    public static void main(String[] args) {
        FileChannel in = null;
        FileChannel out = null;
        FileChannel out1 = null;
        try {
            RandomAccessFile aFile = new RandomAccessFile("/Users/gaowenfeng/Desktop/nio/aa.txt","rw");
            in = aFile.getChannel();
            out = new FileOutputStream("/Users/gaowenfeng/Desktop/nio/bb.txt").getChannel();
            out1 = new FileOutputStream("/Users/gaowenfeng/Desktop/nio/cc.txt").getChannel();

            long position  = 0;
            long count = in.size();
            out.transferFrom(in,position,count);

            in.transferTo(position,count,out1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
                out1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
