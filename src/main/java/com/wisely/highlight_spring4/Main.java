package com.wisely.highlight_spring4;

import com.alibaba.fastjson.JSON;
import com.sun.tools.javah.Gen;
import sun.java2d.pipe.SpanIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gaowenfeng on 2017/7/5.
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> _ids = new ArrayList<Integer>();
        ArrayList<Integer> _parents = new ArrayList<Integer>();
        ArrayList<Integer> _costs = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while(line != null && !line.isEmpty()) {
            if(line.trim().equals("0")) break;
            String []values = line.trim().split(" ");
            if(values.length != 3) {
                break;
            }
            _ids.add(Integer.parseInt(values[0]));
            _parents.add(Integer.parseInt(values[1]));
            _costs.add(Integer.parseInt(values[2]));
            line = in.nextLine();
        }
        int res = resolve(_ids, _parents, _costs);

        System.out.println(String.valueOf(res));
    }

    // write your code here
    public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {
        List<GenTask> tasks = new ArrayList<>();
        for(int i=0;i<ids.size();i++){
            if(!parents.contains(ids.get(i)))
                tasks.add(new GenTask(ids.get(i),costs.get(i),i));
        }

        for(int i=0;i<tasks.size();i++){
            int p ;
            int costSum = tasks.get(i).get_costs();
            int current = tasks.get(i).get_num();
            while ((p=getParentIndex(current,parents,ids))!=-1){
                costSum+=costs.get(p);
                current = p;
            }
            tasks.get(i).set_costs(costSum);
        }

        Collections.sort(tasks);


        int max = tasks.get(0).get_costs();
//        for(int i=1;i<tasks.size();i++){
//            if(tasks.get(i).get_costs()>max)
//                max = tasks.get(i).get_costs();
//        }
        System.out.println(JSON.toJSONString(tasks));
        return max;
    }

    public static int getParentIndex(Integer index,ArrayList<Integer> parents,ArrayList<Integer> ids){
        for(int i=0;i<ids.size();i++){
            if(ids.get(i)==parents.get(index)){
                return i;
            }
        }
        return -1;
    }

    static class GenTask implements Comparable<GenTask>{
        private int _ids;
        private int _costs;
        private int _num;



        public GenTask(int _ids, int _costs,int _num) {
            this._ids = _ids;
            this._costs = _costs;
            this._num = _num;
        }

        public int get_num() {
            return _num;
        }

        public void set_num(int _num) {
            this._num = _num;
        }

        public int get_ids() {
            return _ids;
        }

        public void set_ids(int _ids) {
            this._ids = _ids;
        }

        public int get_costs() {
            return _costs;
        }

        public void set_costs(int _costs) {
            this._costs = _costs;
        }


        @Override
        public int compareTo(GenTask o) {
            int c1,c2;
            if((c1=o.get_costs())>(c2=this._costs))
                return -1;
            else if(c1==c2)
                return 0;
            else
                return 1;
        }
    }

}
