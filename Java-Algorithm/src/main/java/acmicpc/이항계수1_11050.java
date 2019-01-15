package acmicpc;

import java.util.Scanner;

public class 이항계수1_11050 {
    static int[][] memo = new int[11][11];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(bino(n,k));
    }

    private static int bino(int n, int k) {
        memo[0][0] = 1;
        memo[1][0] = 1;
        memo[1][1] = 1;

        if( n == k || k == 0) return 1;
        for(int i = 2 ; i <= n; i++){
            for(int j = 0; j <= k; j++){
                if(j == 0 || j == i){
                    memo[i][j] = 1;
                }else {
                    memo[i][j] = memo[i-1][j] + memo[i-1][j-1];
                }
            }
        }
        return memo[n][k];
    }
}
