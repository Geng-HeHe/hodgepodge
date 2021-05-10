package com.hehe.javalib.code.LinkList;


public class FirstPublicNodeTwoLinkedList_52 {
    /**
     * 两个链表的第一个公共结点
     *
     * 两个链表的长度不一样。如果两个链表遍历同时到达公共节点，也就是遍历的节点相等
     * 比如 第一个长度是 a 第二个是b
     * 则遍历 a+b 是同步的，则到最后也能找到公共节点
     */
    public Node FirstPublicNodeTwoLinkedList(Node head1, Node head2){

        Node n1 = head1;
        Node n2 = head2;
        while (n1 != n2){
            n1 = (n1!=null) ? n1.next : head2;
            n2 = (n2!=null) ? n2.next : head1;
        }
        return n1;

    }
    private static class Node<E>{
        E node;
        Node<E> next;

        public Node(E e){
            this.node = e;
        }

    }
}
