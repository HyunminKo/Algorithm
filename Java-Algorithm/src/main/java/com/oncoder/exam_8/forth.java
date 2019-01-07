package com.oncoder.exam_8;

import java.util.Arrays;

public class forth {
    static int[][] map = new int[2][3];
    static boolean[][] visited = new boolean[2][3];
    public static void main(String[] args) {
        int rows = 2;
        int cols = 3;
        int[] counts = {5};
        System.out.println(solution(rows,cols,counts));
    }
    public static int solution(int rows, int columns, int[] counts){
        for(int i = 0 ; i  < rows; i++){
            for(int j = 0 ; j < columns; j++){
                go(i,j,counts);
            }
        }
        System.out.println(Arrays.deepToString(map));
        return 0;
    }

    private static int go(int x, int y, int[] counts) {
        int result = 0;
        int sum = 0;
        for(int item : counts){
            sum += item;
        }
        if(sum == 0){
            return 1;
        }
        for(int i = 0 ; i < counts.length; i++){
            if(counts[i] != 0){
                counts[i]--;
                map[x][y] = i+1;
                visited[x][y] = true;
                result += go(x,y,counts);
                map[x][y] -= i+1;
                counts[i]++;
            }
        }
        return result;
    }
}
