package programmers;

public class 타겟넘버 {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        System.out.println(solution(numbers,3));
    }
    public static int solution(int[] numbers, int target) {
        int answer = dfs(0,0, numbers.length, target, numbers);
        return answer;
    }

    private static int dfs(int count, int total, int size, int target, int[] numbers) {
        if(count == size){
            if(total == target){
                return 1;
            }else {
                return 0;
            }
        }
        int result = 0;
        result += dfs(count+1,total + numbers[count], size, target ,numbers);
        result += dfs(count+1,total - numbers[count], size, target ,numbers);
        return result;
    }
}
