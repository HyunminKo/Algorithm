package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 만들기1로_1463 {
    static int[] dp = new int[1000001];
    public static void main(String[] args) {
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= 1000000; i++){
            go(i);
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(dp[n]);
    }
    public static int go(int n){
        if(dp[n] != -1) return dp[n];
        int result = go(n-1) + 1;
        if(n % 3 == 0){
            result = Math.min(result, go(n/3) + 1);
        }
        if(n % 2 == 0){
            result = Math.min(result, go(n/2) + 1);
        }
        dp[n] = result;
        return result;
    }
}
