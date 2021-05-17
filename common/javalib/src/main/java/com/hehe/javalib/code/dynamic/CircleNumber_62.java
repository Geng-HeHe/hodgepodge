package com.hehe.javalib.code.dynamic;


import java.util.LinkedList;

public class CircleNumber_62 {
    /**
     * 让小朋友们围成一个大圈。然后，随机指定一个数 m，
     * 让编号为 0 的小朋友开始报数。
     * 每次喊到 m-1 的那个小朋友要出列唱首歌，
     * 然后可以在礼品箱中任意的挑选礼物，并且不再回到圈中，
     * 从他的下一个小朋友开始，继续 0...m-1 报数 .... 这样下去 .... 直到剩下最后一个小朋友，可以不用表演。
     */
    public int getCircleNumber(int n, int m){
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        for (int i=0; i<n; i++){
            integerLinkedList.add(i);
        }

        int cur = -1;

        while (integerLinkedList.size()>1){
            for (int i=0; i<m; i++){
                cur++;
                if (cur == integerLinkedList.size())
                    cur = 0;
            }
            integerLinkedList.remove(cur);
            cur--;
        }

        return integerLinkedList.get(0);
    }

    public int getCircleNumberNode(int n, int m){
        Node<Integer> node = new Node<>(0);

        Node<Integer> first = node;

        for (int i=1 ; i<n; i++){
            node.next = new Node(i);
            node = node.next;
        }

        node.next = first;

        while (node.next != node){
            for (int i = 1 ; i< m; i++){
                node = node.next;
            }
            node = node.next.next;
        }

        return node.val;
    }

    public static class Node<E>{
        Node next;
        E val;
        Node(E e){
            this.val = e;
        }
    }


}
