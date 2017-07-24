package com.wisely.highlight_spring4.structures.priorityqueue;

/**
 * Created by gaowenfeng on 2017/7/24.
 */
public interface ComparisonKey {

    /**
     * 如果k1和k2均为ComparisonKey,那么k1.compareTo(k2)
     * 就会有三个值：0，+1，-1,所对应的是：k1==k2，k1>k2，k1<k2
     * 顺序是compareTo方法定义的优先级顺序
     * @param value
     * @return
     */
    int compareTo(ComparisonKey value);

    /**
     * 将ComparisonKey对象转换成可打印的字符串
     * @return
     */
    String toString();
}
