package com.wisely.highlight_spring4.print;

/**
 * Created by gaowenfeng on 2017/3/23.
 */
public class A4Page implements pager{
    private int linechar = 10;
    private int linenumber = 8;
    static int i = 0;
    StringBuilder content =new StringBuilder();

    @Override
    public void print(char c) {
        if(i%linechar==0){
            content.append("\n");
        }
        content.append(c);
        i++;
    }

    @Override
    public String getContent() {
        return content.toString();
    }
}
