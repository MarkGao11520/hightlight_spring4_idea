package com.wisely.highlight_spring4.util;

import java.util.Scanner;

/**
 * Created by gaowenfeng on 2017/8/16.
 */
public class IntTO32 {

    private final static int PANG_DING_FU = 0x80000000;
    private final static int INT_LENGTH = 32;

    public static void main(String[] args) {
//        128 = 16*8;

        int i = 0x01;
//        Byte j = Byte.valueOf("7f",16);
//        System.out.println(j);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要转换的数字，按回车开始转换，按-1结束：");
        Integer source = scanner.nextInt();
        while (source != -1) {
            print(int10ToInt16Convert(source));
            source = scanner.nextInt();
        }
    }

    public static byte[] int10ToInt16Convert(Integer source) {
        return int2ToInt16Convert(
                int10ToInt2Convert(source)
        );
    }

    private static byte[] int10ToInt2Convert(Integer source) {
        byte[] target = new byte[INT_LENGTH];
        for (int i = PANG_DING_FU, j = 0; i != 0; i >>>= 1) {
            target[j] = (byte) ((source & i) == 0 ? 0 : 1);
            j++;
        }
        return target;
    }

    private static byte[] int2ToInt16Convert(byte[] source) {
        byte[] target = new byte[8];
        int i = 0;
        for (i = 3; i < INT_LENGTH; i += 4) {
            byte result = 0;
            for (int j = 3; j >= 0; j--) {
                byte b = source[i - j];
                result += b << j;
            }
            target[(i) / 4] = result;
        }
        return target;
    }

    private static byte convert16Token(byte source) {
        if (source > 15 || source < 0)
            throw new IllegalArgumentException("只接受0-15的值");
        if (source >= 0 && source < 10)
            return source;
        if (source >= 10 && source < 16) {
            byte target = 0;
            switch (source) {
                case 10:
                    target = 'a';
                    break;
                case 11:
                    target = 'b';
                    break;
                case 12:
                    target = 'c';
                    break;
                case 13:
                    target = 'd';
                    break;
                case 14:
                    target = 'e';
                    break;
                case 15:
                    target = 'f';
                    break;
            }
            return target;
        }
        return -1;
    }

    private static void print(byte[] bytes) {
        System.out.print("0x");
        boolean is_first = false;
        for (byte b : bytes) {
            if (b != 0&&!is_first)
                is_first = true;
            if (is_first) {
                if (b < 10)
                    System.out.print(b + "");
                else
                    System.out.print((char) b + "");
            }

        }
    }

    private static void print2(byte[] bytes) {
        System.out.print("0x");
        for(int i =1;i<8;i+=2){
            int zhong = bytes[i]*16+bytes[i-1];
            byte result = 0;
            if(zhong<128)
                result =(byte) zhong;
            else
                result = (byte)(zhong-256);
//            byte =
        }
    }
}
