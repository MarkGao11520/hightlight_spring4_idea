package com.wisely.highlight_spring4.structures.priorityqueue;

/**
 * Created by gaowenfeng on 2017/7/24.
 */
public class PQItemString implements ComparisonKey{
    private String key;

    public PQItemString(String key) {
        this.key = key;
    }

    @Override
    public int compareTo(ComparisonKey value) {
        String a= this.key;
        String b= ((PQItemString)value).key;
        return a.compareTo(b);
    }

    @Override
    public String toString() {
        return key;
    }
}
