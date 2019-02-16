package com.oncoder.exam_10;

public class first {
    public static void main(String[] args) {
//        int[] marks = {8,9,10};
        int[] marks = {7,8,9,10};
        System.out.println(solution(marks));
    }
    public static int solution(int[] marks){
        int sum = 0;
        for(int a : marks){
            sum += a;
        }
        double averageNum = (double) sum / (double) marks.length;
        int count = 0;
        while(averageNum < 9.5){
            count += 1;
            sum += 10;
            averageNum = (double) sum / ((double) marks.length + count);
        }
        return count;
    }
}
