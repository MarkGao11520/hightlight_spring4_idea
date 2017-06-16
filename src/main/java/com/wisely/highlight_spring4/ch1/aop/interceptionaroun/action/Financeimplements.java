package com.wisely.highlight_spring4.ch1.aop.interceptionaroun.action;

import com.wisely.highlight_spring4.ch1.aop.interceptionaroun.impl.FinanceInterface;

/**
 * Created by gaowenfeng on 2017/2/26.
 */
public class Financeimplements implements FinanceInterface {
    @Override
    public void doCheck(String name) {
        System.out.println("正在审核"+name);
    }
}
