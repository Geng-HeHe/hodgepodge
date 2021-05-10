package com.hehe.javalib.code.LinkList;

public class DeleteLinkedNode_18_1 {
    /**
     * 在 O(1) 时间内删除链表节点
     */
    public void deleteLinkedNode(Node head, Node tobeDelete){

        if (tobeDelete.next != null){
            tobeDelete.node = tobeDelete.next.node;
            tobeDelete.next = tobeDelete.next.next;
        }else {
            if (head == tobeDelete){
                head = null;
            }else {
                Node node = head;
                while (node.next != tobeDelete){
                    node = node.next;
                }
                node.next = null;

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
