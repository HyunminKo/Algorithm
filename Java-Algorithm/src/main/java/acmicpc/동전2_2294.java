package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 동전2_2294 {
    static int N,K;
    static int[] coins = new int[100001];
    static int[] memo = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); K = sc.nextInt();
        for(int i = 0 ; i < N; i++){
            coins[i] = sc.nextInt();
        }
        Arrays.fill(memo,-1);
        int result = coinChangeAllCase(K);
        if(result >= 0x3f3f3f3f){
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }

    private static int coinChangeAllCase(int change) {
        if(memo[change] != -1) return memo[change];
        if(change == 0){
            return 0;
        }else {
            int minValue = 0x3f3f3f3f;
            for(int i = 0 ; i < N; i++){
                if(change - coins[i] >= 0){
                    int result = coinChangeAllCase(change-coins[i]);
                    if(result < minValue){
                        minValue = result;
                    }
                }
            }
            memo[change] = minValue + 1;
            return memo[change];
        }
    }
}
