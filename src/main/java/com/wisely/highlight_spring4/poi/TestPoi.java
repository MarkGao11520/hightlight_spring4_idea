package com.wisely.highlight_spring4.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaowenfeng on 2017/5/31.
 */
public class TestPoi {

    public static void main(String[] args) throws IOException {
//        Map<String, Object> pic=new HashMap<String, Object>();
//        FileInputStream in =  new FileInputStream("/Users/gaowenfeng/Desktop/headshot.png");
//        byte byt[] = new byte[1048576];
//        in.read(byt);
//        pic.put("content",byt);
//        pic.put("width",200);
//        pic.put("height",200);
//        pic.put("type","png");

        Map<String, Object> param=new HashMap<String, Object>();
        param.put("${name}","高文峰");
        param.put("${classes}","软件Z1402");
        param.put("${title}","第一题");
        param.put("${teacher}","张建军");
        param.put("${openreport}","内容");
        CustomXWPFDocument doc=WordUtil.generateWord(param, "/Users/gaowenfeng/Desktop/temp.docx");
        FileOutputStream fopts = new FileOutputStream("/Users/gaowenfeng/Desktop/bbb.docx");
        doc.write(fopts);
        fopts.close();
    }
}
