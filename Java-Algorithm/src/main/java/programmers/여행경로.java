package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class 여행경로 {
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[] temp = solution(tickets);
        System.out.println(temp);
    }
    public static String[] solution(String[][] tickets) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String[] ticket : tickets){
            if(!map.containsKey(ticket[0])) map.put(ticket[0],new ArrayList<>());
            map.get(ticket[0]).add(ticket[1]);
        }
        for(String key : map.keySet()){
            map.get(key).sort(Comparator.naturalOrder());
        }
        ArrayList<String> result = new ArrayList<>();
        dfs("ICN",0,map,result,tickets.length);
        String[] answer = new String[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    private static ArrayList<String> dfs(String start, int count, HashMap<String, ArrayList<String>> map, ArrayList<String> result, int size) {
        result.add(start);
        ArrayList<String> temp;
        if(map.containsKey(start)){
            ArrayList<String> list = map.get(start);
            if(list.size() == 0)
                return result;
            for(String next: new ArrayList<>(list)){
                list.remove(next);
                temp = dfs(next,count+1,map,result,size);
                if(temp.size()==size+1){
                    return temp;
                }
            }
        }
        return result;
    }
}
