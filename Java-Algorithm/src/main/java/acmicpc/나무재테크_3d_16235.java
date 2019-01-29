package acmicpc;

import java.util.*;

public class 나무재테크_3d_16235 {
    static int N,M,K;
    static int[][] farm = new int[11][11];
    static int[][] nutriment = new int[11][11];
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt(); K = sc.nextInt();
        for(int[] row: farm){
            Arrays.fill(row,5);
        }
        ArrayList<ArrayList<PriorityQueue<Tree>>> trees = new ArrayList<>();
        ArrayList<ArrayList<LinkedList<Tree>>> deadTrees = new ArrayList<>();

        for(int i = 0 ; i < N; i++){
            trees.add(new ArrayList<>());
            deadTrees.add(new ArrayList<>());
            for(int j = 0; j < N; j++){
                trees.get(i).add(new PriorityQueue<>());
                deadTrees.get(i).add(new LinkedList<>());
                nutriment[i][j]=sc.nextInt();
            }
        }

        for(int i = 0 ; i < M; i++){
            int x = sc.nextInt(); int y = sc.nextInt(); int age = sc.nextInt();
            trees.get(x-1).get(y-1).offer(new Tree(age));
        }
        for(int i = 0 ; i < K; i++){
            spring(trees,deadTrees);
            summer(deadTrees);
            initDeadTree(deadTrees);
            fall(trees);
            winter();
        }
        int totalOfTrees = 0;
        for(int i = 0 ; i < N; i++){
            ArrayList<PriorityQueue<Tree>> rowTrees = trees.get(i);
            for(int j = 0 ; j < N; j++){
                PriorityQueue<Tree> q = rowTrees.get(j);
                totalOfTrees += q.size();
            }
        }
        System.out.println(totalOfTrees);
    }

    private static void initDeadTree(ArrayList<ArrayList<LinkedList<Tree>>> deadTrees) {
        for(int i = 0 ; i < N; i++){
            ArrayList<LinkedList<Tree>> rowTrees = deadTrees.get(i);
            for(int j = 0; j < N; j++){
                rowTrees.get(j).clear();
            }
        }
    }

    private static void winter() {
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                farm[i][j] += nutriment[i][j];
            }
        }
    }

    private static void fall(ArrayList<ArrayList<PriorityQueue<Tree>>> trees) {
        for(int i = 0 ; i < N; i++){
            ArrayList<PriorityQueue<Tree>> rowTrees = trees.get(i);
            for(int j = 0 ; j < N; j++){
                PriorityQueue<Tree> q = rowTrees.get(j);
                LinkedList<Tree> temp = new LinkedList<>();
                if(q.size() == 0) continue;
                while(!q.isEmpty()){
                    Tree tree = q.poll();
                    if(tree.age % 5 == 0){
                        for(int k = 0 ; k < 8; k++){
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(nx < 0 || ny < 0 || nx>=N || ny>=N ) continue;
                            trees.get(nx).get(ny).add(new Tree(1));
                        }
                    }
                    temp.add(tree);
                }
                q.addAll(temp);
            }
        }
    }

    private static void summer(ArrayList<ArrayList<LinkedList<Tree>>> deadTrees) {
        for(int i = 0 ; i < N; i++){
            ArrayList<LinkedList<Tree>> rowTrees = deadTrees.get(i);
            for(int j = 0 ; j < N; j++){
                LinkedList<Tree> ll = rowTrees.get(j);
                if(ll.size() == 0) continue;
                for(Tree tree: ll){
                    farm[i][j] += tree.age / 2;
                }
            }
        }
    }

    private static void spring(ArrayList<ArrayList<PriorityQueue<Tree>>> trees, ArrayList<ArrayList<LinkedList<Tree>>> deadTrees) {
        for(int i = 0 ; i < N; i++){
            ArrayList<PriorityQueue<Tree>> rowTrees = trees.get(i);
            for(int j = 0 ; j < N; j++){
                PriorityQueue<Tree> q = rowTrees.get(j);
                LinkedList<Tree> temp = new LinkedList<>();
                if(q.size() == 0) continue;
                while(!q.isEmpty()){
                    Tree tree = q.poll();
                    if(farm[i][j] - tree.age >= 0){
                        farm[i][j] -= tree.age;
                        tree.age++;
                        temp.add(tree);
                    }else {
                        deadTrees.get(i).get(j).add(tree);
                    }
                }
                q.addAll(temp);
            }
        }
    }
    public static class Tree implements Comparable<Tree>{
        public int age;

        public Tree(int age) {
            this.age = age;
        }
        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}
