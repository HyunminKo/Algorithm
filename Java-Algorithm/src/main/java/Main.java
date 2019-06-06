import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    static ArrayList<Integer> pick = new ArrayList<>();
    static int M = 60;
    static int size = 3;
    public static void main(String[] args) {
//        long time =System.nanoTime();
//        dfs(0);
//        System.out.println(System.nanoTime() - time);
//        time = System.nanoTime();
//        long set = (1 << M) - 1;
//        for(long i = 0; i <= set; i++){
//            if(Long.bitCount(i) == size){
//                int a = 0;
//                for(int j = 0; j < size; j++){
//                    if(((i >> j)&1) == 1){
//                        a++;
//                    }
//                }
//            }
//        }
//        System.out.println(System.nanoTime() - time);
        ArrayList<Integer> indexA = new ArrayList<>();
        indexA.add(0);
        ArrayList<Integer> indexB = new ArrayList<>();
        indexB.add(0);
        indexB.add(1);
        HashSet<Integer> setA = new HashSet<>(indexA);
        HashSet<Integer> setB = new HashSet<>(indexB);
        System.out.println(setA.containsAll(setB));
        System.out.println(setB.containsAll(setA));
        System.out.println(setA.equals(setB));
        System.out.println(setB.equals(setA));
    }

    private static void dfs(int pos) {
        if(pick.size() == size){
            int a= 0;
            for(int i = 0 ; i < pick.size(); i++){
                a++;
            }
            return;
        }
        for(int i = pos; i < M; i++){
            Integer ni = new Integer(i);
            pick.add(ni);
            dfs(i+1);
            pick.remove(ni);
        }
    }
}