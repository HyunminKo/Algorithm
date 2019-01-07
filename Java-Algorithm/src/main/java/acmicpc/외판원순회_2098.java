package acmicpc;

import java.util.Scanner;

public class 외판원순회_2098 {
    static int N;
    static int[][] map = new int[16][16];
    static int[][] cache = new int[16][1<<16];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0 ; i<N; i++){
            for(int j = 0 ; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(TSP(0,1));
    }

    private static int TSP(int curr, int visited) {

        if( visited == ((1<<N)-1)){
            if (map[curr][0] != 0){
                return map[curr][0];
            }else {
                return 100000000;
            }
        }

        int result = cache[curr][visited];
        if(result != 0) return result;
        result = 100000000;
        for(int next = 0 ; next < N; next++){
            if((visited & (1<<next)) == (1<<next)) continue;
            if(map[curr][next] == 0) continue;
            result = Math.min(result, TSP(next, visited|(1<<next))+map[curr][next]);
            cache[curr][visited] = result;
        }
        return result;
    }
}