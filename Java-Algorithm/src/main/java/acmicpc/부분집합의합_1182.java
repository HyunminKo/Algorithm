package acmicpc;

import java.util.Scanner;

public class 부분집합의합_1182 {
    static int N,S;
    static int[] numbers = new int[21];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); S = sc.nextInt();
        for(int i = 0 ; i < N; i++){
            numbers[i] = sc.nextInt();
        }
        int result = 0;
        int maxNum = (1 << N) - 1;
        for(int i = 1 ; i <= maxNum; i++){
            int sum = 0;
            for(int j = 0 ; j < N; j++){
                if( (1 & (i >> j)) == 1){
                    sum += numbers[j];
                }
            }
            if(sum == S){
                result++;
            }
        }
        System.out.println(result);
    }
}
