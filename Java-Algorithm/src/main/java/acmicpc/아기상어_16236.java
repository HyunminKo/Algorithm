package acmicpc;

import java.util.*;

public class 아기상어_16236 {
    static int N;
    static int[][] map = new int[21][21];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Shark babyShark = new Shark(-1,-1,2);
        ArrayList<Fish> fishes = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                int temp = sc.nextInt();
                if(temp == 0) continue;
                if(temp == 9) {
                    babyShark.setX(i);
                    babyShark.setY(j);
                }else {
                    fishes.add(new Fish(i,j,temp));
                }
                map[i][j] = temp;
            }
        }
        for(Fish fish : fishes){
            if(fish.getDistance() == -1){
                fish.setDistance(Math.abs(fish.getX() - babyShark.getX()) + Math.abs(fish.getY() - babyShark.getY()));
            }
        }
        fishes.sort(new FishComparator());
        go(babyShark,fishes, 0);
    }

    private static void go(Shark babyShark, ArrayList<Fish> fishes, int time) {
        if(fishes.size() == 0){
            System.out.println(time);
            return ;
        }
        for(int i = 0 ; i < fishes.size(); i++){
            Fish fish = fishes.get(i);
            if(fish.getLevel() < babyShark.getLevel()){
                int[][] visited = new int[N][N];
                int movingTime = canReachToFish(fish,new Shark(babyShark.getX(),babyShark.getY(),babyShark.getLevel()),0,visited);
                if(movingTime != 0x3f3f3f3f){
                    time += movingTime;
                    map[fish.getX()][fish.getY()] = 0;
                    babyShark.upExp(); //물고기 먹음.
                    babyShark.setX(fish.getX());
                    babyShark.setY(fish.getY());
                    fishes.remove(i);
                    caclDistance(babyShark,fishes);
                    fishes.sort(new FishComparator());
                    go(babyShark,fishes,time);
                }
            } else {

            }
        }
        System.out.println(time);
    }

    private static void caclDistance(Shark babyShark, ArrayList<Fish> fishes) {
        for(Fish fish : fishes){
            fish.setDistance(Math.abs(fish.getX() - babyShark.getX()) + Math.abs(fish.getY() - babyShark.getY()));
        }
    }

    private static int canReachToFish(Fish fish, Shark babyShark, int time,int[][] visited) {
        int result = 0x3f3f3f3f;
        int x = babyShark.getX();
        int y = babyShark.getY();
        if(fish.getX() == x && fish.getY() == y){
            result = time;
            return result;
        }
        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(map[nx][ny] > babyShark.getLevel()){
                visited[nx][ny] = -1;
                continue;
            }
            if(map[nx][ny] == -1 || visited[nx][ny] == 1) continue;
            babyShark.setX(nx);
            babyShark.setY(ny);
            visited[nx][ny] = 1;
            result = Math.min(result, canReachToFish(fish,babyShark,time + 1, visited));
            visited[nx][ny] = 0;
        }
        return result;
    }
    public static class Shark{
        private int x,y;
        private int level;
        private int nextFishCount = 2;

        public Shark(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
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
    }
    public static class Fish{
        private int x,y;
        private int distance=-1;
        private int level;

        public Fish(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }

        public int getLevel() {
            return level;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }


    }
    public static class FishComparator implements Comparator<Fish> {
        @Override
        public int compare(Fish o1, Fish o2) {
            if(o1.getDistance() == o2.getDistance()){
                if(o1.getX() == o2.getX()){
                    return o1.getY() - o2.getY();
                }else {
                    return o1.getX() - o2.getX();
                }
            }else{
                return o1.getDistance() - o2.getDistance();
            }
        }
    }
}