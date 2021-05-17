package com.hehe.javalib.code.tree;

public class TreeAndLinkedList_36 {
    /**
     * 将二叉树转化成双向链表
     */
    private TreeNode head = null;
    private TreeNode preNode = null;
    public TreeNode treeAndLinkedList(TreeNode root){
        inorder(root);
        return head;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);

        root.left = preNode;
        if (preNode != null)
            preNode.right = root;
        preNode = root;
        if (head == null)
            head = root;

        inorder(root.right);
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
