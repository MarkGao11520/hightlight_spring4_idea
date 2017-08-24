package com.wisely.highlight_spring4.structures.traverse;

import com.wisely.highlight_spring4.structures.queue.LinkedQueue;
import com.wisely.highlight_spring4.structures.queue.Queue;
import com.wisely.highlight_spring4.structures.stack.ArrayStack;
import com.wisely.highlight_spring4.structures.stack.Stack;

/**
 * Created by gaowenfeng on 2017/7/25.
 */
public class Traverse {
    private static final int PRE_ORDER = 1;
    private static final int IN_ORDER = 2;
    private static final int POST_ORDER = 3;


    class TreeNode{
        String info;
        TreeNode llink;
        TreeNode rlink;
    }

    void traverse(TreeNode t,int traversalOrder){
        if(t!=null){
            switch (traversalOrder){
                case PRE_ORDER:
                    System.out.print(t.info+" ");
                    traverse(t.llink,PRE_ORDER);
                    traverse(t.rlink,PRE_ORDER);
                    break;
                case IN_ORDER:
                    traverse(t.llink,IN_ORDER);
                    System.out.print(t.info+" ");
                    traverse(t.rlink,IN_ORDER);
                    break;
                case POST_ORDER:
                    traverse(t.llink,POST_ORDER);
                    traverse(t.rlink,POST_ORDER);
                    System.out.print(t.info+" ");
                    break;
            }
        }
    }

    void preOrderTravrsalWithStack(TreeNode t){
        Stack<TreeNode> stack = new ArrayStack();
        TreeNode n;
        stack.push(t);
        while (!stack.empty()){
            n = stack.pop();
            if(n!=null){
                System.out.println(n.info);
                stack.push(n.rlink);
                stack.push(n.llink);
            }
        }
    }

    void levelOrderTravrsalWishQueue(TreeNode t){
        Queue<TreeNode> queue = new LinkedQueue<>();
        TreeNode n;
        queue.insert(t);
        while (!queue.empty()){
            n = queue.remove();
            if(n!=null){
                System.out.println(n.info);
                queue.insert(n.llink);
                queue.insert(n.rlink);
            }
        }
    }

    public static void main(String[] args) {
        Traverse traverse = new Traverse();
        TreeNode t1 = traverse.new TreeNode();
        TreeNode t2 = traverse.new TreeNode();
        TreeNode t3 = traverse.new TreeNode();
        TreeNode t4 = traverse.new TreeNode();
        TreeNode t5 = traverse.new TreeNode();
        t1.info = "+";
        t2.info = "-";
        t3.info = "z";
        t4.info = "x";
        t5.info = "y";
        t1.llink = t2;
        t1.rlink = t3;
        t2.llink = t4;
        t2.rlink = t5;
        traverse.levelOrderTravrsalWishQueue(t1);
    }
}
