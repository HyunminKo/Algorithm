import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static int M;
    static int K;
    static int[][] ground;
    static int[][] addEnergy;
    static ArrayList<ArrayList<PriorityQueue<TreeInfo>>> treeQueue = new ArrayList<>();
    static List<TreeInfo> deadList = new LinkedList<>();
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int result = 0;
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            M = Integer.parseInt(str[1]);
            K = Integer.parseInt(str[2]);

            ground = new int[N][N];
            addEnergy = new int[N][N];

            for (int i = 0; i < N+M; i++) {
                str = br.readLine().split(" ");
                ArrayList<PriorityQueue<TreeInfo>> l = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    if(i < N) {
                        ground[i][j] = 5;
                        addEnergy[i][j] = Integer.parseInt(str[j]);
                        PriorityQueue<TreeInfo> q = new PriorityQueue<>();
                        l.add(q);

                    }
                    else{
                        int x = Integer.parseInt(str[0]);
                        int y = Integer.parseInt(str[1]);
                        int z = Integer.parseInt(str[2]);
                        treeQueue.get(x - 1).get(y - 1).add(new TreeInfo(x, y, z));
                        result++;
                        break;
                    }
                }
                if(i<N) {
                    treeQueue.add(l);
                }
            }
            getTreeCnt();
            System.out.println(result);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static void getTreeCnt(){
        for(int i = 0; i< K;i++){
            spring();
            summer();
            deadList.clear();
            fall();
            winter();
        }
    }

    static void spring(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j< N; j++){
                if(treeQueue.get(i).get(j).size() == 0){
                    continue;
                }
                else{
                    LinkedList<TreeInfo> tempList = new LinkedList<>();
                    while(!treeQueue.get(i).get(j).isEmpty()) {
                        TreeInfo tempTree = treeQueue.get(i).get(j).poll();
                        result--;
                        if (ground[i][j] >= tempTree.age) {
                            ground[i][j] = ground[i][j] - tempTree.age;
                            tempTree.age++;
                            tempList.add(tempTree);
//                            treeQueue.get(i).get(j).add(tempTree);
//                            result++;
                        } else {
                            deadList.add(tempTree);
                        }
                    }
                    while(!tempList.isEmpty()){
                        treeQueue.get(i).get(j).add(tempList.remove());
                        result++;
                    }
                }
            }
        }
    }
    static void summer(){
        for(int i = 0; i <deadList.size();i++){
            TreeInfo deadTree = deadList.get(i);
            int energy = deadTree.age/2;
            ground[deadTree.x-1][deadTree.y-1] = ground[deadTree.x-1][deadTree.y-1]+ energy;
        }
    }

    static void fall(){
        for(int i = 0; i< N; i++){
            for(int j=0; j < N; j++){
                if(treeQueue.get(i).get(j).size() == 0){
                    continue;
                }
                else{
                    LinkedList<TreeInfo> tempList = new LinkedList<>();
                    while(!treeQueue.get(i).get(j).isEmpty()){
                        TreeInfo tempTree = treeQueue.get(i).get(j).poll();
                        result--;
                        if(tempTree.age % 5 == 0){
                            for(int k = 0; k <8; k++){
                                int nx = i + dx[k];
                                int ny = j + dy[k];
                                if(nx < 0 || ny < 0 || nx >= N|| ny >= N) continue;
                                treeQueue.get(nx).get(ny).add(new TreeInfo(nx+1,ny+1,1));
                                result++;
                            }
                            tempList.add(tempTree);
//                            treeQueue.get(i).get(j).add(tempTree);
//                            result++;
                        }
                        else{
                            tempList.add(tempTree);
                        }
                    }
                    while(!tempList.isEmpty()){
                        treeQueue.get(i).get(j).add(tempList.remove());
                        result++;
                    }
                }
            }
        }
    }
    static void winter(){
        for(int i = 0; i < N;i++){
            for(int j = 0; j < N; j++){
                ground[i][j] = ground[i][j] + addEnergy[i][j];
            }
        }
    }

    static class TreeInfo implements Comparable<TreeInfo>{
        int x, y, age;

        public TreeInfo(int x, int y , int z){
            this.x = x;
            this.y = y;
            this.age = z;
        }

        @Override
        public int compareTo(TreeInfo o) {
            if(this.age < o.age){
                return -1;
            } else if(this.age > o.age){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
}