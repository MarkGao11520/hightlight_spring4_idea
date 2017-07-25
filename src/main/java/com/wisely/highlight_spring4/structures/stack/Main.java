package com.wisely.highlight_spring4.structures.stack;

/**
 * Created by gaowenfeng on 2017/7/24.
 */
public class Main {
    public static void main(String[] args) {
        ParentMatcher pm = new ParentMatcher();
        pm.setInputString("(a+sin(x)-A[i,j])");
        pm.parentMatch();
        System.out.println(pm.getOutputString());
    }
}
