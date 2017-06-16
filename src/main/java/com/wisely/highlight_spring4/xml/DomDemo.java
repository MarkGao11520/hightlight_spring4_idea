package com.wisely.highlight_spring4.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Created by gaowenfeng on 2017/5/25.
 */
public class DomDemo {

    public static void main(String[] args) {
        create();
    }

    public static void  search(){
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document doc = null;
        try {
            doc = builder.parse("/Users/gaowenfeng/Documents/Myeclipse/hightlight_spring4_idea/src/main/resources/dom_demo.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        NodeList nodeList = doc.getElementsByTagName("linkmen");

        for (int i=0;i<nodeList.getLength();i++){
            Element element =(Element)nodeList.item(i);
            System.out.println(element.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
            System.out.println(element.getElementsByTagName("email").item(0).getFirstChild().getNodeValue());
        }
    }

    public static  void create(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        doc = builder.newDocument();
        Element addresslist = doc.createElement("addresslist");
        Element linkman = doc.createElement("linkman");
        Element name = doc.createElement("name");
        Element email = doc.createElement("email");
        name.appendChild(doc.createTextNode("高文峰"));
        email.appendChild(doc.createTextNode("1152057576@qq.com"));
        linkman.appendChild(name);
        linkman.appendChild(email);
        addresslist.appendChild(linkman);
        doc.appendChild(addresslist);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t  = null;
        try {
            t = tf.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        t.setOutputProperty(OutputKeys.ENCODING,"utf-8");
        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(new File("/Users/gaowenfeng/desktop/aaa.xml"));

        try {
            t.transform(source,result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }



}
