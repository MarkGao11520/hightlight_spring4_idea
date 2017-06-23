package com.wisely.highlight_spring4.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by gaowenfeng on 2017/6/21.
 */
public class DataTest {
    class Member{
        private int id;
        private String name;

        public Member(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void testData(){
        Member member[] = {new Member(1,"gwf"),new Member(2,"gzf")};
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("/Users/gaowenfeng/desktop/io/file/hello1.txt"));
            for(Member member1:member){
                out.writeUTF(member1.name);
                out.writeInt(member1.id);
            }

            out.flush();
            out.close();

            DataInputStream in = new DataInputStream(new FileInputStream("/Users/gaowenfeng/desktop/io/file/hello1.txt"));
            for(int i=0;i<2;i++){
                System.out.println(in.readUTF()+" "+in.readInt());
            }

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
