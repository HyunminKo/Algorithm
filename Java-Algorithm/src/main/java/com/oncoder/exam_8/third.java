package com.oncoder.exam_8;

import static java.lang.Math.sqrt;

public class third {
    public static void main(String[] args) {
        if(isPrime(1)){
            System.out.println("sosu");
        }else {
            System.out.println("nope");
        }

    }

    private static boolean isPrime(int num) {
        if(num == 1){
            return false;
        }
        boolean isPrime = true;
        for (int i=2; i<=sqrt(num); ++i)
        {
            if (num / i == 0)
            {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
