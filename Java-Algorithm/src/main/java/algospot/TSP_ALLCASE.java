package algospot;

import java.util.ArrayList;
import java.util.Scanner;

public class TSP_ALLCASE {
    static int N;
    static int[][] map = new int[10][10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[10];
        path.add(0);
        visited[0] = true;
        System.out.println(TSP(path,visited,0));
        System.out.println(path.toString());
    }

    private static int TSP(ArrayList<Integer> path, boolean[] visited, int cost) {
        if(path.size() == N){
            return cost + map[path.get(path.size()-1)][0];
        }
        int result = 987654321;
        for(int next = 0; next < N; next++){
            if(visited[next]) continue;
            int curr = path.get(path.size()-1);
            path.add(next);
            visited[next] = true;
            result = Math.min(result, TSP(path, visited, cost + map[curr][next]));
            path.remove(path.size()-1);
            visited[next] = false;
        }

        return result;
    }
}
