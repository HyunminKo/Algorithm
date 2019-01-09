package study;

import java.util.Arrays;

public class Fibonacci {
    static int normal_count = 0;
    static int dp_count = 0;

    public static int fib(int n){
        normal_count++;
        if(n<=1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
    public static int fib_memo(int n){
        if(dp[n] != -1){
            return dp[n];
        }
        if(n <= 1){
            dp[n] = 1;
            return dp[n];
        }
        dp[n] = fib_memo(n-1) + fib_memo(n-2);
        return dp[n];
    }
    static int[] dp = new int[15];
    public static int fib_dp(int n){
        dp[0] = 1;
        dp[1] = 1;

        if(n<=1)
            return dp[n];
        if(dp[n] != -1)
            return dp[n];
        for(int i = 2; i <= n; i++){
            dp_count++;
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // 1 1 2 3 5 8
        System.out.println(String.format("fib(5): %d",fib(10)));
        System.out.println(String.format("normal fib count: %d",normal_count));

        Arrays.fill(dp,-1);
        System.out.println(String.format("fib(5): %d",fib_dp(10)));
        System.out.println(String.format("dp fib count: %d",dp_count));
        dp_count = 0;
        System.out.println(String.format("fib(5): %d",fib_dp(10)));
        System.out.println(String.format("dp fib count: %d",dp_count));
    }
}
