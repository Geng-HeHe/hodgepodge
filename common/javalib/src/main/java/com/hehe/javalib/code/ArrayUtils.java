package com.hehe.javalib.code;


public class ArrayUtils {

    /**
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     *
     * Input:
     * {2, 3, 1, 0, 2, 5}
     *
     * Output:
     * 2
     */
    public static boolean duplicate(int[] input,int[] duplication){
        if (input == null) return false;

        for (int i=0; i<input.length; i++){
            while (input[i] != i){
                if (input[i] == input[input[i]]){
                    duplication[0] = input[i];
                    return true;
                }
                swep(input,i,input[i]);
            }
        }
        return false;
    }

    private static void swep(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
