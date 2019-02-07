package acmicpc;

import java.util.*;

public class 유기농배추_1012 {
    static int T,N,M,K;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while( T-- > 0){
            int[][] map = new int[51][51];
            M = sc.nextInt(); N = sc.nextInt(); K = sc.nextInt();
            sc.nextLine();
            for(int i = 0 ; i < K; i++){
                int y = sc.nextInt(); int x = sc.nextInt();
                map[x][y] = 1;
            }
            List<Integer> group = new ArrayList<>();
            boolean[][] visited = new boolean[N][M];
            for(int i = 0 ; i < N; i++){
                for(int j = 0 ; j < M; j++){
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
                            if( nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
                            if(map[nx][ny] == 0) continue;
                            if(visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            q.offer(new Point(nx,ny));
                        }
                    }
                    group.add(size);
                }
            }
            System.out.println(group.size());
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
