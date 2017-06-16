package com.wisely.highlight_spring4.print;

/**
 * Created by gaowenfeng on 2017/3/23.
 */
public class BlackInk implements  ink{

    @Override
    public String getColor(int r, int g, int b) {
        return "黑色";
    }
}
