package com.hehe.javalib.code.tree;

import com.hehe.javalib.map.TreeMap;

public class SerializeTree_37 {
    /**
     * 序列化和反序列化
     */
    public String serialTree(TreeNode root){
        if (root == null)
            return "#";
        return root.val + "," + serialTree(root.left)+","+serialTree(root.right);
    }

    public TreeNode deserialTree(String serialString){
        return deserial(serialString);
    }

    private int len = 0;
    private TreeNode deserial(String serialString) {
        String[] split = serialString.split(",");
        len++;
        if (len>= split.length) {
            return null;
        }
        TreeNode newTree = null;
        if (!split[len].equals("#")){
            newTree = new TreeNode<>(split[len]);
            newTree.left = deserial(serialString);
            newTree.right = deserial(serialString);

        }
        return newTree;

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
