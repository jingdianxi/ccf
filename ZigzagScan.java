package com.jingdianxi.ccf;

import java.util.Scanner;

public class ZigzagScan {
    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        int[][] matrix = new int[num][num];
        for (int i = 0; i < num; i++) {
            String str = new Scanner(System.in).nextLine();
            String[] arr = str.split(" ");
            for (int j = 0; j < num; j++) {
                matrix[i][j] = Integer.parseInt(arr[j]);
            }
        }
        for (int i = 0; i < 2 * num - 1; i++) {
            int start = i < num ? 0 : (i - num + 1);
            int end = i < num ? i : (num - 1);
            if (i % 2 == 0) {
                for (int j = start; j <= end; j++) {
                    System.out.print(matrix[i - j][j] + " ");
                }
            } else {
                for (int j = start; j <= end; j++) {
                    System.out.print(matrix[j][i - j] + " ");
                }
            }
        }
    }
}