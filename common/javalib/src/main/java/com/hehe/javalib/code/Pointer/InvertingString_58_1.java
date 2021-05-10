package com.hehe.javalib.code.Pointer;

import com.sun.scenario.effect.impl.sw.java.JSWEffectPeer;

public class InvertingString_58_1 {
    /**
     * Input:
     * "I am a student."
     *
     * Output:
     * "student. a am I"
     *
     * 先翻转每个单词，再翻转整个字符串。
     *
     * 题目应该有一个隐含条件，就是不能用额外的空间。虽然 Java 的题目输入参数为 String 类型，
     * 需要先创建一个字符数组使得空间复杂度为 O(N)，但是正确的参数类型应该和原书一样，
     * 为字符数组，并且只能使用该字符数组的空间。任何使用了额外空间的解法在面试时都会大打折扣，包括递归解法。
     */

    public  String invertingString(String str){
        int n = str.length();
        char[] chars = str.toCharArray();
        int i=0, j=0;

        while (j<=n){
            if (j == n || chars[j] == ' '){
                reverse(chars, i, j-1);
                i = j+1;
            }
            j++;

        }

        reverse(chars,0,n-1);


        return new String(chars);
    }

    private  void reverse(char[] chars, int i, int j) {
        while (i<j){
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


}
