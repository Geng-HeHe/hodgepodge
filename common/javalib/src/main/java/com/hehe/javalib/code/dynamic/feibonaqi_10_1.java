package com.hehe.javalib.code.dynamic;

import java.util.Arrays;

public class feibonaqi_10_1 {
    /**
     * f(n) = f(n-1) + f(n-2)
     */
    public int feibonaqi(int n){
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return feibonaqi(n-1) + feibonaqi(n-2);
    }

    public int feibonaqi2(int n){
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int sum = 0, one = 0,two = 1;
        for (int i = 2; i<n; i++){
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }

    /**
     * 覆盖矩形
     */
    public int fugaijuxing(int n){
        if (n<=2)
            return n;
        int sum = 0;
        int pre1 = 1;
        int pre2 = 2;
        for (int i=3 ; i<=n; i++){
            sum = pre1 +pre2;
            pre1 = pre2;
            pre2 = sum;
        }

        return sum;
    }

    /**
     * 青蛙跳台阶
     */
    public int qiwa1(int n){
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int sum = 0;
        int pre1 = 1;
        int pre2 = 2;
        for (int i=3; i<=n; i++){
            sum = pre1 + pre2;
            pre1 = pre2;
            pre2 = sum;
        }
        return sum;
    }
    public int jumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }
}
