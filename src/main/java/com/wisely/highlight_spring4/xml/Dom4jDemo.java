package com.wisely.highlight_spring4.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Iterator;

/**
 * Created by gaowenfeng on 2017/5/25.
 */
public class Dom4jDemo {
    public static void main(String[] args) {
        demo4jReader();
    }

    public static void demo4jReader(){
        File file = new File("/Users/gaowenfeng/desktop/bbb.xml");
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(file);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Iterator iterator = root.elementIterator();
        while (iterator.hasNext()){
            Element element = (Element) iterator.next();
            System.out.println("姓名："+element.elementText("name"));
            System.out.println("email："+element.elementText("email"));
        }
    }

    public static void demo4jWriter(){
        Document doc = DocumentHelper.createDocument();
        Element addresslist = doc.addElement("addresslist");
        Element linkman = addresslist.addElement("linkman");
        Element name = linkman.addElement("name");
        Element email = linkman.addElement("email");
        name.setText("高文峰");
        email.setText("1152057576@qq.com");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream("/Users/gaowenfeng/desktop/bbb.xml"),format);
            writer.write(doc);
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
