package com.hehe.javalib.code.Array;

import java.util.BitSet;

class FirstStringOnlyIndex_50 {
    /**
     * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
     *
     * Input: abacc
     * Output: b
     */
    public static int firstStringOnly(String str){
/*        int[] ints = new int[128];
        for (int i=0; i< str.length(); i++){
            ints[str.charAt(i)] ++;
        }

        for (int i = 0; i<ints.length; i++){
            if (ints[i] == 1){
                return i;
            }
        }*/

        BitSet bitSet1 = new BitSet(128);
        BitSet bitSet2 = new BitSet(128);
        for (char c : str.toCharArray()){
            if (!bitSet1.get(c) && !bitSet2.get(c)){
                bitSet1.set(c);
            }
            else if (bitSet1.get(c) && !bitSet2.get(c)){
                bitSet2.set(c);
            }
        }
        for (int i = 0; i<str.length(); i++){
            char c = str.charAt(i);

            if (bitSet1.get(c) && !bitSet2.get(c)){
                return i;
            }
        }
        return -1;
    }
}
