package com.wisely.highlight_spring4.gc;

/**
 * Created by gaowenfeng on 2017/6/14.
 */
public class NewSizeDemo {
    public static void main(String[] args) {
        byte[] b = null;
        for(int i=0;i<10;i++){
            b=new byte[1*1024*1024];
        }
    }
}
