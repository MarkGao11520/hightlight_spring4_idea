package com.wisely.highlight_spring4.structures.heaptree;

import com.wisely.highlight_spring4.structures.priorityqueue.ComparisonKey;
import com.wisely.highlight_spring4.structures.priorityqueue.PQItemString;

import java.util.ArrayList;

/**
 * Created by gaowenfeng on 2017/7/25.
 */
public class BinaryTreeSearch {
    class TreeNode{
        ComparisonKey key;
        TreeNode llink;
        TreeNode rlink;
    }

    class BinarySearchTree{
        private  TreeNode rootNode;

        private TreeNode insertKey(TreeNode t,ComparisonKey key){
            if(t==null){
                TreeNode n = new TreeNode();
                n.key = key;
                return n;
            }else{
                if(key.compareTo(t.key)<0){
                    t.llink = insertKey(t.llink,key);
                    return t;
                }else{
                    t.rlink = insertKey(t.rlink,key);
                    return t;
                }
            }
        }

        void insert(String k){

            rootNode = insertKey(rootNode,new PQItemString(k));
        }

        TreeNode find(ComparisonKey k){
            TreeNode t = rootNode;
            int result;
            while (t!=null){
                if((result=k.compareTo(t.key))<0)
                    t = t.llink;
                else if(result == 0)
                    return t;
                else
                    t = t.rlink;
            }
            return t;
        }

        TreeNode find(String k){
            return find(new PQItemString(k));
        }

        private void printNode(TreeNode node){
            if(node!=null){
                System.out.print("(");
                printNode(node.llink);
                System.out.print(" "+ node.key+" ");
                printNode(node.rlink);
                System.out.print(")");
            }
        }

        void print(){
            printNode(rootNode);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTreeSearch b = new BinaryTreeSearch();
        BinarySearchTree t = b.new BinarySearchTree();
        t.insert("ORY");
        t.insert("JFK");
        t.insert("BRU");
        t.insert("DUS");
        t.insert("ZRH");
        t.insert("MEX");
        t.insert("ORD");
        t.insert("NRT");
        t.insert("ARN");
        t.insert("GLA");
        t.insert("GCM");

        System.out.println("构造好的二叉树:");
        t.print();
        System.out.println();

        System.out.println("查找ORD");
        TreeNode result = t.find("ORDa");
        if(result!=null){
            System.out.println("找到了，result="+result);
        }else {
            System.out.println("该树中不存在该节点");
        }
    }
}
