package acmicpc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인구이동_16234 {
    static int N,L,R;
    static int[][] map = new int[51][51];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); L = sc.nextInt(); R = sc.nextInt();
        int[][] newMap = new int[N][N];
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                map[i][j] = sc.nextInt();
                newMap[i][j] = map[i][j];
            }
        }
        int count = 0;
        while(true){
            boolean[][] visited = new boolean[N][N];
            Queue<Point> q = new LinkedList<>();
            for(int i = 0 ; i < N; i++){
                for(int j = 0 ; j < N; j++){
                    if(visited[i][j]) continue;
                    ArrayList<Point> union = new ArrayList<>();
                    q.offer(new Point(i,j));
                    union.add(new Point(i,j));
                    visited[i][j] = true;
                    int sumOfPopulation = 0;
                    int numOfNation = 0;
                    while(!q.isEmpty()){
                        Point p = q.poll();
                        sumOfPopulation += newMap[p.x][p.y];
                        numOfNation += 1;
                        for(int k = 0 ; k < 4; k++){
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];
                            if(nx < 0 || ny < 0 || nx>=N || ny>=N ) continue;
                            if(visited[nx][ny]) continue;
                            int diffOfPopulation = Math.abs(newMap[p.x][p.y] - newMap[nx][ny]);
                            if( L <= diffOfPopulation && diffOfPopulation <= R){
                                visited[nx][ny] = true;
                                Point temp = new Point(nx,ny);
                                q.offer(temp);
                                union.add(temp);
                            }
                        }
                    }
                    for(Point p : union){
                        newMap[p.x][p.y] = sumOfPopulation / numOfNation;
                    }
                }
            }
            if(!doesChangeMap(map,newMap)){
                break;
            } else {
                count++;
                copyMap(newMap,map);
            }
        }
        System.out.println(count);
    }

    private static boolean doesChangeMap(int[][] oldMap, int[][] newMap) {
        boolean result = false;
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(oldMap[i][j] != newMap[i][j]){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    private static void copyMap(int[][] oldMap, int[][] newMap) {
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                newMap[i][j] = oldMap[i][j];
            }
        }
    }

    public static class Point {
        public int x,y;

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
