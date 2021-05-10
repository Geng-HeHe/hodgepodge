package com.hehe.javalib.code.LinkList;

public class CopyComplexLinkedList_35 {
    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
     * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的 head。
     */
    public Node copyComplexLinkedList(Node head){
        Node cur = head;
        //复制节点
        while (cur != null){
            Node objectNode = new Node<>(cur.node);
            objectNode.next = cur.next;
            cur.next = objectNode;
            cur = objectNode.next;
        }
        //复制random
        cur = head;
        while (cur != null){
            Node clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = clone.next;
        }

        //拆分
        cur = head;
        Node cloneLinkedList = head.next;
        while (cur.next != null){
            Node temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return cloneLinkedList;

    }

    private static class Node<E>{

        E node;
        Node<E> next;
        Node<E> random;

        public Node(E e){
            this.node = e;
        }

    }
}
