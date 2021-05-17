package com.hehe.javalib.code.tree;

import com.hehe.javalib.list.ArrayList;

public class TreeAddPathNumber_34 {
    /**
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     *
     * 下图的二叉树有两条和为 22 的路径：10, 5, 7 和 10, 12
     */
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> getTreeAddPath(TreeNode<Integer> root, int key){
        backtracking(root, key, new ArrayList<>());
        return ret;

    }

    private void backtracking(TreeNode<Integer> root, int key, ArrayList<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        key =key -  root.val;

        if (key == 0 && root.left == null && root.right ==null){
            ret.add(path);
        }else {
            backtracking(root.left,key,path);
            backtracking(root.right,key,path);
        }
        //代码走到这里，表明要回溯，代表当前path中的root节点我已经不需要了
        path.remove(path.size()-1);

    }

    public static class TreeNode<E>{
        E val;
        TreeNode<E> parent;
        TreeNode<E> left;
        TreeNode<E> right;
        TreeNode(E e){
            this.val = e;
        }

    }
}
