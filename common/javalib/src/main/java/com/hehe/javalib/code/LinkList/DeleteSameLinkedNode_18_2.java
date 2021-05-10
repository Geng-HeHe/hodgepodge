package com.hehe.javalib.code.LinkList;

import java.util.HashSet;

public class DeleteSameLinkedNode_18_2 {

    /**
     * 删除链表中重复的结点
     */
    public void deleteSameNode(Node<Integer> head){

        if (head == null) return;

        HashSet<Integer> set = new HashSet<>();
        Node<Integer> pre = head;
        Node<Integer> cur = head.next;

        while (cur != null){
            if (pre.node == cur.node){
                set.add(pre.node);
            }
            pre = cur;
            cur = cur.next;
        }
        //再根据相同节点删除
        //先删除头部
        while (head != null && set.contains(head.node)){
            head = head.next;
        }
        if (head == null){
            return;
        }

        //开始删除元素
        pre = head;
        cur = head.next;

        while (cur != null){
            if (set.contains(pre.node)){
                pre = cur.next;
                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
            }

        }


    }

    private static class Node<E>{

        E node;
        Node<E> next;

        public Node(E e, Node next){
            this.node = e;
            this.next = next;
        }

    }
}
