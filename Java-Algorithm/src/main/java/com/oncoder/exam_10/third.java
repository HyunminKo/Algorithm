package com.oncoder.exam_10;


import java.util.Arrays;

public class third {
    static int[][] dp = new int[500][500];
    public static void main(String[] args) {
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        dp[0][0] = 0;
        dp[1][1] = 1;
        dp[1][0] = 1;
        solution(9);

    }
    public static int solution(int N){
        System.out.println(comb(10,3));
        return 0;
    }
    static int comb (int n , int k){
        if(dp[n][k] != -1) return dp[n][k];
        if(n == k || k == 0){
            dp[n][k] = 1;
            return 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 0 ; j <= i; j++ ){
                if(j == 0 || i == j){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
}
