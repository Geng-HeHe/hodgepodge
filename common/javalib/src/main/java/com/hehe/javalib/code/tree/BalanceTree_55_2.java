package com.hehe.javalib.code.tree;

class BalanceTree_55_2 {
    /**
     * 平衡二叉树
     */
    public boolean balance = true;
    public boolean isBalanceTree(TreeNode root){
        balanceTree(root);
        return balance;
    }

    private int balanceTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = balanceTree(root.left);
        int right = balanceTree(root.right);
        if (Math.abs(left-right)>1){
            balance = false;
        }
        return 1+Math.max(left,right);
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
