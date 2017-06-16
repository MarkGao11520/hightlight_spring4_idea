package com.wisely.highlight_spring4.overreade.aaa;

import com.wisely.highlight_spring4.overreade.Father;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by gaowenfeng on 2017/5/30.
 */
public class Son extends Father {
    public void speak(){
        super.speak();
        System.out.println("son");

    }

    public static void main(String[] args) {
        Son son = new Son();
        Father father = new Father();
//        Son son1 = null;
        char a = 65;
        char z = 90;

        int i1 = 'a';
        int i2 = 'z';

        int i3 = '0';
        int i4 = '9';
//        System.out.println(i1);
//
//        System.out.println(i2);
//        System.out.println(i3);
//        System.out.println(i4);

        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        List<String> list = new ArrayList<String>();
        System.out.println(str.length());

        Random random = new Random();
        for(int i =0;i<10;i++){
            int k ;
            do{
                k = random.nextInt(10);
            }while (k==0);
            String str1 = new String("");
            do{
                for(int j=0;j<k;j++){
                    int result = random.nextInt(str.length());
                    str1+=str.charAt(result);
                }
            }while (str1.equals("")||list.contains(str1));
            list.add(str1);
        }
        System.out.println("排序前");
        for (String s:list
             ) {
            System.out.println(s);
        }
        System.out.println("...........");
        System.out.println("排序后");
        Collections.sort(list);
        for (String s:list
                ) {
            System.out.println(s);
        }

//        son.speak();
    }
}
