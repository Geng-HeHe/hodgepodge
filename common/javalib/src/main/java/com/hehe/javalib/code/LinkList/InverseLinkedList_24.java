package com.hehe.javalib.code.LinkList;

public class InverseLinkedList_24 {
    /**
     * 反正链表
     */
    public Node inverseLinkedList(Node head){
        Node newNode = new Node<>(null, null);
        while (head != null){
            Node temp = head;
            temp.next = newNode.next;
            newNode.next = temp;
            head = temp.next;
        }
        return newNode.next;
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


