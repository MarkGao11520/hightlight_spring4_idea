package com.wisely.highlight_spring4.structures.stack;

/**
 * Created by gaowenfeng on 2017/7/24.
 */
public class LindedStack<T> implements Stack<T> {

    class StackNode{
        T item;
        StackNode link;
    }

    private StackNode topNode;

    @Override
    public boolean empty() {
        return (topNode == null);
    }

    @Override
    public void push(T t) {
        StackNode newNode = new StackNode();
        newNode.item = t;
        newNode.link = topNode;
        topNode = newNode;
    }

    @Override
    public T pop() {
        if(topNode == null)
            return null;
        else {
            StackNode tempNode = topNode;
            topNode = tempNode.link;
            return tempNode.item;
        }
    }

    @Override
    public T peek() {
        if(topNode == null)
            return null;
        else{
            return topNode.item;
        }
    }
}
