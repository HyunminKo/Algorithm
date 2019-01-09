package acmicpc;

import java.util.Scanner;

public class 정수삼각형_1932 {
    static int N;
    static int[][] triangle = new int[501][501];
    static int[][] cache = new int[501][501];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 1 ; i <= N; i++){
            for(int j = 0; j< i; j++){
                triangle[i][j] = sc.nextInt();
            }
        }
        int result = 0;
        for(int i = 1 ; i <= N; i++){
            for(int j = 0; j< i; j++){
                if( j == 0 ){
                    cache[i][j] = cache[i-1][j] + triangle[i][j];
                }else {
                    cache[i][j] = Math.max(cache[i-1][j-1],cache[i-1][j]) + triangle[i][j];
                }
                if(result < cache[i][j]){
                    result = cache[i][j];
                }
            }
        }
        System.out.println(result);
    }
}
