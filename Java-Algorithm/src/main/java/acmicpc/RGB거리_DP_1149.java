package acmicpc;

import java.util.Scanner;

public class RGB거리_DP_1149 {
    static int N;
    static int[][] colorCost = new int[1001][3];
    static int[][] cache = new int[1001][3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 1; i <= N; i++){
            for(int j = 0 ; j < 3; j++){
                colorCost[i][j] = sc.nextInt();
            }
        }
        cache[0][0] = cache[0][1] = cache[0][2] = 0;
        for(int i = 1; i <= N; i++){
            cache[i][0] = Math.min(cache[i-1][1],cache[i-1][2]) + colorCost[i][0];
            cache[i][1] = Math.min(cache[i-1][0],cache[i-1][2]) + colorCost[i][1];
            cache[i][2] = Math.min(cache[i-1][0],cache[i-1][1]) + colorCost[i][2];
        }
        System.out.println(Math.min(Math.min(cache[N][0],cache[N][1]),cache[N][2]));
    }
}



