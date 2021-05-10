package com.hehe.javalib.code.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigzagTreeNode_32_3 {
    /**
     * 之字形打印二叉树
     */
    public void ZigzagTreeNode(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList allList = new ArrayList<>();
        boolean isreverse = false;

        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList itemList = new ArrayList<>();

            while (size>0){
                TreeNode poll = queue.poll();
                if (poll == null)
                    continue;
                queue.offer(poll.left);
                queue.offer(poll.right);
                itemList.add(poll.val);
                size--;
            }
            if (isreverse)
                Collections.reverse(itemList);

            if (itemList.size()>0)
                allList.add(itemList);
            isreverse = !isreverse;
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
