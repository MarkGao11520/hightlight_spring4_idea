package com.wisely.highlight_spring4.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by gaowenfeng on 2017/6/22.
 */
public class testReader {

    public void testFileReader(){
        FileReader reader = null;
        PrintWriter writer = null;
        char[] buffer = new char[512];
        int readLine = 0;
        try {
            reader = new FileReader("/Users/gaowenfeng/desktop/aa.txt");
            writer = new PrintWriter(System.out);

            while ((readLine=reader.read(buffer))!=-1)
                writer.write(buffer,0,readLine);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void voidconcennateFile(){
        String[] fileNames = {"/Users/gaowenfeng/desktop/aa.txt","/Users/gaowenfeng/desktop/bb.txt"};
        String str ;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/gaowenfeng/desktop/ccc.txt"));
            for(String fileName:fileNames){
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                while ((str=reader.readLine())!=null) {
                    writer.write(str);
                    writer.newLine();
                    writer.flush();
                }
                reader.close();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
