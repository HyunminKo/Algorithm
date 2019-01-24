package com.oncoder.exam_9;

public class fourth_detail {
    static int N,M,result = 0;
    static final int BLACK = 0, WHITE = 1;
    static int[][][] coverType = {
            {{0,0},{0,1},{1,0}},
            {{0,0},{0,1},{1,1}},
            {{0,0},{1,0},{1,1}},
            {{0,0},{1,0},{1,-1}}
    };
    static int[][] cornerIndexByType = {
            {0,0},
            {0,1},
            {1,0},
            {1,0}
    };
    public static void main(String[] args) {
//        String[] board = {"X.X","...","X.X"};
//        String[] board = {"...","...","..."};
//        String[] board = {"...","..."};
//        String[] board = {"...","...","...","..."};
//        String[] board = {".X.","...","...","..."};
//          String[] board = {"..X.","X..."};
//        String[] board = {"...",".X."};
//        String[] board = {"X.....XXX.XX..XXXXXXXXX...X.XX.XX....X",".XXXX..X..XXXXXXXX....XX.X.X.X.....XXX","....XX....X.XX..X.X...XX.X..XXXXXXX..X","XX.XXXXX.X.X..X..XX.XXX..XX...XXX.X..."};
//        String[] board = {"......X.X.XXX.X.XX."};
//        String[] board = {"........................................","........................................"};
        String[] board ={"...............","..............."};
        long time = System.nanoTime();
        System.out.println(solution(board));
        System.out.println(System.nanoTime() - time);
    }
    public static int solution(String[] board){
        N = board.length;
        M = board[0].length();
        int[][] map = new int[N][M];
        for(int i = 0 ; i < N; i++){
            String line = board[i];
            for(int j = 0 ; j < M; j++){
                if(line.charAt(j) == 'X'){
                    map[i][j] = -1;
                }else{
                    map[i][j] = 0;
                }
            }
        }
        for(int i = 0 ; i < N-1; i++){
            for(int j = 0 ; j < M; j++){
                if((i + j) % 2 == 0){
                    cover(i,j,map,0,BLACK);
                }else {
                    cover(i,j,map,0,WHITE);
                }
            }
        }
        return result;
    }

    private static void cover(int x, int y, int[][] map, int count, int color) {
        int startIndex= -1, endIndex = -1;
        if(count > result){
            result = count;
        }
        if(map[x][y] != 0)
            return;
        if(color == BLACK){
            startIndex = 0;
            endIndex = 1;
        } else if(color == WHITE){
            startIndex = 1;
            endIndex = 4;
        }
        for(int type = startIndex ; type < endIndex; type++){
            if(set(map,x,y,type,1)){
                for(int i = x; i < N-1; i++){
                    for(int j = 0 ; j < M; j++){
                        if(i == x){
                            if(j <= y) continue;
                        }
                        if((i + j) % 2 == 0){
                            cover(i, j, map, count + 1, BLACK);
                        }else {
                            cover(i, j, map, count + 1, WHITE);
                        }
                    }
                }
                fillTheType(map, x, y, type, -1);
            }
        }
        return ;
    }
    private static boolean set(int[][] map, int x, int y, int type, int delta) {
        boolean flag = true;
        int cx = x + cornerIndexByType[type][0];
        int cy = y + cornerIndexByType[type][1];
        if(cx < 0 || cy < 0 || cx >= N || cy >= M) {
            return false;
        }
        if( (cx + cy) % 2 != 0){
            return false;
        }
        for(int i = 0 ; i < 3; i++){
            int nx = x + coverType[type][i][0];
            int ny = y + coverType[type][i][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == -1) {
                flag = false;
                break;
            }
            if(map[nx][ny] >= 1){
                flag = false;
                break;
            }
        }
        if(flag){
            fillTheType(map, x, y, type, delta);
        }

        return flag;
    }

    private static void fillTheType(int[][] map, int x, int y, int type, int delta) {
        for(int i = 0 ; i < 3; i++){
            int nx = x + coverType[type][i][0];
            int ny = y + coverType[type][i][1];
            map[nx][ny] += delta;
        }
    }
}
