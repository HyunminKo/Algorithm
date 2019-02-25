package acmicpc;

import java.util.Scanner;

public class 가장큰정사각형_1915 {
    private static int N, M;
    private static int[][] map, dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        N = sc.nextInt(); M = sc.nextInt();
        map = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        sc.nextLine();
        for(int i = 0 ; i < N; i++){
            String line = sc.nextLine();
            int size = line.length();
            for(int j = 0 ; j < size; j++){
                dp[i][j] = map[i][j] = (int)line.charAt(j) - 48;
                if(dp[i][j] == 1)
                    ans = 1;
            }
        }
        for(int i = 1; i <N; i++){
            for(int j = 1; j < M; j++){
                if(map[i][j] == 1){
                    dp[i][j] = Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.println(ans*ans);
    }
}
