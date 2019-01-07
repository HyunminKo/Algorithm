package com.oncoder.exam_7;

public class two {
    public static int solution(int[] hints) {
        int size = hints.length;
        int result = 0;
        for(int i = 0; i < size; i++){
            int selectNum = hints[i];
            for(int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                int otherNum = hints[j];
                int sum = selectNum + otherNum;
                if (sum % 2 == 0) {
                    int x = sum / 2;
                    int y = selectNum - x;
                    if(y < 0){
                        continue;
                    }
                    result = Math.max(x*y,result);
                } else {
                    continue;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] hints = new int[] {2,100};
        System.out.println(solution(hints));
    }
}
