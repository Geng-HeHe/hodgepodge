package com.hehe.javalib;

import com.hehe.javalib.code.Array.PrintMatrixClockwise_29;
import com.hehe.javalib.code.Array.ReplaceSpace_5;
import com.hehe.javalib.code.TwoStackToQueue;

public class MyClass {
    public static void main(String[] args) {
/*        int[] input = {4, 3, 1, 0, 2, 5};
        int[] duplication = new int[5];
        boolean duplicate = ArrayUtils.duplicate(input, duplication);
        System.out.print("123 "+duplicate);*/

/*        TwoStackToQueue<String> objectTwoStackToQueue = new TwoStackToQueue<>();

        objectTwoStackToQueue.Push("a");
        objectTwoStackToQueue.Push("b");

        String pop = objectTwoStackToQueue.Pop();*/
        //int [][] arr=new int[][]{{4,5,6,8},{2,3},{1,6,9}};

       int[][] a= new int[][]{ {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16} };
        PrintMatrixClockwise_29.PrintMatrixClockwise(a);

        System.out.print("hehe   "+ ReplaceSpace_5.replaceSpace(new StringBuffer("we are")));

    }
}