package com.wisely.highlight_spring4.xml;

import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

/**
 * Created by gaowenfeng on 2017/5/25.
 */
public class MySAX extends DefaultHandler{
    @Override
    public void startDocument() throws SAXException {
        System.out.println("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\n 文档读取结束");
    }

    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        System.out.print("<");
        System.out.print(s2);
        if(attributes!=null){
            for(int x=0;x<attributes.getLength();x++){
                System.out.print(" "+attributes.getQName(x)+ "=\""+attributes.getValue(x)+"\" ");
            }
        }
        System.out.print(">");
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        System.out.print(new String(chars,i,i1));
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        System.out.print("</");
        System.out.print(s2);
        System.out.println(">");
    }
}
