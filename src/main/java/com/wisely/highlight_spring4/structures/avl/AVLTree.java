package com.wisely.highlight_spring4.structures.avl;

/**
 * Created by gaowenfeng on 2017/8/22.
 */
public class AVLTree<T extends Comparable<T>>{
    private AVLTreeNode<T> mRoot; //根节点


    class AVLTreeNode<T extends Comparable<T>>{
        private T key;  //关键字
        private int height; //高度
        private AVLTreeNode<T> left; //左子树
        private AVLTreeNode<T> right; //右子树

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.height = height;
            this.left = left;
            this.right = right;
        }
    }

    private int height(AVLTreeNode tree){
        if(tree!=null)
            return tree.height;
        return 0;
    }

    private int height(){
        return height(mRoot);
    }

    /**
     * 比较两个数的大小
     * @param a
     * @param b
     * @return
     */
    private int max(int a,int b){
        return a>b?a:b;
    }

    /**
     * 左左旋
     * @param k2
     * @return
     */
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2){
        AVLTreeNode<T> k1;

        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = max(height(k2.left),height(k2.right))+1;
        k1.height = max(height(k1.left),k2.height)+1;

        return k1;
    }

    /**
     * 右右旋
     * @param k1
     * @return
     */
    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> k1){
        AVLTreeNode<T> k2;

        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = max(height(k1.left),height(k1.right))+1;
        k2.height = max(height(k2.right),k1.height)+1;

        return k1;
    }

    /**
     * 双左旋
     * @param k3
     * @return
     */
    private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> k3){
        k3.left = rightRightRotation(k3.left);

        return leftLeftRotation(k3);
    }

    /**
     * 双右旋
     * @param k1
     * @return
     */
    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k1){
        k1.right = leftLeftRotation(k1.right);

        return rightRightRotation(k1);
    }

    /**
     * 将节点插入AVL 树，并返回根节点
     * @param tree 根节点
     * @param key key插入节点的键值
     * @return 根节点
     */
    private AVLTreeNode<T> insert(AVLTreeNode<T> tree,T key){
        if(tree == null){
            tree = new AVLTreeNode<T>(key,null,null);
            if(tree == null){
                //如果为空则新建节点
                System.out.println("添加失败：构造新节点失败");
                return null;
            }
        }else{
            int cmp = key.compareTo(tree.key);
            if(cmp<0){  //添加到左子树的情况
                tree.left=insert(tree.left,key);
                if(height(tree.left)-height(tree.right)==2){
                    // 插入节点后，若AVL数失去平衡，则进行相应的调整
                    if(key.compareTo(tree.left.key)<0)
                        tree = leftLeftRotation(tree);
                    else
                        tree = leftRightRotation(tree);
                }
            }else if(cmp>0){  //添加到右子树的情况
                tree.right=insert(tree.right,key);
                if(height(tree.right)-height(tree.left)==2){
                    if(key.compareTo(tree.right.key)>0)
                        tree = rightRightRotation(tree);
                    else
                        tree = rightLeftRotation(tree);
                }
            }else {
                System.out.println("添加失败：不允许添加相同的节点");
            }

        }

        tree.height = max(height(tree.left),height(tree.right));

        return tree;
    }

    public void insert(T key){
        mRoot = insert(mRoot,key);
    }

    private AVLTreeNode<T> minimum(AVLTreeNode<T> tree){
        if(tree == null)
            return null;
        while (tree.left!=null)
            tree = tree.left;
        return tree;
    }

    public T minimum(){
        AVLTreeNode<T> p = minimum(mRoot);
        if(p!=null)
            return p.key;
        return null;
    }

    private AVLTreeNode<T> maximum(AVLTreeNode<T> tree){
        if(tree == null)
            return null;
        while (tree.right!=null)
            tree = tree.right;
        return tree;
    }

    public T maximum(){
        AVLTreeNode<T> p = maximum(mRoot);
        if(p!=null)
            return p.key;
        return null;
    }

    private AVLTreeNode<T> remove(AVLTreeNode<T> tree,AVLTreeNode<T> z){
        /**
         * 根为空，或者没有要删除的节点
         */
        if(tree == null||z == null)
            return null;
        int cmp = tree.key.compareTo(z.key);
        if(cmp<0){  //要删除的节点位于根的左子树上
            tree.left = remove(tree.left,z);
            if(height(tree.right)-height(tree.left)==2){
                //如果删除以后造成AVL失去平衡，则进行相应的调整
                AVLTreeNode<T> r = tree.right;
                if(height(r.left)>height(r.right))
                    tree = rightLeftRotation(tree);
                else
                    tree = rightRightRotation(tree);
            }
        }else if(cmp>0){  //要删除的节点在根的右子树上
            tree.right = remove(tree.right,z);
            if(height(tree.left)-height(tree.right)==2){
                //如果删除以后造成AVL失去平衡，则进行相应的调整
                AVLTreeNode<T> l = tree.left;
                if(height(l.right)>height(l.left))
                    tree = leftRightRotation(tree);
                else
                    tree = leftLeftRotation(tree);
            }
        }else{  //tree是对应的要删除的节点
            if(tree.left!=null&&tree.right!=null){
                //如果左右孩子都非空
                if(height(tree.left)>height(tree.right)){
                    //如果左子树的高度大于右子树
                    //1.找出左子树的最大节点
                    AVLTreeNode<T> max = maximum(tree);
                    //2.将左子树的最大节点的值给根节点（tree）
                    tree.key = max.key;
                    //3.删除最大节点
                    tree.left = remove(tree.left,max);
                    // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
                }else{
                    //如果右子树的高度大于左子树
                    //1.找出右子树的最小节点
                    AVLTreeNode<T> min = minimum(tree);
                    //2.将最小节点的值给根节点tree
                    tree.key = min.key;
                    //3.删除最小节点
                    tree.right = remove(tree.right,min);
                    // 这类似于用"tree的右子树中最小节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
                }
            }else{
                AVLTreeNode<T> tmp = tree;
                tree = tmp.left!=null?tmp.left:tmp.right;
                tmp = null;
            }
        }

        return tree;

    }

//    public void remove(T key){
//        mRoot =  remove(mRoot,new )
//    }


}
