package acmicpc;

import java.math.BigInteger;
import java.util.Scanner;

public class 조합_2407 {
    static BigInteger[][] memo = new BigInteger[1001][1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(bino(n,k));
    }
    private static BigInteger bino(int n, int k) {
        memo[0][0] = BigInteger.valueOf(1);
        memo[1][0] = BigInteger.valueOf(1);
        memo[1][1] = BigInteger.valueOf(1);

        if( n == k || k == 0) return BigInteger.valueOf(1);
        for(int i = 2 ; i <= n; i++){
            for(int j = 0; j <= i && j <= k; j++){
                if(j == 0 || j == i){
                    memo[i][j] = BigInteger.valueOf(1);
                }else {
                    memo[i][j] = memo[i-1][j].add(memo[i-1][j-1]);
                }
            }
        }
        return memo[n][k];
    }
}
