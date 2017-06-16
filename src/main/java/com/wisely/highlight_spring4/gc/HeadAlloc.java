package com.wisely.highlight_spring4.gc;

/**
 * Created by gaowenfeng on 2017/6/14.
 */
public class HeadAlloc {
    public static void main(String[] args) {
        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+" bytes");

        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory()+" bytes");

        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory()+" bytes");

        byte[] b = new byte[1*1024*1024];
        System.out.println("分配了1M空间给数组");

        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+" bytes");

        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory()+" bytes");

        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory()+" bytes");

        byte[] b1 = new byte[4*1024*1024];
        System.out.println("分配了4M空间给数组");

        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+" bytes");

        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory()+" bytes");

        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory()+" bytes");
    }
}
