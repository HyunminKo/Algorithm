package leetcode;

import java.util.HashSet;

public class uniqueMorseRepresentations_804 {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }
    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        int count = 0;
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < words.length; i++){
            StringBuilder sb = new StringBuilder();
            for(char c:words[i].toCharArray()){
                sb.append(morseCode[c - 'a']);
            }
            if(!set.contains(sb.toString())){
                count++;
                set.add(sb.toString());
            }
        }
        return count;
    }
}
