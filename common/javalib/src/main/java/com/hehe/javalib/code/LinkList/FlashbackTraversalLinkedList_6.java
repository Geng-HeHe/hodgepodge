package com.hehe.javalib.code.LinkList;


import java.util.ArrayList;
import java.util.LinkedList;

class FlashbackTraversalLinkedList_6 {
    /**
     * 从尾到头反过来打印出每个结点的值。
     *
     * 方法1， 递归，先将整个第一个元素剩下的整个链表插入，再将元素插入
     * 方法2，建立新链表，采用头插法，反正整个链表
     * 方法3，遍历链表，将元素插入到栈中
     */

    public ArrayList<Integer> getFlashbackTraversalLinkedList(ListNode node){

        ListNode<Integer> head = new ListNode<>(null, null);

        while (node != null){
            ListNode memo = node.next;
            node.next = head.next;
            head.next = node;
            node = memo;
        }

        ArrayList<Integer> integers = new ArrayList<>();
        head = head.next;

        while (head != null){
            integers.add(head.node);
            head = head.next;
        }
        return integers;

    }

    private static class ListNode<E>{
        E node;
        ListNode<E> next;

        public ListNode(E e, ListNode next){
            this.next = next;
            this.node = e;
        }

    }
}
