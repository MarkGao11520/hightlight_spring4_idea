package com.wisely.highlight_spring4.structures.priorityqueue;

import java.util.Random;

/**
 * Created by gaowenfeng on 2017/7/24.
 */
public class Main {
    public static void main(String[] args) {
        int n = 5;
        ComparisonKey[] a = new ComparisonKey[n];

        String[] someNames = {"gwf","gzf","cty","cfs","xyj"};

        Random random = new Random();
        for(int i=0;i<n;i++){
           // a[i] = new PQItemInteger(random.nextInt(100));
            a[i] = new PQItemString(someNames[i]);
            System.out.print(a[i]+", ");
        }
        System.out.println();

        priorityQueueSort(a);

        for(int i=0;i<n;i++)
            System.out.print(a[i]+", ");
        System.out.println();
    }

    static void priorityQueueSort(ComparisonKey[] a){
        int i;
        int n = a.length;
        PriorityQueue PQ = new HeapPriorityQueue();
        for(i=0;i<n;i++){
            PQ.insert(a[i]);
        }
        for(i=n-1;i>=0;i--)
            a[i] = PQ.remove();
    }
}
