package kakao;

import java.util.Scanner;

public class 상금헌터_15953 {
    static int N;
    static int[] firstPrize = {500,300,300,200,200,200,50,50,50,50,30,30,30,30,30,10,10,10,10,10,10};
    static int[] secondPrize = {512,256,256,128,128,128,128,64,64,64,64,64,64,64,64,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0 ; i < N; i++){
            int first,second;
            first = sc.nextInt();
            second = sc.nextInt();
            int result = 0;
            if(first != 0 && first <= 21){
                result += firstPrize[first-1];
            }
            if(second != 0 && second <= 31){
                result += secondPrize[second-1];
            }
            System.out.println(result * 10000);
        }
    }
}