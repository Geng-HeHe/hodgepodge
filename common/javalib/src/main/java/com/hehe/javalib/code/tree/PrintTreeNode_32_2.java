package com.hehe.javalib.code.tree;


import java.util.LinkedList;
import java.util.Queue;

class PrintTreeNode_32_2 {

    /**
     * 分层打印数据
     */
    public void printTreeNode(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count >0){
                TreeNode poll = queue.poll();
                if (poll == null)
                    continue;
                System.out.print(poll.val);
                queue.offer(poll.left);
                queue.offer(poll.right);
                count--;
            }
            System.out.println("");
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
