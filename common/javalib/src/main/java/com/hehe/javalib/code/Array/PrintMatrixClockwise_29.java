package com.hehe.javalib.code.Array;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixClockwise_29 {
    /**
     * 题目描述
     * 按顺时针的方向，从外到里打印矩阵的值。下图的矩阵打印结果为：1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
     *
     */
    public static void PrintMatrixClockwise(int[][] matrix){
        int r0 = 0;int r1 = matrix.length-1;
        int c0 = 0;int c1 = matrix[0].length-1;
        List<Integer> ints = new ArrayList<>();
        while (r0 <= r1 && c0 <= c1){
            for (int i = c0; i<=c1 ;i++){
                System.out.print(r0+"   "+i);

                ints.add(matrix[r0][i]);
            }

            for (int i =r0+1; i<=r1;i++ ){
                ints.add(matrix[i][c1]);
            }
            if (r0 != r1){
                for (int i = c1-1; i >= c0;i-- ){
                    ints.add(matrix[r1][i]);
                }
            }

            if (c0 != c1){
                for (int i = r1-1; i> r0 ;i--){
                    ints.add(matrix[i][c0]);
                }
            }


            r0++;r1--;
            c0++;c1--;

        }

        for (int c: ints){
            System.out.print(c+"  ");
        }

    }
}
