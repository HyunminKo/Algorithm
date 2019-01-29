package acmicpc;

import java.util.*;

public class 치킨배달_dfs_15686 {
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
            result = caclDistance(houses,chickenPlaces);
        }else {
            int size = (1 << chickenPlaces.size());
            for(int i = 0 ; i < size; i++){
                if(Integer.bitCount(i) == M){
                    ArrayList<ChickenPlace> nCP = new ArrayList<>();
                    for(int j = 0; j < chickenPlaces.size(); j++){
                        if( (1 & (i >> j)) == 1) {
                            nCP.add(chickenPlaces.get(j));
                        }
                    }
                    result = Math.min(result,caclDistance(houses,nCP));
                }
            }
        }
        System.out.println(result);
    }

    private static int caclDistance(ArrayList<Point> houses, ArrayList<ChickenPlace> chickenPlaces) {
        int result = 0;
        for(Point house: houses){
            int distance = 0x3f3f3f3f;
            for(ChickenPlace cp : chickenPlaces){
                distance = Math.min(distance, Math.abs(house.x - cp.p.x) + Math.abs(house.y - cp.p.y));
            }
            result += distance;
        }
        return result;
    }

    private static void dfs(int n) {
        if(Integer.bitCount(n) == M){
            System.out.println(Integer.toBinaryString(n));
            return;
        }
        for(int i = n ; i < 13; i++){
            if((n & (1<<i)) == 1) continue;
            dfs(n | (1<<n));
        }
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
