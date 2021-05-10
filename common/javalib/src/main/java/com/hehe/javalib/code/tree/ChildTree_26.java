package com.hehe.javalib.code.tree;


public class ChildTree_26 {
    /**
     * 输入两棵二叉树A，B，
     * 判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * 首先找到A树的节点的与B树的根节点的相等
     */
    public boolean isChildTree(TreeNode treeNodeA, TreeNode treeNodeB){
        if (treeNodeA == null || treeNodeB == null)
            return false;

        if (treeNodeA.e == treeNodeB.e){
            //找到A树对应B树的根节点
            if (judge(treeNodeA,treeNodeB)){
                return true;
            }
        }

        return isChildTree(treeNodeA.left,treeNodeB) || isChildTree(treeNodeB.right,treeNodeB);
    }

    private boolean judge(TreeNode nodeA, TreeNode nodeB) {
        //子树匹配完
        if (nodeB == null)
            return true;
        //大树匹配完但是子树没有匹配完
        if (nodeA == null)
            return false;

        if (nodeA.e == nodeB.e){
            return judge(nodeA.left,nodeB.left) && judge(nodeA.right,nodeB.right);
        }
        //进到这里表示有不相等的节点
        return false;
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
