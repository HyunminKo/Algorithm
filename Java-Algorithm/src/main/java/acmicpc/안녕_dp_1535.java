package acmicpc;

import java.util.Scanner;

public class 안녕_dp_1535 {
    static int[] happy = new int[21];
    static int[] sad = new int[21];
    static int[][] dp = new int[21][101];
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0; i < N; i++){
            sad[i] = sc.nextInt();
        }
        for(int i = 0; i < N; i++){
            happy[i] = sc.nextInt();
        }
        for(int i = 1 ; i <= N; i++){
            for(int health = 1; health <= 100; health++){
                if(sad[i-1] >= health){
                    dp[i][health] = dp[i-1][health];
                }else {
                    dp[i][health] = Math.max(dp[i-1][health - sad[i-1]]+happy[i-1],dp[i-1][health]);
                }
            }
        }
        System.out.println(dp[N][100]);
    }
}
