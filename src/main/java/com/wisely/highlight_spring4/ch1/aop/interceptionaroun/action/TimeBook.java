package com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action;

import com.wisely.highlight_spring4.ch1.aop.interceptionaroun.impl.TimeBookInterface;

/**
 * Created by gaowenfeng on 2017/2/26.
 */
public class TimeBook implements TimeBookInterface{
    @Override
    public void doAuditing(String name) {
      //  int m = 1/0;
        System.out.println("审核数据的程序正在进行");
    }

    @Override
    public void doCheck(String name) {
        System.out.println("财务关账的程序正在进行"+name);
    }
}
