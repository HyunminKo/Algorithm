package acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스_bfs_2606 {
    static int N,E,result;
    static boolean[] visited;
    static int[][] adjMatrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); E = sc.nextInt();
        adjMatrix = new int[N][N];
        visited = new boolean[N];
        for(int i = 0 ; i < E; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            adjMatrix[a][b] = 1;
            adjMatrix[b][a] = 1;
        }
        visited[0] = true;
        bfs(0,visited);
        System.out.println(result);
    }

    private static void bfs(int v, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while(!q.isEmpty()){
            int d = q.poll();
            for(int i = 0 ; i < visited.length; i++){
                if(i == d) continue;
                if(visited[i]) continue;
                if(adjMatrix[d][i] == 1){
                    result++;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }

    }
}
