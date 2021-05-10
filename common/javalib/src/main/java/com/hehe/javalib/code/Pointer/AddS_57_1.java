package com.hehe.javalib.code.Pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class AddS_57_1 {

    /**
     * 在有序数组中找出两个数，使得和为给定的数 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
     */

    public ArrayList<Integer> getAddS(int[] data, int s){
        int left = 0;
        int right = data.length -1;

        while (left < right){
            if (data[left] + data[right] < s){
                left++;
            }else if (data[left] + data[right] > s){
                right--;
            }else {
                return new ArrayList(Arrays.asList(data[left],data[right]));

            }
        }
        return new ArrayList<>();
    }
}
