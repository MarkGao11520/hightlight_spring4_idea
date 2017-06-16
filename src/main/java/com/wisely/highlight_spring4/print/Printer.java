package com.wisely.highlight_spring4.print;

/**
 * Created by gaowenfeng on 2017/3/23.
 */
public class Printer {
    ink ink;
    pager pager;

    public com.wisely.highlight_spring4.print.ink getInk() {
        return ink;
    }

    public void setInk(com.wisely.highlight_spring4.print.ink ink) {
        this.ink = ink;
    }

    public com.wisely.highlight_spring4.print.pager getPager() {
        return pager;
    }

    public void setPager(com.wisely.highlight_spring4.print.pager pager) {
        this.pager = pager;
    }

    public void print(String str){
        System.out.println("正在使用"+ ink.getColor(1,1,1)+"颜色打印");
        for (int i = 0; i < str.length(); i++) {
            pager.print(str.charAt(i));
        }
        System.out.println(pager.getContent());
    }
}
