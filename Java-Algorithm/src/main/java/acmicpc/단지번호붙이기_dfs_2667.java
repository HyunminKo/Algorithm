package acmicpc;

import java.util.*;

public class 단지번호붙이기_dfs_2667 {
    static int N;
    static int[][] map = new int[26][26];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited = new boolean[26][26];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i < N; i++){
            String line = sc.nextLine();
            for(int j = 0 ; j < line.length(); j++){
                map[i][j] = line.charAt(j)-'0';
            }
        }
        List<Integer> union = new ArrayList<>();
        int totalUnionCount = 0 ;
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(visited[i][j]) continue;
                if(map[i][j] == 0) continue;
                visited[i][j] = true;
                totalUnionCount += 1;
                int unionCount = dfs(i,j) + 1;
                union.add(unionCount);
            }
        }
        System.out.println(totalUnionCount);
        Collections.sort(union);
        for(int a : union){
            System.out.println(a);
        }
    }

    private static int dfs(int x, int y) {
        int result = 0;
        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if( nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] == 0) continue;

            visited[nx][ny] = true;
            result = result + dfs(nx,ny) + 1;
        }
        return result;
    }
}
