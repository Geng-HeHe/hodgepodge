package com.hehe.javalib.code.Stack;

import java.util.Stack;

public class MinStack_30 {
    /**
     * 实现一个包含 min() 函数的栈，该方法返回当前栈中最小的值。
     */
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int data){
        minStack.push(minStack.isEmpty() ? data : Math.min(data,minStack.peek()));
        dataStack.push(data);
    }

    public void pop(){
        dataStack.pop();
        minStack.pop();
    }

    public int minPop(){
        return minStack.peek();
    }
    public int top(){
        return dataStack.peek();
    }
}
