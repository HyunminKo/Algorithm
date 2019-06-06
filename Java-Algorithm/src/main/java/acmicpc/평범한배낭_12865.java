package acmicpc;

import java.util.Scanner;

public class 평범한배낭_12865 {
    static int[] weight = new int[101];
    static int[] value = new int[101];
    static int[][] K = new int[101][100001];
    static int N,W;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); W = sc.nextInt();
        for(int i = 0 ; i < N; i++){
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        for(int i = 1 ; i <= N; i++){
            for(int j = 1; j <= W; j++){
                if(weight[i-1] > j){
                    K[i][j] = K[i-1][j];
                }else {
                    K[i][j] = Math.max(K[i-1][j-weight[i-1]]+value[i-1],K[i-1][j]);
                }
            }
        }
        System.out.println(K[N][W]);
    }
}

