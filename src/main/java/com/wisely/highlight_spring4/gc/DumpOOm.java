package com.wisely.highlight_spring4.gc;

import java.util.Vector;

/**
 * Created by gaowenfeng on 2017/6/14.
 */
public class DumpOOm {
    public static void main(String[] args) {
        Vector v = new Vector();

        for(int i=0;i<25;i++){
            v.add(new byte[1*1024*1024]);
        }
    }
}
