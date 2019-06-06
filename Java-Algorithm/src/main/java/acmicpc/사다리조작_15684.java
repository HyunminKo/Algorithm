package acmicpc;

import java.util.Scanner;

public class 사다리조작_15684 {
    static int N,M,H,result;
    static int[][] map = new int[31][11];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt(); H = sc.nextInt();
        for(int i = 0 ; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
        }
        result = 4;
        dfs(0,1,1);
        if(result == 4) result = -1;
        System.out.println(result);
    }

    private static void dfs(int count, int x, int y) {
        if(count >= result) return;
        if(check()){
            result = count;
            return;
        }
        if(count == 3) return;
        for(int i = x; i <= H; i++){
            for(int j = y; j < N; j++){
                if(map[i][j] == 0 && map[i][j-1] == 0 && map[i][j+1] == 0){
                    map[i][j] = 1;
                    dfs(count+1,i,j);
                    map[i][j] = 0;
                }
            }
            y = 1;
        }
    }

    private static boolean check() {
        for(int i = 1; i <= N; i++){
            int pos = i;
            for(int j = 1; j <= H; j++){
                if(map[j][pos] == 1){
                    pos++;
                }else if(map[j][pos-1] == 1){
                    pos--;
                }
            }
            if(pos != i){
                return false;
            }
        }
        return true;
    }
}