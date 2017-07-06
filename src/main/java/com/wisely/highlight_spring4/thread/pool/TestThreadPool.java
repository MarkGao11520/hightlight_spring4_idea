package com.wisely.highlight_spring4.thread.pool;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import net.sf.ehcache.constructs.nonstop.store.ExecutorServiceStore;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/**
 * Created by gaowenfeng on 2017/7/4.
 */

public class TestThreadPool {
    public static void main(String[] args) {
        singleThreadPoolTest();
    }

    public static void newCachedThreadPoolTest() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;

            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    public static void newFixedThreadPoolTest(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void scheduledThreadPoolTest(){
        ScheduledExecutorService scheduledThreadPoolTest = Executors.newScheduledThreadPool(5);
        scheduledThreadPoolTest.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        },1,3, TimeUnit.SECONDS);
    }

    public static void singleThreadPoolTest(){
        ExecutorService singleThreadPoolTest = Executors.newSingleThreadExecutor();
        for(int i =0 ;i<10;i++){
            final int index = i;
            singleThreadPoolTest.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
