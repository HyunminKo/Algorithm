package acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 양치기꿍_3187 {
    static int N,M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        sc.nextLine();
        for(int i = 0 ; i < N; i++){
            String line = sc.nextLine();
            for(int j = 0; j < line.length(); j++){
                if(line.charAt(j) == '#'){
                    map[i][j] = 3; // 울타리
                }else if(line.charAt(j) == 'v'){
                    map[i][j] = 2; //늑대
                }else if(line.charAt(j) == 'k'){
                    map[i][j] = 1; //양
                }
            }
        }
        Queue<Point> q = new LinkedList<>();
        int sheep = 0;
        int wolves = 0;
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                int numOfSheep = 0;
                int numOfWolves = 0;
                if(!visited[i][j] && map[i][j] != 3){
                    visited[i][j] = true;
                    q.offer(new Point(i,j));
                    while(!q.isEmpty()){
                        Point p = q.poll();
                        if(map[p.x][p.y] == 1){
                            numOfSheep += 1;
                        }
                        if(map[p.x][p.y] == 2){
                            numOfWolves += 1;
                        }
                        for(int k = 0; k < 4; k++){
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];
                            if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 3) continue;
                            if(visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            q.offer(new Point(nx,ny));
                        }
                    }
                }
                if(numOfSheep > numOfWolves){
                    sheep += numOfSheep;
                }else {
                    wolves += numOfWolves;
                }
            }
        }
        System.out.println(sheep + " " + wolves);
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
