package chap10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class section_03 { //최대공약수, 최소공배수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        int bigger = Math.max(N,M);

        for(int i = 1; i <= bigger ; i++){
            if(((N%i)==0) && ((M%i)==0)) arr.add(i);
        }
        System.out.println(arr.get(arr.size()-1));
        System.out.println(gcd(N,M));
        int rN = N,rM = M;
        arr = new ArrayList<>();
        for(int i = 2; i <= bigger ; i++){
            if(((rN%i)==0) && ((rM%i)==0)) {
                arr.add(i);
                rN = rN / i;
                rM = rM / i;
                i=1;
                bigger = Math.max(rN,rM);
            }
        }
        int sum = 1;
        for(int s : arr){
            sum *= s;
        }
        sum *= rN * rM;
        System.out.println(sum);
    }

    private static int gcd(int n, int m) {
        if(m != 0) {
            return gcd(m, n % m);
        }else {
            return n;
        }
    }
}
