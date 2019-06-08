package nts;

import java.util.HashSet;
import java.util.Set;

public class three {
    public static void main(String[] args) {
        System.out.println(solution(2322));
    }
    public static int solution(long n) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        String temp = Long.toString(n);
        for(int i = 0 ; i < temp.length(); i++){
            int element = temp.charAt(i)-'0';
            if(element == 0) continue;
            if(set.contains(element)) continue;
            if( (n % element) == 0){
                set.add(element);
                answer++;
            }
        }
        return answer;
    }
}
