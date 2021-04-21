package com.hehe.javalib.code.Stack;

import java.util.Stack;

public class ArrayOrderIsStack_31 {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     *
     * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
     *
     * 使用一个栈来模拟压入弹出操作。每次入栈一个元素后，
     * 都要判断一下栈顶元素是不是当前出栈序列 popSequence 的第一个元素，
     * 如果是的话则执行出栈操作并将 popSequence 往后移一位，继续进行判断。
     */
    public static boolean ArrayIsStack(int[] pushSequence, int[] popSequence ){
        Stack<Integer> stack = new Stack<>();
        int len = pushSequence.length;
        for (int pushIndex = 0,popIndex = 0; pushIndex < len; pushIndex++ ){
            stack.push(pushSequence[pushIndex]);

            while (popIndex < len  && !stack.isEmpty() && stack.peek() == popSequence[popIndex]){
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();

    }
}

