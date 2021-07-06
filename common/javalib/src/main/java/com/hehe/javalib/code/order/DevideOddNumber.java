package com.hehe.javalib.code.order;

public class DevideOddNumber {
    /**
     * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样。
     * 例如对于 [1,2,3,4,5]，调整后得到 [1,3,5,2,4]，而不能是 {5,1,3,4,2} 这种相对位置改变的结果。
     */
    public int[] devideNum(int[] arr){

        for (int i = arr.length-1; i>0; i--){
            for (int j = 0 ; j< i; j++){
                if (arr[j]%2 == 0 && arr[j+1]%2 != 0){
                    swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
