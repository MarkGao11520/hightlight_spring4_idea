package com.wisely.highlight_spring4.structures.priorityqueue;

import java.util.Arrays;

/**
 * Created by gaowenfeng on 2017/7/25.
 */
public class HeapPriorityQueue implements PriorityQueue{
    private int count; //优先队列中元素的数量

    private int capacity;  //可用数组位置的数量

    private int capacityIncrement;  //在数组扩展过程中容量的增幅

    private ComparisonKey[] itemArray;  //存放有PQ元素的数组

    public HeapPriorityQueue(){   //由于itemArray[0]总为空且未用，所存元素为capacity-1个
        count = 0;
        capacity = 16;
        capacityIncrement = 8;
        itemArray = new ComparisonKey[capacity];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void insert(ComparisonKey newItem) {
        //如果itemArray容量不够，可通过capacityIncrement扩容
        if(count == capacity-1){
            capacity+=capacityIncrement;
            ComparisonKey[] tempArray  = Arrays.copyOf(itemArray,count);
        }

        //优先队列数量递增1，并在当前优先队列元素末端插入newItem;

        count++;
        int childLoc = count;
        int parentLoc = childLoc/2;
        while (parentLoc!=0){   //当仍存在一个父亲
            if(newItem.compareTo(itemArray[parentLoc])<=0){
                itemArray[childLoc] = newItem;
                return;
            }else{  //如果当前插入的值比正在遍历的节点的父亲的值大
                itemArray[childLoc] = itemArray[parentLoc];   //则将父亲的值放入当前遍历的节点，
                childLoc = parentLoc;  //当前遍历的节点指向其父亲，这使得当前节点一直是一个空挡
                parentLoc = childLoc/2;
            }
        }

        itemArray[childLoc] = newItem; //将newItem放入最终剩下的位置
    }

    @Override
    public ComparisonKey remove() {
        if(count == 0){  //如果优先队列为空，返回null
            return null;
        }else{
            //声明
            int currentLoc;  //当前查看的位置
            int childLoc; //currentLoc 的孩子
            ComparisonKey itemToPlace; //重定位的元素值
            ComparisonKey itemToReturn; //返回删除元素的值

            //初始化
            itemToReturn = itemArray[1];  //存储稍后返回的根元素
            itemToPlace = itemArray[count--];  //末端叶子的元素
            currentLoc = 1; //从根开始currentLoc
            childLoc = 2*currentLoc;  //从根的左孩子开始childLoc

            while (childLoc<=count){
                if(childLoc<count){   //设childLoc为currentLoc中的较大的孩子
                    if(itemArray[childLoc+1].compareTo(itemArray[childLoc])>0)
                        childLoc++;
                }

                //如果childLoc的元素大于itemToPlace
                //那么将这个较大元素移到currentLoc，
                //并将currentLoc向下移
                if(itemArray[childLoc].compareTo(itemToPlace)>0){
                    itemArray[currentLoc] = itemArray[childLoc];   //当前元素始终是等待被填充的
                    currentLoc = childLoc;
                    childLoc = 2*currentLoc;
                }else{
                    itemArray[currentLoc] = itemToPlace; //填充当前元素
                    return itemToReturn;
                }
            }

            //itemToPlace的最终替换
            itemArray[currentLoc] = itemToPlace;
            //返回 最初在根中的元素
            return itemToReturn;

        }
    }
}
