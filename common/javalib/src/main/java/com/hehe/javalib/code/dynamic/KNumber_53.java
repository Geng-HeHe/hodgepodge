package com.hehe.javalib.code.dynamic;

public class KNumber_53 {
    /**
     * 排序数组中，k出现的次数
     * Input:
     * nums = 1, 2, 3, 3, 3, 3, 4, 6
     * K = 3
     *
     * Output:
     * 4
     *
     * 思路：找到K的第一个位置，和K的最后一个位置
     */

    public int getKNUmber(int[] data, int k){
        int kLeft = getKLeft(data, k);
        int kRight = getKLeft(data, k + 1);
        return kRight - kLeft;
    }

    public int getKLeft(int[] data, int k){
        int l = 0;
        int h = data.length-1;

        while (l<h){
            int m = l + (h-l)/2;
            if (data[m] >= k)
                h = m;
            else
                l = m+1;
        }

        return l;

    }
}
