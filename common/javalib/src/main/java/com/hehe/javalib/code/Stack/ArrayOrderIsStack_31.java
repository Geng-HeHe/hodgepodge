package com.hehe.javalib.code.Stack;

import java.util.Stack;

public class ArrayOrderIsStack_31 {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     *
     * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
     */
    public static boolean ArrayIsStack(int[] pushSequence, int[] popSequence ){
        Stack<Integer> stack = new Stack<>();
        int len = pushSequence.length;

        for (int i=0; i< len; i++){
            stack.push(pushSequence[i]);
            if (stack.peek() != popSequence[i]) return false;
        }

        return true;

    }
}

