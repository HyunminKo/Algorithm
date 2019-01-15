package acmicpc;

import java.util.Scanner;

public class 평균점수_10039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        for(int i = 0 ; i< 5; i++){
            int temp = sc.nextInt();
            if(temp <= 40){
                result += 40;
            }else {
                result += temp;
            }
        }
        System.out.println(result/5);
    }
}
