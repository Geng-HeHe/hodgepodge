package com.hehe.javalib.code.tree;

public class NumberKTreeNode_54 {
    /**
     * 查找第k个节点
     */
    public TreeNode getNumberKTreeNode(TreeNode root, int K){
         inorder(root,K);
         return KTreeNode;
    }

    private int count = 0;
    private TreeNode KTreeNode = null;
    private void inorder(TreeNode root, int k) {
        if (root == null || count>k)
            return ;
        inorder(root.left,k);
        count++;
        if (count == k)
            KTreeNode = root;
        inorder(root.right,k);

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
