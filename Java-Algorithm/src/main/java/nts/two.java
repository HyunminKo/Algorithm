package nts;

public class two {
    public static void main(String[] args) {
        System.out.println(solution("aabbbccd"));
    }
    public static int solution(String S) {
        int answer = 0;

        int[] count = new int[26]; // count alphabet
        for(int i = 0 ; i < S.length(); i++){
            count[S.charAt(i) - 97]++; // 'a' is 0, 'z' is 25
        }

        for(int i = 0; i < count.length; i++){
            if(count[i] % 2 != 0){
                answer++;
            }
        }
        return answer;
    }
}
