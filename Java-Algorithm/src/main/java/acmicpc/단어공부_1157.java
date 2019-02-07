package acmicpc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 단어공부_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toUpperCase();
        int[] count = new int[26];
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            count[c-'A']++;
        }
        int[] temp = Arrays.copyOf(count,count.length);
        Arrays.sort(temp);
        int t1 = temp[temp.length - 1];
        int t2 = temp[temp.length - 2];
        if(t1 == t2){
            System.out.println("?");
        }else {
            for(int i = 0 ; i < count.length; i++){
                if(count[i] == t1){
                    System.out.println((char) (i + 'A'));
                    break;
                }
            }
        }
    }
}
