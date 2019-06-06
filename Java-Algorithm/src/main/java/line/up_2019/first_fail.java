package line.up_2019;

import java.util.Scanner;

public class first_fail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long N_2 = (long) Math.sqrt(N);
        long a = N_2;
        long result = 0;
        if(a * a != N){
            for(long i = 0; a >=0 && (a + 1 + i) <= N; i++){
                if( (a - i) == 1) {
                    result = N - 1;
                    break;
                }
                if( (a - i) * (a + 1 + i) == N){
                    result = (a + 1 + i) - (a - i);
                    System.out.println(a-i+" "+(a+1+i));
                    break;
                }
            }
            System.out.println(result);
        }else {
            System.out.println(0);
        }
    }
}