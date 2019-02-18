package acmicpc;

import java.util.Scanner;

public class 안녕_완전탐색_1535 {
    static int[] happy = new int[21];
    static int[] sad = new int[21];
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

        int maxHappy = 0;
        int size = (1 << N) - 1;
        for(int i = 1; i <= size; i++){
            int health = 100;
            int tempHappy = 0;
            for(int j = 0; j < N; j++){
                if( ((i >> j) & 1) == 1){
                    health -= sad[j];
                    tempHappy += happy[j];
                }
            }
            if(health > 0){
                if(tempHappy > maxHappy){
                    maxHappy = tempHappy;
                }
            }
        }
        System.out.println(maxHappy);
    }
}
