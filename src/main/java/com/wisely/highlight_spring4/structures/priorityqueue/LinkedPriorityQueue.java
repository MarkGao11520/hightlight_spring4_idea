package com.wisely.highlight_spring4.structures.priorityqueue;

/**
 * Created by gaowenfeng on 2017/7/24.
 */
public class LinkedPriorityQueue implements PriorityQueue{
    /** 优先队列中的元素数目 */
    private int count;

    /** 元素的链表*/
    private ListNode itemList;

    @Override
    public int size() {
        return count;
    }

    @Override
    public void insert(ComparisonKey newItem) {
        itemList = sortedInsert(newItem,itemList);
        count++;
    }

    @Override
    public ComparisonKey remove() {
        if(count == 0){
            return null;
        }else {
            ComparisonKey key = itemList.item;
            itemList = itemList.link;
            count--;
            return key;
        }
    }

    private ListNode sortedInsert(ComparisonKey newItem,ListNode p){
        if((p == null)||//如果p指向一个空链表，
                 (newItem.compareTo(p.item)>=0)){  //或者插入的newItem的优先级高于P的元素的优先级
            ListNode n = new ListNode();     //将用作为链接到P的元素的newItem插入一个新的ListNode n
            n.item = newItem;                //并返回
            n.link = p;
            return n;
        }else{
            p.link = sortedInsert(newItem, p.link);
            return p;
        }
    }
}


