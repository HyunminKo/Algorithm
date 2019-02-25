package acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 보물섬_2589 {
    static int N,M;
    static boolean[][] visited;
    static int[][] distance, map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); M = sc.nextInt();
        map = new int[N][M];
        sc.nextLine();
        for(int i = 0 ; i < N; i++){
            String line = sc.nextLine();
            for(int j  = 0 ; j < line.length(); j++){
                if(line.charAt(j)=='W'){
                    map[i][j] = 0; //sea
                }else {
                    map[i][j] = 1; //land
                }
            }
        }
        int max = 0;
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                visited = new boolean[N][M];
                distance = new int[N][M];
                Queue<Point> q = new LinkedList<>();
                if(map[i][j] == 0) continue;
                visited[i][j] = true;
                distance[i][j] = 0;
                q.offer(new Point(i,j));
                while(!q.isEmpty()){
                    Point p = q.poll();
                    for(int k = 0 ; k < 4; k++){
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];
                        if(nx < 0 || ny < 0 || nx >=N || ny>=M) continue;
                        if(visited[nx][ny] || map[nx][ny] == 0) continue;
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[p.x][p.y] + 1;
                        q.offer(new Point(nx,ny));
                        max = Math.max(max,distance[nx][ny]);
                    }
                }
            }
        }
        System.out.println(max);
    }
    public static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
