package acmicpc;

import java.util.*;

public class 단지번호붙이기_2667 {
    static int N;
    static int[][] map = new int[26][26];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i < N; i++){
            String line = sc.nextLine();
            for(int j = 0 ; j < line.length(); j++){
                map[i][j] = line.charAt(j)-'0';
            }
        }
        List<Integer> apts = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(map[i][j] == 0 || visited[i][j]) continue;
                Queue<Point> q = new LinkedList<>();
                visited[i][j] = true;
                q.offer(new Point(i,j));
                int size = 0;
                while(!q.isEmpty()){
                    Point p = q.poll();
                    size += 1;
                    for(int k = 0 ; k < 4 ; k++){
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];
                        if( nx < 0 || ny < 0 || nx >= N || ny >= N ) continue;
                        if(map[nx][ny] == 0) continue;
                        if(visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny));
                    }
                }
                apts.add(size);
            }
        }
        Collections.sort(apts);
        System.out.println(apts.size());
        for(int a : apts){
            System.out.println(a);
        }
    }
    public static class Point {
        public int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
