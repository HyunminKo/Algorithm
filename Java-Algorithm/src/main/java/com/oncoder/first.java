package com.oncoder;

import java.util.Arrays;

public class first {
    public static int solution(int[] numbers) {
        int size = numbers.length;
        if(size == 1){
            return numbers[0];
        }else if(size % 2 == 0){
            return -1;
        }else {
            Arrays.sort(numbers);
            return numbers[size/2];
        }
    }
    public static void main(String[] args) {
        int[] numbers = new int[] {32,54,27,4,69,96,73,1,100,15,21};
        System.out.println(solution(numbers));
    }
}
