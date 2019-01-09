package com.oncoder.exam_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class second {
    public static void main(String[] args) {
//        String[] input = {"010","011","000"};
//        String[] input = {"0110011","0101001","1111010","1010010"};
        String[] input = {"1","0","1","0"};
        System.out.println(solution(input));
    }

    private static String solution(String[] masks) {
        int bitSize = masks[0].length();

        if(masks.length == 1){
            return "NO";
        }
        for(int i = 0 ; i < bitSize; i++){
            int zeroCount = 0;
            int oneCount = 0;
            for(String mask : masks){
                Long bit = Long.parseLong(mask,2);
                if((bit & (1 << (bitSize - 1 - i))) != 0){
                    oneCount++;
                }else {
                    zeroCount++;
                }
            }
            if( zeroCount == 0 || oneCount <= 1){
                return "NO";
            }
        }
        return "YES";
    }
}
