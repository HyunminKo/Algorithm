package main.java.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 지형이동 {
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
        int height = 3;
        System.out.println(solution(land,height));
    }
    public static int solution(int[][] land, int height) {
        int answer = 0;
        int N = land.length;
        int M = land[0].length;

        boolean[][] visited = new boolean[N][M];
        int[][] cost =  new int[N][M];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                Queue<Point> q = new LinkedList<>();
                visited[i][j] = true;
                q.add(new Point(i,j));

                while(!q.isEmpty()){
                    Point p = q.poll();
                    for(int k = 0 ; k < 4; k++){
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        int diff = land[nx][ny] - land[p.x][p.y];
                        if(visited[nx][ny]){
                            if(diff <= height){
                                if(diff <= 0) continue;
                                if(cost[nx][ny] > diff){
                                    if(diff <= 0){
                                        cost[nx][ny] = 0;
                                    }else {
                                        cost[nx][ny] = diff;
                                    }
                                    q.add(new Point(nx,ny));
                                }
                            }
                        }else {
                            if(diff > height){
                                cost[nx][ny] = diff;
                            }
                            visited[nx][ny] = true;
                            q.add(new Point(nx,ny));
                        }
                    }
                }
            }
        }
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M ; j++){
                System.out.print(cost[i][j] + " ");
                answer += cost[i][j];
            }
            System.out.println();
        }
        return answer;
    }
    public static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
