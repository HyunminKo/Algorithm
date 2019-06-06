package line.up_2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long N_2 = (long) Math.sqrt(N);
        ArrayList<Divisor> divisor = new ArrayList<>();
        for(long i = 1; i < N_2; i++){
            if( N % i == 0){
                divisor.add(new Divisor(i,N / i));
            }
        }
        Collections.sort(divisor);
        Divisor d = divisor.get(0);
        System.out.println(Math.abs(d.a-d.b));
    }
    private static class Divisor implements Comparable<Divisor> {
        long a,b;

        public Divisor(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Divisor o) {
            return Math.abs((int)(this. a- this.b))- Math.abs((int)(o.a - o.b));
        }
    }
}
