package com.hehe.javalib.code;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 */
public class TwoStackToQueue<E>{
    public Stack<E> in;
    public Stack<E> out;
    public TwoStackToQueue(){
        in = new Stack<E>();
        out = new Stack<E>();
    }
    public void Push(E e){
        in.push(e);
    }
    public E Pop(){
        E value;
        while (!in.empty()){
            out.push(in.pop());
        }
        if (out.empty()) return null;

        value = out.pop();
        return value;
    }
}
