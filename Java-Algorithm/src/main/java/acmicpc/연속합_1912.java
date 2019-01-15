package acmicpc;

import java.util.Scanner;

public class 연속합_1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];

        for(int i = 0; i <n; i++){
            dp[i] = sc.nextInt();
        }
        int result = dp[0];
        for(int i = 1; i<n; i++){
            if(dp[i-1] > 0 && (dp[i] + dp[i-1]) > 0){
                dp[i] += dp[i-1];
            }
            if(result < dp[i]){
                result = dp[i];
            }
        }
        System.out.println(result);
    }
}
