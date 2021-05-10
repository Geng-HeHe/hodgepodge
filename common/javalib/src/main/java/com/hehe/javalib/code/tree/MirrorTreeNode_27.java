package com.hehe.javalib.code.tree;

public class MirrorTreeNode_27 {

    /**
     * 二叉树的镜像
     */

    public void mirror(TreeNode treeNode){
        if (treeNode == null)
            return;
        mirrorTreeNode(treeNode);
    }

    public TreeNode mirrorTreeNode(TreeNode treeNode){
        if (treeNode == null)
            return treeNode;
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
        mirrorTreeNode(treeNode.left);
        mirrorTreeNode(treeNode.right);
        return treeNode;
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
