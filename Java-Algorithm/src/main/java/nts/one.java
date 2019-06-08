package nts;

public class one {
    public static void main(String[] args) {
        System.out.println(solution(33));
    }
    public static int solution(int num) {
        int answer = 0;
        for(int i = 1; i <= num; i++){
            String numStr = Integer.toString(i);
            for(int j = 0 ; j < numStr.length(); j++){
                int element = numStr.charAt(j) - '0';
                if(element == 3 || element == 6 || element == 9){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
