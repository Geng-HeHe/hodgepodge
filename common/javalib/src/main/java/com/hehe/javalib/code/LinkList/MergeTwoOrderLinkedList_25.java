package com.hehe.javalib.code.LinkList;

public class MergeTwoOrderLinkedList_25 {
    /**
     * 合并两个排序的链表
     */
    public Node<Integer> mergeTwoOrderLinkedList(Node<Integer> node1, Node<Integer> node2){

        Node<Integer> head = new Node<>(null, null);

        Node<Integer> cur = head;
        Node<Integer> p1 = node1;
        Node<Integer> p2 = node2;

        while (p1 != null && p2 != null){
            if (p1.node <= p2.node){
                cur.next = p1;
                p1 = p1.next;
            }else{
                cur.next = p1;
                p2 = p2.next;
            }
            cur = cur.next;
        }

        if (p1 != null){
            cur.next = p1;
        }

        if (p2 != null){
            cur.next = p2;
        }
        return head.next;

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
