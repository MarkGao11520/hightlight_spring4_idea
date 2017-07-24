package com.wisely.highlight_spring4.structures.priorityqueue;

/**
 * Created by gaowenfeng on 2017/7/24.
 */
public class PQItemInteger implements ComparisonKey{
    private int key;

    PQItemInteger(int value){
        key = value;
    }

    @Override
    public int compareTo(ComparisonKey value) {
        int a = this.key;
        //todo 如果不是相同类型需要抛出异常
        int b = ((PQItemInteger)value).key;
        return (a==b)?0:(a>b)?1:-1;
    }

    @Override
    public String toString() {
        return Integer.toString(key);
    }
}
