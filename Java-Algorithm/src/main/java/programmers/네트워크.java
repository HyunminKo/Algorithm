package programmers;

public class 네트워크 {
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] computers = {{1,1,0},{1,1,1},{0,0,1}};
        System.out.println(solution(3,computers));
    }
    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for(int v = 0; v < n; v++){
            if(!visited[v]){
                answer++;
                visited[v] = true;
                dfs(v,computers);
            }
        }
        return answer;
    }

    private static void dfs(int v, int[][] computers) {
        for(int i = 0 ; i < visited.length; i++){
            if(v == i) continue;
            if(!visited[i] && computers[v][i] == 1){
                visited[i] = true;
                dfs(i,computers);
            }
        }
    }
}
