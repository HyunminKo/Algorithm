package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant,completion));
    }
    public static String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        String answer = null;
        for(String name : completion){
            if(hashMap.containsKey(name)){
                hashMap.put(name,hashMap.get(name)+1);
            }else {
                hashMap.put(name,1);
            }
        }
        for(String name : participant){
            if(!hashMap.containsKey(name)){
                answer = name;
            }else {
                hashMap.put(name,hashMap.get(name)-1);
            }
        }
        if(answer == null){
            for(Map.Entry<String,Integer> entry : hashMap.entrySet()){
                String name = entry.getKey();
                Integer value = entry.getValue();
                if(value != 0){
                    answer = name;
                }
            }
        }
        return answer;
    }
}
