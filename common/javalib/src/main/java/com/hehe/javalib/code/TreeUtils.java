package com.hehe.javalib.code;

import com.hehe.javalib.map.HashMap;

public class TreeUtils {
    /**
     * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 前序 7、4、2、1、3、5、9、8、11、10、12
     * 中序 1、2、3、4、5、7、8、9、10、11、12
     */
    HashMap<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode getTree(int[] preOrder, int[] inOrder){
        for (int i=0; i<inOrder.length; i++){
            indexForInOrders.put(inOrder[i],i);
        }

        return reConstructBinaryTree(preOrder,0,preOrder.length-1,0);
    }

    private TreeNode reConstructBinaryTree(int[] preOrder, int preL,int preR,int inL) {
        if (preL>preR) return null;

        TreeNode<Integer> root = new TreeNode<>(preOrder[preL]);
        int inIndexNode = indexForInOrders.get(preOrder[preL])-inL;
        root.left = reConstructBinaryTree(preOrder,preL+1,preL+inIndexNode,inL);
        root.right = reConstructBinaryTree(preOrder,preL+inIndexNode+1,preR,inL+inIndexNode+1);
        return root;
    }

    protected static class TreeNode<E>{
        private E element;
        private TreeNode<E> left;
        private TreeNode<E> right;
        public TreeNode(E element){
          this.element = element;
        }
    }
}
