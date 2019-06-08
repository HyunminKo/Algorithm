package nts;

public class four {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
    public static int solution(int n) {
        String numStr = Integer.toString(n);
        int answer = n;
        while(answer >= 10){
            int sum = 0;
            for(int i = 0 ; i< numStr.length(); i++){
                sum += numStr.charAt(i) - '0';
            }
            numStr = Integer.toString(sum);
            answer = sum;
        }

        return answer;
    }
}
