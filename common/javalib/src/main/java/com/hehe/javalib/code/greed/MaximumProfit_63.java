package com.hehe.javalib.code.greed;

public class MaximumProfit_63 {
    /**
     * 股票的最大利润
     */
    public int getMaximumProfit(int[] data){
        if (data.length == 0 || data == null)
            return 0;

        int curMinData = data[0];
        int MaxProfit = 0;

        for (int i=1 ; i< data.length ; i++){
            curMinData = Math.min(curMinData,data[i]);
            MaxProfit = Math.max(MaxProfit, data[i] - curMinData);
        }

        return MaxProfit;
    }
}
