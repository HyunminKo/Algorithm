package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 타일링2xN_11726 {
    static int[] dp = new int[1001];
    public static void main(String[] args) {
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < 1001; i++){
            dp[i] = dp[i-1] % 10007 + dp[i-2] % 10007;
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(dp[n] % 10007);
    }
}
