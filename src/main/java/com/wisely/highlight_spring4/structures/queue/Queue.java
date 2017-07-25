package com.wisely.highlight_spring4.structures.queue;

/**
 * Created by gaowenfeng on 2017/7/25.
 */
public interface Queue<T> {
    /**
     * 判断队列是否为空
     * @return
     */
    boolean empty();

    /**
     * 像队列中添加元素
     * @param t
     */
    void insert(T t);

    /**
     * 从队列中移除元素
     * @return
     */
    T remove();
}
