package acmicpc;

import java.util.*;

public class 치킨배달_bfs_15686 {
    static int N,M;
    static int[][] map = new int[51][51];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Map<String, Integer> indexMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        ArrayList<Point> houses = new ArrayList<>();
        ArrayList<ChickenPlace> chickenPlaces = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){ // house
                    houses.add(new Point(i,j));
                }else if(map[i][j] == 2){ // chicken place
                    chickenPlaces.add(new ChickenPlace(new Point(i,j)));
                    indexMap.put(Integer.toString(i)+Integer.toString(j),indexMap.size());
                }
            }
        }
        go(houses,chickenPlaces);
    }

    private static void go(ArrayList<Point> houses, ArrayList<ChickenPlace> chickenPlaces) {
        int result = 0x3f3f3f3f;
        if(chickenPlaces.size() == M){
            System.out.println(bfs(houses, chickenPlaces));
        }else {
            int size = (1 << chickenPlaces.size());
            for(int i = 0 ; i < size; i++){
                if(Integer.bitCount(i) == M){
                    for(int j = 0; j < chickenPlaces.size(); j++){
                        if( (1 & (i >> j)) == 1) {
                            ChickenPlace cp = chickenPlaces.get(j);
                            map[cp.p.x][cp.p.y] = 2;
                        }else {
                            ChickenPlace cp = chickenPlaces.get(j);
                            map[cp.p.x][cp.p.y] = 0;
                        }
                    }
                    result = Math.min(result,bfs(houses,chickenPlaces));
                }
            }
        }
        System.out.println(result);
    }

    private static int bfs(ArrayList<Point> houses, ArrayList<ChickenPlace> chickenPlaces) {
        int result = 0;
        for(Point house: houses){
            int minDistance = 0x3f3f3f3f;
            boolean[][] visited = new boolean[N][N];
            int[][] distanceMap = new int[N][N];
            Queue<Point> q = new LinkedList<>();
            q.offer(house);

            while(!q.isEmpty()){
                Point location = q.poll();
                for(int i = 0 ; i < 4; i++){
                    int nx = location.x + dx[i];
                    int ny = location.y + dy[i];

                    if(nx <0 || ny < 0 || nx>=N || ny>=N) continue;
                    if(visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.offer(new Point(nx,ny));
                    distanceMap[nx][ny] = distanceMap[location.x][location.y] + 1;
                    if(map[nx][ny] == 2){
                        int index = indexMap.get(Integer.toString(nx)+Integer.toString(ny));
                        ChickenPlace cp = chickenPlaces.get(index);
                        cp.sumOfDistance += distanceMap[nx][ny];

                        minDistance = Math.min(minDistance , distanceMap[nx][ny]);
                    }
                }
            }
            result += minDistance;
        }
        return result;
    }

    public static class ChickenPlace implements Comparable<ChickenPlace>{
        public Point p;
        public int sumOfDistance = 0;

        public ChickenPlace(Point p) {
            this.p = p;
        }

        @Override
        public int compareTo(ChickenPlace o) {
            return this.sumOfDistance - o.sumOfDistance;
        }

        @Override
        public String toString() {
            return "ChickenPlace{" +
                    "p=" + p +
                    ", sumOfDistance=" + sumOfDistance +
                    '}';
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
