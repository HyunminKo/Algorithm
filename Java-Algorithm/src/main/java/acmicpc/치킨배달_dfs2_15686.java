package acmicpc;

import java.util.ArrayList;
import java.util.Scanner;

public class 치킨배달_dfs2_15686 {
    static int N,M;
    static int[][] map = new int[51][51];
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> shop = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){
                    house.add(new Point(i,j));
                }else if(map[i][j] == 2){
                    shop.add(new Point(i,j));
                }
            }
        }
        go();
    }

    private static void go() {
        int result = 0x3f3f3f3f;
        int size = (1<<shop.size())-1;
        for(int i = 0 ; i <= size; i++){
            if(Integer.bitCount(i) == M){
                result = Math.min(result,calDistance(i));
            }
        }
        System.out.println(result);
    }

    private static int calDistance(int set) {
        int result = 0;
        int size = shop.size();
        for(Point h : house){
            int distance = 0x3f3f3f3f;
            for(int i = 0; i < size; i++){
                if((1 & (set >> i)) == 1){
                    Point s = shop.get(i);
                    distance = Math.min(distance, Math.abs(h.x - s.x) + Math.abs(h.y - s.y));
                }
            }
            result += distance;
        }
        return result;
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

