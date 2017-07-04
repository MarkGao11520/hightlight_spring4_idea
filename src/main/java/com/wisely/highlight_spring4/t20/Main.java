package com.wisely.highlight_spring4.t20;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by gaowenfeng on 2017/6/30.
 */
public class Main {

    public static void main(String[] args) {
        int[] chinese = createArray("chinese");
        int[] math = createArray("math");
        int[] english = createArray("english");
        int[] all = new int[30];
        for(int i = 0;i<30;i++){
            all[i] = chinese[i]+math[i]+english[i];
        }
        System.out.println("总成绩第10名为:"+all[9]);
        System.out.println("总成绩为："+JSON.toJSONString(all));
        Arrays.sort(all);
        System.out.println("总成绩为排名为："+JSON.toJSONString(all));

    }

    public static int[] createArray(String name){
        Random random = new Random();
        int[] chinese = new int[30];
        int[] chinesesort = new int[30];
        List<Integer> chinese1 = new ArrayList<Integer>();
        for(int i=0;i<30;i++){
            int number = random.nextInt(91);
            while (number<60||chinese1.contains(number)) {
                number = random.nextInt(91);
            }
            chinese[i] = number;
            chinesesort[i] = number;
            chinese1.add(number);
        }
        Arrays.sort(chinesesort);
        int temp = chinese[9];
        for(int i=0;i<30;i++){
            if(chinese[i]==chinesesort[9]){
                chinese[i] = temp;
            }
        }
        chinese[9] = chinesesort[9];
        System.out.println( name+"科目成绩为:"+ JSON.toJSONString(chinese)+"，第10名的成绩为"+chinese[9]);
        System.out.println( name+"科目成绩排名为:"+JSON.toJSONString(chinesesort));
        return chinese;
    }
}
