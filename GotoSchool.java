package com.jingdianxi.ccf;

import java.util.Scanner;

public class GotoSchool {
    public static void main(String[] args) {
        // 输入信号灯设置
        String[] signal_time = new Scanner(System.in).nextLine().split(" ");
        // 红灯持续时间
        int r = Integer.parseInt(signal_time[0]);
        // 黄灯持续时间
        int y = Integer.parseInt(signal_time[1]);
        // 绿灯持续时间
        int g = Integer.parseInt(signal_time[2]);
        // 路段数量
        int n = new Scanner(System.in).nextInt();
        // 通过路段时情况
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] signal = new Scanner(System.in).nextLine().split(" ");
            arr[i][0] = Integer.parseInt(signal[0]);
            arr[i][1] = Integer.parseInt(signal[1]);
        }
        // 计算结果
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0 || arr[i][0] == 1) {
                result += arr[i][1];
            } else if (arr[i][0] == 2) {
                result += arr[i][1] + r;
            }
        }
        System.out.println(result);
    }
}
