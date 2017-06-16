package com.wisely.highlight_spring4.gc;

import org.apache.poi.hssf.record.formula.functions.T;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by gaowenfeng on 2017/6/14.
 */
public class TraceCanReliveObj {
    public static TraceCanReliveObj obj;   //跟踪可复活的对象
    static ReferenceQueue<TraceCanReliveObj> phantomQueue = null;   //虚引用队列

    public static class CheckRefQueue extends  Thread{
        @Override
        public void run() {
            while (true){
                if(phantomQueue!=null){
                    PhantomReference<TraceCanReliveObj> objt = null;
                    try {
                        objt = (PhantomReference<TraceCanReliveObj>) phantomQueue.remove();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(objt!=null){
                        System.out.println("TraceCanReliveObj is delete by GC");
                    }
                }
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("CanReliveObj finalize called");
        obj = this;
    }

    @Override
    public String toString() {
        return "I am CanReliveObj";
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();

        phantomQueue = new ReferenceQueue<TraceCanReliveObj>();

        obj = new TraceCanReliveObj();

        PhantomReference<TraceCanReliveObj> phantomReference = new PhantomReference<TraceCanReliveObj>(obj,phantomQueue);  //构造虚引用

        obj = null;  // 去除强引用
        System.gc();   //由于可复活，座椅不能被回收
        Thread.sleep(1000);
        if(obj==null){
            System.out.println("obj是null");
        }else{
            System.out.println("obj 可用");
        }

        System.out.println("第二次gc");
        obj = null;
        System.gc();
        Thread.sleep(1000);
        if(obj==null){
            System.out.println("obj是null");
        }else{
            System.out.println("obj 可用");
        }

    }
}
