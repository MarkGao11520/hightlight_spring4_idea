package com.wisely.highlight_spring4.structures.stack;

/**
 * Created by gaowenfeng on 2017/7/24.
 */
public interface Stack<T> {
    /**
     * 判断堆栈是否为空
     * @return
     */
    boolean empty();

    /**
     * 将元素X压入堆栈
     * @param t
     */
    void push(T t);

    /**
     * 从S中删除顶端元素并将其放入堆栈中
     * @return
     */
    T pop();

    /**
     * 讲S的顶端元素复制放入堆栈中
     * @return
     */
    T peek();
}
