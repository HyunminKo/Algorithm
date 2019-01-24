package acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_7576 {
    static int N,M;
    static int[][] map = new int[1001][1001];
    static int[] dx ={-1,0,1,0};
    static int[] dy ={0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); N = sc.nextInt();
        Queue<Tomato> q = new LinkedList<>();
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){
                    q.offer(new Tomato(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Tomato tomato = q.poll();
            for(int i = 0 ; i < 4; i++){
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == -1) continue;
                if(map[nx][ny] == 0 || (map[nx][ny] > map[tomato.x][tomato.y] + 1)){
                    map[nx][ny] = map[tomato.x][tomato.y] + 1;
                    q.offer(new Tomato(nx,ny));
                }
            }
        }
        int result = -1;
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if(map[i][j] == 0){
                    System.out.println(result);
                    return;
                }
                result = Math.max(result,map[i][j]);
            }
        }
        System.out.println(result-1);
    }
    public static class Tomato {
        public int x,y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
