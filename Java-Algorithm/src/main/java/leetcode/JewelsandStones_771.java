package leetcode;

import java.util.HashMap;
import java.util.Map;

public class JewelsandStones_771 {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA","aAAbbbbb"));
    }
    public static int numJewelsInStones(String J, String S) {
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < S.length(); i++){
            char c = S.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c, 1);
            }
        }
        int result = 0;
        for(int i = 0 ; i < J.length(); i++){
            char c = J.charAt(i);
            if(map.containsKey(c)){
                result += map.get(c);
            }
        }
        return result;
    }

}
