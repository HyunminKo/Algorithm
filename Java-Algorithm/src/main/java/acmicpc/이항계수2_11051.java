package acmicpc;

import java.util.Scanner;

public class 이항계수2_11051 {
    static long[][] memo = new long[1001][1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(bino(n,k) % 10007);
    }

    private static long bino(int n, int k) {
        memo[0][0] = 1;
        memo[1][0] = 1;
        memo[1][1] = 1;

        if( n == k || k == 0) return 1;
        for(int i = 2 ; i <= n; i++){
            for(int j = 0; j <= k; j++){
                if(j == 0 || j == i){
                    memo[i][j] = 1;
                }else {
                    memo[i][j] = memo[i-1][j] % 10007 + memo[i-1][j-1]  % 10007;
                }
            }
        }
        return memo[n][k];
    }
}
