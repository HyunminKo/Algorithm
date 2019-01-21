package com.oncoder.exam_9;

import java.util.Arrays;

public class third {
    public static void main(String[] args) {
//        int[] answers = {1,0,2,2,0,1};
//        int[] answers = {5,8};
//        int[] answers = {0,0,0,0,0,0};
//        int[] answers = {0};
//        int[] answers = {1,0,1};
//        int[] answers = {0,0};
//        int[] answers ={0,0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12,13,13,14,14,15,15,16,16,17,17,18,18,19,19};
//        int[] answers = {1,0,2,0,1,3};
        int[] answers = {1,0,0,1};
//        int[] answers = {1,1};
        System.out.println(solution(answers));
    }
    public static long solution(int[] answers){
        Arrays.sort(answers);
        int size = answers[answers.length-1]+1;
        int[] count = new int[size];
        for(int item : answers){
            if(item > size) return 0;
            count[item]++;
            if(item != 0){
                if(count[item-1] < count[item]){
                    return 0;
                }
            }
            if(count[item] > 2) return 0;
        }
        long result = 1;
        for(int item : count){
            result *= (long) item;
        }
        if(count[count.length-1] % 2 == 0){
            return result;
        }else {
            return result * 2;
        }
    }
}
