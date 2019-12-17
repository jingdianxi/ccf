package com.jingdianxi.ccf;

import java.util.Scanner;

public class LevenshteinDistance {
    private static int minOfTreeNum(int a, int b, int c) {
        int minNum = a;
        if (minNum > b) {
            minNum = b;
        }
        if (minNum > c) {
            minNum = c;
        }
        return minNum;
    }
    
    public static void main(String[] args) {
        String x = new Scanner(System.in).nextLine();
        String y = new Scanner(System.in).nextLine();
        // 声明一个二维数组存放编辑距离
        int[][] levenST = new int[x.length() + 1][y.length() + 1];

        // 初始化二维数组，即写入最简单情形的levenshtein距离
        for (int i = 0; i <= x.length(); i++) {
            levenST[i][0] = i;
        }
        for (int j = 0; j <= y.length(); j++) {
            levenST[0][j] = j;
        }

        // 将字符串x与y中的字母两两比较，得到相应字符串的编辑距离
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                levenST[i][j] = minOfTreeNum(levenST[i - 1][j] + 1, levenST[i][j - 1] + 1, levenST[i - 1][j - 1] + (x.charAt(i - 1) != y.charAt(j - 1) ? 1 : 0));
            }
        }
        System.out.println("Levenshtein Distance: " + levenST[x.length()][y.length()]);
    }
}
