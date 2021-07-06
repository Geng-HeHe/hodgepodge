package com.hehe.javalib.code.tree;


public class NextTreeNode_8 {
    /**
     * 给定一个二叉树和其中的一个结点，
     * 请找出中序遍历顺序的下一个结点并且返回 。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     *
     * 如果是只有一个根节点，则中序遍历的下一个节点为null
     * 如果是父节点，判断又没有右孩子，如果没有
     */
    public TreeNode getNextTreeNode(TreeNode treeNode){

        if (treeNode.right != null){
            TreeNode rightTreeNode = treeNode.right;
            while (rightTreeNode.left != null){
                rightTreeNode = rightTreeNode.left;
            }
            return rightTreeNode;
        }else {
            TreeNode parent = treeNode.parent;
            while (parent != null){
                if (parent.parent.left == parent){
                    return parent;
                }
                parent = parent.parent;
            }

        }

        return null;
/*


        /// 如果是只有一个根节点，则中序遍历的下一个节点为null
        if (treeNode.parent == null && treeNode.left == null && treeNode.right == null)
            return null;
        //如果是叶子节点
        if (treeNode.parent != null && treeNode.left == null && treeNode.right == null){
            ///判断是左叶子还是右叶子
            if (treeNode.parent.left == treeNode){
                ///左节点，则它的中序遍历的下个节点是它的父类节点
                return treeNode.parent;
            }else {
                ///右叶子节点
                TreeNode parent = treeNode.parent;
                //如果父节点有祖父节点
                if (parent.parent != null){
                    if (parent.parent.left == parent){
                        return parent.parent;
                    }else {
                        return null;
                    }
                }else {
                    return null;
                }
            }
        }

        TreeNode treeNodeRight = treeNode.right;
        if (treeNodeRight != null){
            if (treeNodeRight.left != null){
                while (treeNodeRight.left !=null){
                    treeNodeRight = treeNodeRight.left;
                }
                return treeNodeRight;
            }else {
                return treeNodeRight;
            }


        }else {
            return null;
        }
*/

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
