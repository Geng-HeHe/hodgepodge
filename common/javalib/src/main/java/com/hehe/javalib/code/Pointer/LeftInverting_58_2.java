package com.hehe.javalib.code.Pointer;

public class LeftInverting_58_2 {
    /**
     * 将字符串 S 从第 K 位置分隔成两个子字符串，并交换这两个子字符串的位置。
     *
     * Input:
     * S="abcXYZdef"
     *
     * ef abcXYZ
     * K=3
     *
     * Output:
     * "XYZdefabc"
     */

    public String getLeftInverting(String str, int k){

        char[] chars = str.toCharArray();
        reverse(chars,0,k-1);
        reverse(chars,k,chars.length-1);
        reverse(chars,0,chars.length-1);

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
