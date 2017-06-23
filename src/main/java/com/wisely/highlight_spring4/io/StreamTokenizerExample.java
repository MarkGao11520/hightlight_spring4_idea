package com.wisely.highlight_spring4.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by gaowenfeng on 2017/6/22.
 */
public class StreamTokenizerExample {

    @Test
    public void testTokenizer(){
        String fileName = "/Users/gaowenfeng/desktop/ccc.txt";
        FileReader fileReader = null;
        StreamTokenizer tokenizer = null;
        try {
            fileReader = new FileReader(fileName);

            //创建分析给定字符流的标记生成器
            tokenizer = new StreamTokenizer(new BufferedReader(fileReader));

            //ordinaryChar方法指定字符参数在此标记生成器中是“普通”字符。
            //下面指定单引号、双引号和注释符号是普通字符
            tokenizer.ordinaryChar('\'');
            tokenizer.ordinaryChar('\"');
            tokenizer.ordinaryChar('/');

            String s;
            int numNumber = 0;
            int wordNumber = 0;
            int symbolNumber = 0;
            int total = 0;

            while (tokenizer.nextToken()!=StreamTokenizer.TT_EOF){
                switch (tokenizer.ttype){
                    case StreamTokenizer.TT_NUMBER:
                        s = String.valueOf(tokenizer.nval);
                        System.out.println("数字有："+s);
                        numNumber++;
                        break;
                    case StreamTokenizer.TT_WORD:
                        s = tokenizer.sval;
                        System.out.println("单词有："+s);
                        wordNumber++;
                        break;
                    case StreamTokenizer.TT_EOL:
                        break;
                    default:
                        s = String.valueOf((char)tokenizer.ttype);
                        System.out.println("标点有："+s);
                        symbolNumber++;
                }

            }
            total = numNumber+wordNumber+symbolNumber;
            System.out.println("数字有："+numNumber);
            System.out.println("单词有："+wordNumber);
            System.out.println("标点有："+symbolNumber);
            System.out.println("总共有："+total);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
