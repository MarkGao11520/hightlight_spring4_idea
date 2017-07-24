package com.wisely.highlight_spring4.structures.priorityqueue;

/**
 * Created by gaowenfeng on 2017/7/24.
 */
public interface PriorityQueue {
    int size();

    void insert(ComparisonKey newItem);

    ComparisonKey remove();
}
