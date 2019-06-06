package acmicpc;

import java.util.Scanner;

public class 바이러스_dfs_2606 {
    static int N,E, result = 0;
    static int[][] adjMat;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); E = sc.nextInt();
        adjMat = new int[N][N];
        for(int i = 0 ; i < E; i++){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            adjMat[x][y] = 1;
            adjMat[y][x] = 1;
        }
        boolean[] visited = new boolean[N];
        visited[0] = true;
        dfs(0,visited);
        System.out.println(result);
    }

    private static void dfs(int v, boolean[] visited) {
        for(int i = 0 ; i < N; i++){
            if(i == v) continue;
            if(visited[i]) continue;
            if(adjMat[v][i] == 1){
                result++;
                visited[i] = true;
                dfs(i,visited);
            }
        }
    }
}
