package com.oncoder.exam_7;

import java.util.PriorityQueue;
import java.util.ArrayList;
public class third {
    public static class num implements Comparable<num>{
        int num;

        public num(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(num o) {
            return o.num - this.num;
        }

        @Override
        public String toString() {
            return "num{" +
                    "num=" + num +
                    '}';
        }
    }
    public static int solution(int[] candles) {
        int nonZeroCount = candles.length;
        int result = 0;
        PriorityQueue<num> queue = new PriorityQueue<>();
        ArrayList<num> tempList = new ArrayList<>();
        for(int element: candles){
            queue.add(new num(element));
        }
        while(true){
            for(int i = result+1 ; i > 0; i--){
                if(!queue.isEmpty()){
                    num numElement = queue.poll();
                    numElement.setNum(numElement.getNum() - 1);

                    if(numElement.getNum() == 0){
                        nonZeroCount--;
                    }else {
                        tempList.add(numElement);
                    }
                }else {
                    return result;
                }
            }
            while(!tempList.isEmpty()){
                queue.add(tempList.remove(0));
            }
            System.out.println(queue);
            result++;
            if(nonZeroCount < result+1 || queue.size() < result + 1)
                break;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] hints = new int[] {1,1,1,1,1,1,1,1,1,1,1};
//        int[] hints = new int[] {1,2,3,4,5,6};
//        int[] hints = new int[] {5,2,2,1};
//        int[] hints = new int[] {2,2,2};
        System.out.println(solution(hints));

    }
}
