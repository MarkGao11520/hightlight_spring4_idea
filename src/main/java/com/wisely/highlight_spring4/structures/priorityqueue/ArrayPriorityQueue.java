package com.wisely.highlight_spring4.structures.priorityqueue;

/**
 * Created by gaowenfeng on 2017/7/24.
 */
public class ArrayPriorityQueue implements PriorityQueue{
    /** 优先队列中的元素数目 */
    private int count;
    /** 可用数组位置的数目 */
    private int capacity;
    /** 数组扩展过程中的增幅 */
    private int capacityIncrement;
    /** 含有PQ元素的数组*/
    private ComparisonKey[] itemArray;

    public ArrayPriorityQueue(){
        count = 0;
        capacity = 10;
        capacityIncrement = 5;
        itemArray = new ComparisonKey[capacity];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void insert(ComparisonKey newItem) {
        if(count == capacity){
            resize();
        }
        itemArray[count++] = newItem;
    }

    @Override
    public ComparisonKey remove() {
        if(count==0){
            return null;
        }else{
            int maxPosition = 0;
            ComparisonKey maxItem =itemArray[0];
            for(int i =1;i<count;i++){
                if(itemArray[i].compareTo(maxItem)>0){
                    maxPosition = i;
                    maxItem = itemArray[i];
                }
            }
            itemArray[maxPosition]=itemArray[--count];  //删除最高优先级元素所造成的空档
            return maxItem;  //返回最高优先级元素
        }
    }

    private void resize(){
        capacity+=capacityIncrement;
        ComparisonKey[] tempArray = new ComparisonKey[capacity];
        for(int i=0;i<count;i++){
            tempArray[i] = itemArray[i];
        }
        itemArray = tempArray;
    }
}
