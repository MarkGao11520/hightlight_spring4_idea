package com.wisely.highlight_spring4.io;

import org.junit.Test;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by gaowenfeng on 2017/6/25.
 */
public class zipTest {
    @Test
    public void decompressing() {
        long startTime = System.currentTimeMillis();
        try {
            File file = new File("/Users/gaowenfeng/desktop/nio.zip");
            ZipFile zipFile = new ZipFile("/Users/gaowenfeng/desktop/nio.zip");
            System.out.println(zipFile.size());
            ZipInputStream Zin = new ZipInputStream(new FileInputStream(file));//输入源zip路径
            BufferedInputStream Bin = new BufferedInputStream(Zin);
            String Parent = "/Users/gaowenfeng/desktop/"; //输出路径（文件夹目录）
            File Fout = null;
            ZipEntry entry ;
            try {
                entry = Zin.getNextEntry();
                while ((entry = Zin.getNextEntry()) != null) {
                    Fout = new File(Parent, entry.getName());
                    if (!Fout.isDirectory()&&!entry.getName().startsWith("__MACOSX")&&!entry.getName().endsWith(".DS_Store")) {
                        if (!Fout.exists()) {
                            (new File(Fout.getParent())).mkdirs();
                        }
                        FileOutputStream out = new FileOutputStream(Fout);
                        BufferedOutputStream Bout = new BufferedOutputStream(out);
                        int b;
                        while ((b = Bin.read()) != -1) {
                            Bout.write(b);
                        }
                        Bout.close();
                        out.close();
                        System.out.println(Fout + "解压成功");
                    }
                }
                Bin.close();
                Zin.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗费时间： " + (endTime - startTime) + " ms");
    }


}
