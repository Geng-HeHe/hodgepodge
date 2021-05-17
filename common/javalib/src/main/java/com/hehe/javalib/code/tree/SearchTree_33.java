package com.hehe.javalib.code.tree;

public class SearchTree_33 {
    /**
     * 33. 二叉搜索树的后序遍历序列
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
     * 二叉搜索树的中序遍历是有序的，根据这个特性，可以找到各节点的左右子树
     */
    public boolean searchPostOrder(int[] data){
        int last = data[data.length-1];

        return searchPostOrder(0,data.length-1,data);
    }

    private boolean searchPostOrder(int first, int last, int[] data) {
        if (last-first<=1)
            return true;
        int rootVal = data[last];
        int cutIndex = first;
        while (cutIndex< last && data[cutIndex] <= rootVal)
            cutIndex++;

        for (int i=cutIndex; i<last; i++)
            if (data[i]< rootVal)
                return false;

        return searchPostOrder(first,cutIndex-1,data) && searchPostOrder(cutIndex,last-1,data)  ;

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
