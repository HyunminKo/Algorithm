package programmers;

import java.util.*;

public class 후보키 {
    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }
    public static int solution(String[][] relation) {
        int size = relation[0].length;
        int set = (1 << size) - 1;
        ArrayList<ArrayList<Integer>> candidateKeys = new ArrayList<>();
        for(int i = 1; i <= set; i++){
            ArrayList<Integer> index = new ArrayList<>();
            for(int j = 0 ; j < size; j++){
                if(((i>>j) & 1) == 1){
                    index.add(j);
                }
            }
            if(findCandidateKeys(index,relation)){
                candidateKeys.add(index);
            }
        }
        if(candidateKeys.size() != 0){
            int startIndex = 0;
            while(true){
                if(startIndex >= candidateKeys.size()) break;
                ArrayList<Integer> temp = candidateKeys.get(startIndex);
                HashSet<Integer> setA = new HashSet<>(temp);
                Iterator<ArrayList<Integer>> it = candidateKeys.iterator();
                while(it.hasNext()){
                    HashSet<Integer> setB = new HashSet<>(it.next());
                    if(!setA.equals(setB)){
                        if(setB.containsAll(setA)){
                            it.remove();
                        }
                    }
                }
                startIndex++;
            }
        }
        return candidateKeys.size();
    }

    private static boolean findCandidateKeys(ArrayList<Integer> index, String[][] relation) {
        int row = relation.length;
        boolean flag = true;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < row; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < index.size(); j++){
                int key = index.get(j);
                sb.append(relation[i][key]+",");
            }
            if(map.containsKey(sb.toString())){
                flag = false;
                break;
            }else {
                map.put(sb.toString(),0);
            }
        }
        if(flag){
            return true;
        }
        return false;
    }
}
