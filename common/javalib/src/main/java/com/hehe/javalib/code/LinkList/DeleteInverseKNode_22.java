package com.hehe.javalib.code.LinkList;


import java.util.LinkedList;

class DeleteInverseKNode_22 {
    /**
     * 删除链表中倒数第 K 个结点
     */

    public void deleteInverseKNode(Node head, int k){
        int p1 = 0,p2 = 0;
        Node node1 = head, node2 = head;
        for (int i=0; i<k; i++){
            node2 = node2.next;
        }

        while (node2 != null){
            node1 = node1.next;
            node2 = node2.next;
        }

        node1.node = node1.next.node;
        node1.next = node1.next.next;

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
