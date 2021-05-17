package com.hehe.javalib.code.dynamic;

public class dichotomy_11 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，
     * 我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     */
    public int dichotomy(int[] data){
        int l = 0;
        int h = data.length -1;

        while (l < h){
            int m =1+ (h - l)/2;

            if (data[l] == data[m] && data[m] == data[h])
                return minNumber(data,l, h);

            else if (data[m] < data[h])
                h = m;
            else
                l = m + 1 ;
        }
        return data[l];

    }

    private int minNumber(int[] data, int l, int h) {

        for (int i = l; i< h; i++){
            if (data[i]> data[i+1])
                return data[i+1];
        }

        return data[l];

    }


}
