package acmicpc;

import java.util.Scanner;

public class 숫자의개수_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int mulValue = A * B * C;
        int[] countAry = new int[10];
        String num = Integer.toString(mulValue);
        for(int i = 0 ; i < num.length(); i++){
            countAry[num.charAt(i)-'0']++;
        }
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(countAry[i]);
        }
    }
}
