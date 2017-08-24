package com.wisely.highlight_spring4.pukepai;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaowenfeng on 2017/7/28.
 */
public class Main {
    class CompareObject{
        private CompareType type;
        private int value;

        public CompareObject(CompareType type, int value) {
            this.type = type;
            this.value = value;
        }
        public CompareType getType() {
            return type;
        }
        public int getValue() {
            return value;
        }

    }

    enum CompareType{
        SINGLE(1),
        DOUBLE(2),
        THREE(3),
        ZHA_DAN(4),
        SHUN_ZI(5),
        WANG_ZHA(6)
        ;
        private int type;

        CompareType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    public void checkInner(String in){
        try {
            String[] player = in.split(",");
            if(player.length!=2)
                throw new MyException("玩家数量不正确");
            else
                checkInner(player);
        }catch (Exception e){
            throw new MyException("玩家数量不正确");
        }
    }

    public void checkInner(String[] player){
        List<CompareObject> objects = new ArrayList<>();
        for(String s:player){
            CompareObject compareObject = null;
            String[] brands = s.split(" ");
            if(brands.length<1||brands.length>5)
                throw new MyException("出牌不合法");
            else
                switch (brands.length){
                    case 1:
                        objects.add(genCompareObject(CompareType.SINGLE,brands[0]));
                        break;
                    case 2:
                        if(!brands[0].equals(brands[1]))
                            throw new MyException("出牌不合法");
                        else if(brands[0].equals("joker")&&brands[1].equals("JOKER"))
                            objects.add(new CompareObject(CompareType.WANG_ZHA,Integer.MAX_VALUE));
                        else
                            objects.add(genCompareObject(CompareType.DOUBLE,brands[0]));
                        break;
                    case 3:
                        if(!(brands[0].equals(brands[1])&&brands[1].equals(brands[2])))
                            throw new MyException("出牌不合法");
                        else if(brands[0].equals("joker")||brands[0].equals("JOKER"))
                            throw new MyException("出牌不合法");
                        else
                            objects.add(genCompareObject(CompareType.THREE,brands[0]));
                        break;
                    case 4:
                        if(!(brands[0].equals(brands[1])&&brands[1].equals(brands[2])&&brands[2].equals(brands[3])))
                            throw new MyException("出牌不合法");
                        else if(brands[0].equals("joker")||brands[0].equals("JOKER"))
                            throw new MyException("出牌不合法");
                        else
                            objects.add(genCompareObject(CompareType.THREE,brands[0]));
                        break;
                    case 5:
                        


                }
        }
    }

    public CompareObject genCompareObject(CompareType type,String value){
        try {
            CompareObject compareObject = null;
            if(value.equals("joker")){
                compareObject  = new CompareObject(type,100);
            }else if(value.equals("JOKER")){
                compareObject = new CompareObject(type,200);
            }else if(value.equals("J")){
                compareObject = new CompareObject(type,11);
            }else if(value.equals("Q")){
                compareObject = new CompareObject(type,12);
            }else if(value.equals("K")){
                compareObject = new CompareObject(type,13);
            }else if(value.equals("A")){
                compareObject = new CompareObject(type,14);
            }else if(value.equals("2")){
                compareObject = new CompareObject(type,15);
            }
            Integer v= Integer.parseInt(value);
            if(v<3||v>10)
                throw new MyException("出牌不合法");
            else{
                compareObject = new CompareObject(type,v);
            }
            return compareObject;
        }catch (Exception e){
            throw new MyException("出牌不合法");
        }
    }

    class MyException extends RuntimeException{
        MyException(String message){
            super(message);
        }
    }
}


