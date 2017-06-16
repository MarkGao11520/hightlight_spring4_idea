package com.wisely.highlight_spring4.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gaowenfeng on 2017/6/3.
 */
public class Main {
    public static void main(String[] args) {
        String line = "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 按时间防守打法较好的关键是，氨基酸粉红色钧达股份上架定时</p>\n" +
                "\n" +
                "<p>asfjhsdjfs</p>";
        String p = "<.?>|\\n";
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(line);
        String p2 = "</.?>";
        Pattern pattern2 = Pattern.compile(p2);
        Matcher matcher2 = pattern2.matcher(matcher.replaceAll(""));
        String p3 = "&nbsp;";
        Pattern pattern3 = Pattern.compile(p3);
        Matcher matcher3 = pattern3.matcher(matcher2.replaceAll("\n"));
        System.out.println(matcher3.replaceAll(" "));
    }
}
