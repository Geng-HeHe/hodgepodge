package com.hehe.javalib.code.tree;

public class SymmetryTree_28 {
    /**
     * 递归的方法实现
     */
    public boolean isSymmetryTree(TreeNode root){
        if (root == null) return false;
       return SymmetryTree(root.left,root.right);
    }

    private boolean SymmetryTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.e == right.e){
            return SymmetryTree(left.left,right.right) && SymmetryTree(left.right,right.left);
        }else {
            return false;
        }
    }

    private static class TreeNode<E>{
        E e;
        TreeNode<E> parent;
        TreeNode<E> left;
        TreeNode<E> right;
        public TreeNode(E e){
            this.e = e;
        }
    }
}
