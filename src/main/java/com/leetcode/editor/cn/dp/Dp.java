package com.leetcode.editor.cn.dp;

/**
 * @author earthchen
 * @date 2021/1/31
 **/
public class Dp {


    /**
     * 递归法
     *
     * @param n
     * @return
     */
    public int 跳台阶2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return 跳台阶2(n - 1) + 跳台阶2(n - 2);
    }

    public int 跳台阶(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Dp dp = new Dp();
        int dp1 = dp.跳台阶(5);
        int dp2 = dp.跳台阶2(5);
        System.out.println(dp1 + "\n" + dp2);
    }
}
