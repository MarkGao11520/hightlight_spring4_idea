package com.wisely.highlight_spring4.structures.stack;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by gaowenfeng on 2017/7/25.
 */
public class ArrayStack<T> implements Stack<T>{
    private int count;
    private int capacity;
    private int capacityIncrement;

    private Object[] itemArray;

    public ArrayStack() {
        count = 0;
        capacity = 10;
        capacityIncrement = 5;
        itemArray = new Object[capacity];
    }

    public boolean empty(){
        return (count == 0);
    }

    public void push(T x){
        if(count == capacity){
            capacity += capacityIncrement;
            Object[] tempArray = new Object[capacity];
            for(int i=0;i<count;i++){
                tempArray[i] = itemArray[i];
            }
            itemArray = tempArray;
        }
        itemArray[count++] = x;
    }

    public T pop(){
        if(count == 0){
            return null;
        }else{
            return (T) itemArray[--count];
        }
    }

    public T peek(){
        if(count == 0){
            return null;
        }else{
            return (T) itemArray[count-1];
        }
    }
}
