package com.oncoder.exam_10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class second {
    public static void main(String[] args) {
//        int[] type = {3,2,1};
        int[] type = {2,1,1};
//        int[] type = {1,1,2,2,3,3};
//        int[] type = {1,1,1,2,2,3,3};
//        int[] type = {1,1,2,2,3,5};
        System.out.println(solution(type));
    }
    public static int solution(int[] type){
        int[] count = new int[51];
        Arrays.sort(type);
        int idx = 0;
        for(int i = 0 ; i < type.length - 1; i++){
            idx = i;
            if(type[i+1] - type[i] > 1){
                idx -= 1;
                break;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i <= idx + 1; i++){
            set.add(type[i]);
            count[type[i]]++;
        }
        int result = 0;
        int maxNum = type[idx+1];
        for(int i = maxNum; i > 0 ; i--){
            int temp = 1;
            for(int j = 0; j < count.length; j++){
                if(j <= i){
                    if(count[j] != 0){
                        temp*=count[j];
                    }
                }
            }
            result += temp;
        }

        return result;
    }
}
