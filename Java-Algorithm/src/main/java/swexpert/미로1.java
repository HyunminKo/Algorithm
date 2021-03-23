package main.java.swexpert;

import java.util.Scanner;

public class 미로1 {
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 10 ; i++){
            int test_case = sc.nextInt();
            sc.nextLine();

            Point s = null,d = null;
            map = new int[16][16];
            boolean[][] visited = new boolean[16][16];

            int result = 0;
            for(int j = 0 ; j < 16; j++){
                String line = sc.nextLine();
                for(int k = 0 ; k < line.length(); k++){
                    map[j][k] = Integer.parseInt(String.valueOf(line.charAt(k)));
                    if(map[j][k] == 2){
                        s = new Point(j,k);
                    }else if (map[j][k] == 3){
                        d = new Point(j,k);
                    }
                }
            }
            dfs(s.x,s.y,visited);
            if(visited[d.x][d.y]) result = 1;
            System.out.println(String.format("#%d %d",test_case,result));
        }
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= 16 || ny >= 16 || visited[nx][ny] || map[nx][ny] == 1) continue;
            visited[nx][ny] = true;
            dfs(nx,ny,visited);
        }
    }

    private static void printMap(boolean[][] visited) {
        for(int j = 0 ; j < 16; j++){
            for(int k = 0 ; k < 15; k++){
                if(visited[j][k]) System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
