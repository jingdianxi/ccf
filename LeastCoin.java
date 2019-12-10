package com.jingdianxi.dp;

import java.util.Scanner;

public class LeastCoin {
    public static void main(String[] args) {
        int[] coins = new int[10]; // 硬币面值数组
        int money = 0; // 待凑金额
        int kind = 0; // 硬币种类数

        while (true) {
            money = new Scanner(System.in).nextInt();
            if (money == 0) {
                break; // 结束标记
            }
            int[] dp = new int[money + 1]; // 动态规划数组
            dp[0] = 0; // 初始化第一个元素为0，凑0元需要0个硬币
            kind = new Scanner(System.in).nextInt();
            for (int i = 0; i < kind; i++) {
                coins[i] = new Scanner(System.in).nextInt(); // 读入硬币面值，存入数组coins
            }
            for (int i = 1; i <= money; i++) {
                dp[i] = 99999; // 初始化数组dp，设置dp[i]为无穷大
            }
            // 从凑1元开始，到money元为止
            for (int i = 1; i <= money; i++) {
                for (int j = 0; j < kind; j++) {
                    if (i >= coins[j] && dp[i - coins[j]] + 1 < dp[i]) {
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
            if (dp[money] == 99999) {
                System.out.println("Impossible");
            } else {
                System.out.println(dp[money]);
            }
            break;
        }
    }
}
