package com.oncoder.exam_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class two {
    public static void main(String[] args) {
        String[] input = {"010","011","000"};
        System.out.println(solution(input));
    }

    private static String solution(String[] masks) {
        int bitSize = masks[0].length();

        if(masks.length == 1){
            return "NO";
        }
        String XOR = "";
        String OR = "";
        String AND = "";
        for(int i = 0 ; i < bitSize; i++){
            ArrayList<Integer> piece = new ArrayList<>();
            for(String mask : masks){
                Long bit = Long.parseLong(mask,2);

                if((bit & (1 << (bitSize - 1 - i))) != 0){
                    piece.add(1);
                }else {
                    piece.add(0);
                }
            }
            for(int j = 0 ; j < piece.size() - 1; j++){
                int first = piece.get(j);
                int second = piece.get(j+1);
                XOR += first ^ second;
                OR += first | second;
                AND += first & second;
            }
            int first = piece.get(0);
            int second = piece.get(piece.size()-1);
            XOR += first ^ second;
            OR += first | second;
            AND += first & second;
            Map<String,String> map = new HashMap<>();
            map.put(XOR,XOR);
            if(map.containsKey(OR)){
                return "NO";
            }else {
                map.put(OR,OR);
            }
            if(map.containsKey(AND)){
                return "NO";
            }
            XOR = "";
            OR = "";
            AND = "";

        }
        return "YES";
    }
}
