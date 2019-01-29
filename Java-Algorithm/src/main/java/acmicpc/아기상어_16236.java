package acmicpc;

import java.util.*;

public class 아기상어_16236 {
    static int N;
    static int[][] map = new int[21][21];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int fishSize = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Shark babyShark = new Shark(-1,-1,2);
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                int temp = sc.nextInt();
                if(temp == 0) continue;
                if(temp == 9) {
                    babyShark.getPoint().x = i;
                    babyShark.getPoint().y = j;
                } else {
                    fishSize++;
                }
                map[i][j] = temp;
            }
        }
        if(fishSize == 0){
            System.out.println(0);
        }else {
            go(babyShark);
        }
    }

    private static void go(Shark babyShark) {
        int time = 0;
        while(true){
            Fish smallFish = bfs(babyShark);
            int x = smallFish.getPoint().getX();
            int y = smallFish.getPoint().getY();
            if( x == -1 && y == -1) break;
            time += smallFish.getDistance();
            map[babyShark.getPoint().getX()][babyShark.getPoint().getY()] = 0;
            babyShark.upExp();
            babyShark.getPoint().setX(x);
            babyShark.getPoint().setY(y);
            map[x][y] = 0;
            fishSize--;
        }
        System.out.println(time);
    }

    private static Fish bfs(Shark babyShark) {
        Fish smallFish = new Fish(-1,-1,-1);
        if(fishSize == 0){
            return smallFish;
        }
        int minDistance = 0x3f3f3f3f;
        Point destination = new Point(-1,-1);
        boolean[][] visited = new boolean[N][N];
        int [][] distance = new int[N][N];
        for(int[] row: distance){
            Arrays.fill(row,-1);
        }
        distance[babyShark.getPoint().x][babyShark.getPoint().y] = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(babyShark.getPoint());

        int sharkLevel = babyShark.getLevel();

        while(!q.isEmpty()){

            Point p = q.poll();
            for(int i = 0 ; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if( nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if( visited[nx][ny] ) continue;

                if(map[nx][ny] <= sharkLevel){
                    distance[nx][ny] = distance[p.x][p.y] + 1;
                    if(map[nx][ny] != 0 && map[nx][ny] < sharkLevel){
                        boolean change = true;
                        if(minDistance == distance[nx][ny]) {
                            if(nx > destination.getX()){
                                change = false;
                            }else {
                                if(nx == destination.getX()){
                                    if( ny > destination.getY()){
                                        change = false;
                                    }
                                }
                            }
                        }
                        if(change){
                            if(minDistance >= distance[nx][ny]){
                                minDistance = distance[nx][ny];
                                destination.setX(nx);
                                destination.setY(ny);
                            }
                        }
                    }
                    visited[nx][ny] = true;
                    q.offer(new Point(nx,ny));
                }
            }
        }
        smallFish.setPoint(destination);
        smallFish.setDistance(minDistance);
        return smallFish;
    }
    public static class Shark{
        private Point point;
        private int level;
        private int nextFishCount = 2;

        public Shark(int x, int y, int level) {
            this.point = new Point(x,y);
            this.level = level;
        }
        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
        public void upExp(){
            this.nextFishCount--;
            if(nextFishCount == 0){
                setLevel(getLevel() + 1);
                nextFishCount = getLevel();
            }
        }

        public Point getPoint() {
            return point;
        }
    }
    public static class Fish{
        private Point point;
        private int distance;

        public Fish(int x, int y, int distance) {
            this.point = new Point(x,y);
            this.distance = distance;
        }

        public void setPoint(Point point) {
            this.point = point;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Point getPoint() {
            return point;
        }

        public int getDistance() {
            return distance;
        }
    }
    public static class Point {
        private int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}