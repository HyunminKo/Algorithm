//package com.oncoder.exam_9;
//
//public class fourth {
//    static int N,M,result = 0;
//    static int[][][] coverType = {
//            {{0,0},{0,1},{1,1}},
//            {{0,0},{1,0},{1,1}},
//            {{0,0},{0,1},{1,0}},
//            {{0,0},{1,0},{1,-1}}
//    };
//    static int[][] cornerIndexByType = {
//            {0,1},
//            {1,0},
//            {0,0},
//            {1,0}
//    };
//    int[] dx = {0,-1,0,1};
//    int[] dy = {1,0,-1,0};
//    public static void main(String[] args) {
//        String[] board = {"....","...."};
//        long time = System.nanoTime();
//        System.out.println(solution(board));
//        System.out.println(System.nanoTime() - time);
//    }
//    public static int solution(String[] board){
//        N = board.length;
//        M = board[0].length();
//        int[][] map = new int[N][M];
//        for(int i = 0 ; i < N; i++){
//            String line = board[i];
//            for(int j = 0 ; j < M; j++){
//                if(line.charAt(j) == 'X'){
//                    map[i][j] = -1;
//                }else{
//                    map[i][j] = 0;
//                }
//            }
//        }
//        for(int i = 0 ; i < N; i++){
//            for(int j = 0 ; j < M; j++){
//                cover(i,j,map,0);
//            }
//        }
//        return result;
//    }
//
//    private static void cover(int x, int y, int[][] map,int count) {
//        if(count > result){
//            result = count;
//        }
//        if(map[x][y] != 0)
//            return;
//        for(int type = 0 ; type < 4; type++){
//            if(set(map,x,y,type,1)){
//                for(int i = x; i < N-1; i++){
//                    for(int j = 0 ; j < M; j++){
//                        if(i == x){
//                            if(j <= y) continue;
//                        }
//                        cover(i, j, map, count + 1);
//                    }
//                }
//                fillTheType(map, x, y, type, -1);
//            }
//        }
//        return ;
//    }
//    private static boolean set(int[][] map, int x, int y, int type, int delta) {
//        boolean flag = true;
//        int cx = x + cornerIndexByType[type][0];
//        int cy = y + cornerIndexByType[type][1];
//        if(cx < 0 || cy < 0 || cx >= N || cy >= M) {
//            return false;
//        }
//        if( (cx + cy) % 2 != 0){
//            return false;
//        }
//        for(int i = 0 ; i < 3; i++){
//            int nx = x + coverType[type][i][0];
//            int ny = y + coverType[type][i][1];
//
//            if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == -1) {
//                flag = false;
//                break;
//            }
//            if(map[nx][ny] >= 1){
//                flag = false;
//                break;
//            }
//        }
//        if(flag){
//            fillTheType(map, x, y, type, delta);
//        }
//
//        return flag;
//    }
//
//    private static void fillTheType(int[][] map, int x, int y, int type, int delta) {
//        for(int i = 0 ; i < 3; i++){
//            int nx = x + coverType[type][i][0];
//            int ny = y + coverType[type][i][1];
//            map[nx][ny] += delta;
//        }
//    }
//}
