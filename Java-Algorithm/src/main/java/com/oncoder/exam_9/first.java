package com.oncoder.exam_9;

import java.util.Arrays;

public class first {
    public static void main(String[] args) {
        int T = 47;
//        int[] requiredTime = {4,5,82,3,4,65,7,6,8,7,6,4,8,7,6,37,8};
//        int[] requiredTime = {8,5};
//        int[] requiredTime = {12,3,21,6,4,13};
//        int[] requiredTime ={4747};
//        int[] requiredTime ={47};
        int[] requiredTime = {10000};
        int [] test = solution(T,requiredTime);

        System.out.println(test[0]+" "+test[1]);
    }
    public static int[] solution(int T, int[] requiredTime){
        Arrays.sort(requiredTime);
        int score = 0;
        int badScore = 0;
        int time = 0;
        int result = 0;
        for(int i = 0 ; i < requiredTime.length; i++){
            time += requiredTime[i];
            if(time > T) {
                break;
            }
            score += 1;
            badScore += requiredTime[i];
            result += badScore;
        }
        return new int[]{score,result};
    }
}
