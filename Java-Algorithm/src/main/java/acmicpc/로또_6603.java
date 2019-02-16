package acmicpc;

import java.util.Scanner;

public class 로또_6603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int k = sc.nextInt();
            if( k == 0) break;
            int[] s = new int[k];
            for(int i = 0 ; i < k ; i++){
                s[i] = sc.nextInt();
            }
            int size = (1 << k) - 1;
            for(int i = 0; i <= size; i++){
                if(Integer.bitCount(i) == 6){
                    for(int j = 0; j < k; j++){
                        if( ((i >> j) & 1) == 1){
                            System.out.print(s[j]+" ");
                        }
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}
