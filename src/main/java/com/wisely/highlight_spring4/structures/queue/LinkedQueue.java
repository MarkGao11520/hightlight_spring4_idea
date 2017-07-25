package com.wisely.highlight_spring4.structures.queue;

/**
 * Created by gaowenfeng on 2017/7/25.
 */
public class LinkedQueue<T> implements Queue<T>{
    class QueueNode{
        T item;
        QueueNode link;
    }

    private QueueNode front;

    private QueueNode rear;

    private int count;

    @Override
    public boolean empty() {
        return (count == 0);
    }

    @Override
    public void insert(T t) {
        QueueNode node = new QueueNode();

        node.item = t;

        node.link = null;

        if(rear == null){
            front = rear = node;
        }else{
            rear.link = node;
            rear = node;
        }
        count ++;
    }

    @Override
    public T remove() {
        if(count == 0){
            return null;
        }else{
            T tempItem = front.item;
            front = front.link;
            if(front == null){
                rear = null;
            }
            count--;
            return tempItem;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();
        for(int i=0;i<6;i++){
            queue.insert(i);
         //   Integer t = queue.remove();
            System.out.println();
        }
    }
}
