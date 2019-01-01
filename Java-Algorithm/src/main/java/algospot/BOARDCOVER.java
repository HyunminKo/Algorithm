package algospot;

import java.util.Scanner;

public class BOARDCOVER {
    static int N,M;
    static int[] count_type = new int[4];
    static int[][][] coverType = {
        {{0,0},{0,1},{1,1}},
        {{0,0},{1,0},{1,1}},
        {{0,0},{0,1},{1,0}},
        {{0,0},{1,0},{1,-1}}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
            N = sc.nextInt(); M = sc.nextInt();
            int[][] board = new int[N][M];
            for(int i = 0 ; i < N; i++){
                String line = sc.next();
                for(int j = 0 ; j < M; j++){
                    if(line.charAt(j) == '#'){
                        board[i][j] = -1;
                    }else{
                        board[i][j] = 0;
                    }
                }
            }
            System.out.println(cover(board));
        }
    }

    private static int cover(int[][] board) {
        int x = -1; int y = -1;
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if(board[i][j] == 0){
                    x = i;
                    y = j;
                    break;
                }
            }
            if(x != -1){
                break;
            }
        }
        if(x == -1){
            return 1;
        }
        int result = 0;
        for(int type = 0 ; type < 4; type++){
            if(set(board,x,y,type,1)){
                result += cover(board);
            }
            set(board,x,y,type,-1);
        }
        return result;
    }

    private static boolean set(int[][] board, int x, int y, int type, int delta) {
        boolean flag = true;
        for(int i = 0 ; i < 3; i++){
            int nx = x + coverType[type][i][0];
            int ny = y + coverType[type][i][1];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == -1){
                flag = false;
            }
            else{
                board[nx][ny] += delta;
                count_type[type] += delta;
                if(board[nx][ny] > 1){
                    flag = false;
                }
            }
        }
        return flag;
    }
}
