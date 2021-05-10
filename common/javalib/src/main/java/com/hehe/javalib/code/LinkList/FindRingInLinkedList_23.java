package com.hehe.javalib.code.LinkList;

import javax.xml.soap.Node;

public class FindRingInLinkedList_23 {
    /**
     * 一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
     * fast 走的距离是 x入环前， z 入环后的距离
     * slow 走的距离是 x入环前， y 入环后的距离
     *
     * 比如一圈相遇
     * x+z = 2x+2y
     * z= x+2y
     * 所以 当相遇的时候让fast回到起点走X,slow再走x变回相遇
     */
    public Node findRing(Node head){

        Node fast = head;
        Node slow = head;

        while (fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        while (fast == slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

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
