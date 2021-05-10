package com.hehe.javalib.code.tree;


import javax.swing.tree.TreeNode;

import sun.reflect.generics.tree.Tree;

public class ReconsitutionTree_7 {
    /**
     * 根据二叉树的前序遍历和中序遍历的结果，
     * 重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     */
    public TreeNode ReconsitutionTree(int[] preorder, int[] inorder){
        TreeNode root = reconsitution(preorder, 0, preorder.length-1, inorder, 0,inorder.length-1);
        return root;
    }

    private TreeNode reconsitution(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL>preR || inL > inR)
            return null;

        TreeNode<Integer> rootNode = new TreeNode<>(preorder[preL]);
        for (int i=inL; i<=inR; i++){
            if (inorder[i] == preorder[preL]){
                //中序遍历中找到了根节点
                rootNode.left = reconsitution(preorder,preL+1,preL+i-inL,inorder,inL,i-1);
                rootNode.right = reconsitution(preorder,preL+i-inL+1,preR,inorder,i+1,inR);
                break;
            }
        }
        return rootNode;
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
