package com.oncoder.exam_9;

public class second {
    public static void main(String[] args) {
        int N = 100;
//        int[] s = {9,9,9,9,9};
        int[] s = {97};
        System.out.println(solution(N,s));
    }
    public static int solution(int N, int[] s){
        int numOfTotalBuy = 0;
        int size = s.length;
        for(int item : s){
            numOfTotalBuy += item;
        }
        if((numOfTotalBuy/N) + 1 >= size){
            if((numOfTotalBuy/N) + 1 == size){
                return numOfTotalBuy%N;
            }
            else{
                return N;
            }
        }else {
            return 0;
        }
    }
}
