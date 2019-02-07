import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int R;
    static int L;

    static int[][] ground;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int moveCnt = 0;
    static boolean moveChecked = true;
    //    static ArrayList<MoveElement> lList = new ArrayList<>();
    static Map<MoveElement, MoveElement> lMap = new HashMap<>();
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            L = Integer.parseInt(str[1]);
            R = Integer.parseInt(str[2]);

            ground = new int[N][N];
            for (int i = 0; i < N; i++) {// 땅 초기화
                str = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    ground[i][j] = Integer.parseInt(str[j]);
                }
            }

            while(moveChecked) {
                moveChecked = false;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        bfs(i, j);
                    }
                }
                if(moveChecked){
                    moveCnt++;
                }
            }
            System.out.println(moveCnt);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        ArrayList<Point> list = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        int sum = 0;

        q.add(new Point(x, y , ground[x][y]));
        list.add(new Point(x, y , ground[x][y]));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            sum += p.cnt;
            for(int i = 0; i < 4; i++){

                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >=N) continue;
                if(visited[nx][ny] == true) continue;
                int sub = Math.abs(ground[nx][ny] - p.cnt);
                if(sub >= L && sub <=R){
                    q.add(new Point(nx,ny,ground[nx][ny]));
                    list.add(new Point(nx,ny,ground[nx][ny]));
                    visited[nx][ny] = true;
                }
            }
        }
        if(list.size() > 1){
            moveChecked = true;
            int move = sum / list.size();
            for (int j = 0; j < list.size(); j++) {
                Point temp = list.get(j);
                ground[temp.x][temp.y] = move;
            }
        }
    }
    static void movement(){

        for(MoveElement moveElement : lMap.values()){

        }
    }
    static class Point{
        int x,y;
        int cnt;

        public Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static class MoveElement{
        ArrayList<Point> list;
        int sum;

        public MoveElement(ArrayList<Point> list, int sum){
            this.list = list;
            this.sum = sum;
        }
    }
}