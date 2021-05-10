package com.hehe.javalib.code.tree;

import java.util.LinkedList;
import java.util.Queue;

class PrintTree_32_1 {
    /**
     * 从上到下，从左到右打印二叉树
     */

    public void printTree(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.print(poll.val+"  ");
            if (poll.left != null){
                queue.offer(poll.left);
            }
            if (poll.right != null){
                queue.offer(poll.right);
            }
        }


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
