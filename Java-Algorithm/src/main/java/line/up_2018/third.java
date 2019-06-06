package line.up_2018;

import java.util.*;

public class third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int maxNum = 0;
        ArrayList<Point> relations = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            maxNum = Math.max(maxNum , Math.max(x,y));
            relations.add(new Point(x,y));
        }
        List<List<Integer>> advList = new ArrayList<>();
        for(int i = 0 ; i < maxNum; i++){
            advList.add(new LinkedList<>());
        }
        for(Point p : relations){
            advList.get(p.x-1).add(p.y-1);
            advList.get(p.y-1).add(p.x-1);
        }
        boolean[] visited = new boolean[maxNum];
        int groupCount = 0;
        for(int i = 0 ; i < maxNum; i++){
            if (advList.get(i).size() != 0) {
                if(!visited[i]){
                    boolean flag = false;
                    Queue<Integer> q = new LinkedList<>();
                    visited[i] = true;
                    q.add(i);
                    while(!q.isEmpty()){
                        int v = q.poll();
                        List<Integer> friends = advList.get(v);
                        for(int j = 0 ; j < friends.size() ; j++){
                            if(!visited[friends.get(j)]){
                                flag = true;
                                visited[friends.get(j)] = true;
                                q.add(friends.get(j));
                            }
                        }
                    }
                    if(flag){
                        groupCount++;
                    }
                }
            }
        }
        System.out.println(groupCount);
    }
    static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
