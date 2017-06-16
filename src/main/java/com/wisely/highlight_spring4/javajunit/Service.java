package com.wisely.highlight_spring4.javajunit;

/**
 * Created by gaowenfeng on 2017/4/24.
 */
public class Service {
    public int techee(int a,int b,int x){
        if(a>1&&b==0){
            x=x/a;
        }

        if(a==2||x>1){
            x+=1;
        }

        return x;
    }
}
