package algospot;

import java.util.Arrays;
import java.util.Scanner;

public class JUMPGAME {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-->0){
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            int[][] cache = new int[n][n];
            for(int[] row: cache){
                Arrays.fill(row,-1);
            }
            for(int i = 0 ; i < n; i++){
                for(int j = 0 ; j < n; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            if(jump(0,0,map,cache) == 1){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static int jump(int x, int y, int[][] map, int[][] cache) {
        int size = map[0].length;
        if( x >= size || y >= size) return 0;
        if(x == size-1 && y == size-1) return 1;
        if(cache[x][y] != -1) return cache[x][y];
        int nx = x + map[x][y];
        int ny = y + map[x][y];

        int down = jump(nx,y,map,cache);
        int right = jump(x,ny,map,cache);
        if(down == 1 || right == 1){
            cache[x][y] = 1;
            return 1;
        }else {
            cache[x][y] = 0;
            return 0;
        }
    }
}