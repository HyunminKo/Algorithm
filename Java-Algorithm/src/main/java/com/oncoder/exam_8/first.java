package com.oncoder.exam_8;

public class first {
    public static void main(String[] args) {
        String[] input = {"1-2","3-2","1-2","2-1","2-1","3-2","1-3","3-1","1-2"};
        System.out.println(solution(input));
    }

    private static int solution(String[] swaps) {
        int ballIndex = 1;
        for(String positions: swaps){
            String[] position = positions.split("-");
            int first = Integer.parseInt(position[0]);
            int second = Integer.parseInt(position[1]);

            if(ballIndex == first){
                ballIndex = second;
            }else if(ballIndex == second){
                ballIndex = first;
            }
        }
        return ballIndex;
    }
}
