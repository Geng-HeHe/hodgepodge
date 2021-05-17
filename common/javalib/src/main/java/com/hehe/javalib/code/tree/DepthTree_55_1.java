package com.hehe.javalib.code.tree;


import java.util.LinkedList;
import java.util.Queue;

public class DepthTree_55_1 {
    /**
     * 求树的深度
     */
    public int getDepthTree(TreeNode root){

        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode poll = queue.poll();
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
                size--;
            }
            depth++;
        }

        return depth;

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
