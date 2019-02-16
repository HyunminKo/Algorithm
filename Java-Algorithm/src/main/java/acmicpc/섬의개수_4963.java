package acmicpc;

import java.util.*;

public class 섬의개수_4963 {
    public static int[] dx = {-1,-1,-1,0,0,1,1,1};
    public static int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int w = sc.nextInt(); int h = sc.nextInt();
            if( w == 0 && h == 0){
                break;
            }
            int[][] map = new int[h][w];
            for(int i = 0 ; i < h; i++){
                for(int j = 0 ; j < w; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            List<Integer> islands = new ArrayList<>();
            boolean[][] visited = new boolean[h][w];
            for(int i = 0 ; i < h; i++){
                for(int j = 0 ; j < w; j++){
                    if(map[i][j] == 0 || visited[i][j]) continue;
                    Queue<Point> q = new LinkedList<>();
                    visited[i][j] = true;
                    q.offer(new Point(i,j));
                    int size = 0;
                    while(!q.isEmpty()){
                        Point p = q.poll();
                        size += 1;
                        for(int k = 0 ; k < 8; k++){
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];
                            if(nx < 0 || ny < 0 || nx>=h || ny>=w) continue;
                            if(map[nx][ny] == 0) continue;
                            if(visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            q.offer(new Point(nx,ny));
                        }
                    }
                    islands.add(size);
                }
            }
            System.out.println(islands.size());
        }
    }
    public static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
