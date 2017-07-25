package com.wisely.highlight_spring4.structures.queue;

/**
 * Created by gaowenfeng on 2017/7/25.
 */
public class ArrayQueue<T> implements Queue<T>{
    private int front;

    private int rear;

    private int count;

    private int capacity;

    private int capacityIncrement;

    private Object[] itemArray;

    public ArrayQueue() {
        front = 0;
        rear = 0;
        count = 0;
        capacity = 5;
        capacityIncrement = 5;
        itemArray = new Object[capacity];
    }

    @Override
    public boolean empty() {
        return (count == 0);
    }

    @Override
    public void insert(T t) {
        if(count == capacity){ //如果容量已满，则通过增幅扩展itemArray;
            capacity+=capacityIncrement;
            Object[] tempArray = new Object[capacity];
            if(front<rear){  //如果元素位于itemArray[front:rear-1]中
                 for(int i = front;i<rear;i++){
                     tempArray[i] = itemArray[i];
                 }
            }else{  //否则将元素分成2个区间，否则是front=rear，队列满，不会出现front>rear
                for(int i = 0;i<rear;i++){  //区间1
                    tempArray[i] = itemArray[i];
                }
                for(int i = front;i<count;i++){  //区间2
                    tempArray[i+capacityIncrement]=itemArray[i];
                }
                front+=capacityIncrement;  //然后,将front改为指向其新位置
            }
            itemArray = tempArray;
        }
        itemArray[rear] = t;
        rear = (rear+1)%capacity;
        count++;
    }

    @Override
    public T remove() {
        if(count == 0)
            return null;
        else{
            T tempItem = (T) itemArray[front];
            front = (front+1)%capacity;
            count -- ;
            return tempItem;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        for(int i=0;i<11;i++){
            queue.insert(i);
            System.out.println();
        }
    }
}
