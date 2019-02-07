package acmicpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 일곱난쟁이_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 9;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i< N; i++){
            arr.add(sc.nextInt());
        }
        for(int i = 1; i < (1<<N) -1 ; i++){
            if(Integer.bitCount(i) == 7){
                int sum = 0;
                List<Integer> temp = new ArrayList<>();
                for(int j = 0; j < N; j++){
                    if((1 & i >> j) == 1){
                        sum += arr.get(j);
                        temp.add(arr.get(j));
                    }
                }
                if(sum == 100 && temp.size() == 7){
                    Collections.sort(temp);
                    for(int a : temp){
                        System.out.println(a);
                    }
                    break;
                }
            }
        }
    }
}
