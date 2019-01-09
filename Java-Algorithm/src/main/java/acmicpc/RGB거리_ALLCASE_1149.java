package acmicpc;

import java.util.Scanner;

public class RGB거리_ALLCASE_1149 {
    static int N;
    static int[][] color_cost = new int[1000][3];

    static int result = 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < 3; j++){
                color_cost[i][j] = sc.nextInt();
            }
        }
        boolean visited[] = new boolean[1000];
        drawHouse(0,-1,0,visited);
        System.out.println(result);
    }

    private static int drawHouse(int count, int prevColor, int cost,boolean[] visited) {
        if( count == N){
            result = Math.min(result,cost);
            return cost;
        }
        for(int house = 0 ; house < N; house++){
            if(visited[house]) continue;
            if(house - 1 >= 0 && !visited[house-1]) return -1;
            for(int color = 0; color < 3; color++){
                if(color == prevColor) continue;
                visited[house] = true;
                drawHouse(count + 1,color,cost + color_cost[house][color],visited);
                visited[house] = false;
            }
            return cost;
        }
        return cost;
    }
}



