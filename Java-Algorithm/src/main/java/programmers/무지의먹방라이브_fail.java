package programmers;

public class 무지의먹방라이브_fail {
    public static void main(String[] args) {
//        int[] food_times = {4, 4, 4, 4};
//        System.out.println(solution(food_times,(long)6));
//        int[] food_times = {3,1,2};
//        System.out.println(solution(food_times,(long)5));
//        int[] food_times = {5, 5, 3, 5};
//        System.out.println(solution(food_times,(long)17));
//        int[] food_times = {5, 5, 0, 5};
//        System.out.println(solution(food_times,(long)17));
        int[] food_times = {3,5,1,6,5,3};
        System.out.println(solution(food_times,(long)20));
    }
    public static int solution(int[] food_times, long k) {
        long sum = 0;
        int nonZeroCount = 0;
        for(int i = 0 ; i <food_times.length ;i++){
            if(food_times[i] != 0) nonZeroCount++;
            sum += food_times[i];
        }
        if(sum < k){
            return -1;
        }
        long quotient = k / (long) nonZeroCount;
        long remainder = k % (long) nonZeroCount;
        int plus = 0;
        for(int i = 0 ; i < food_times.length; i++){
            if(food_times[i] == 0) continue;
            if(food_times[i] - quotient <= 0){
                plus += quotient - food_times[i];
                food_times[i] = 0;
                nonZeroCount--;
            }else {
                food_times[i] -= (int) quotient;
            }
        }
        int lastIndex = -1;
        if(plus > 0){
            for(int i = 0 ; i < food_times.length; i++){
                if(food_times[i] != 0){
                    food_times[i]--;
                    if(food_times[i] == 0) nonZeroCount--;
                    plus--;
                    if(plus == 0) {
                        lastIndex = i;
                        break;
                    }
                }
            }
        }
        int temp = 0;
        while(nonZeroCount > 0){
            lastIndex = (lastIndex+1)%food_times.length;
            for(int i = lastIndex; i < food_times.length; i++){
                if(food_times[i] != 0) {
                    temp++;
                    food_times[i] -= 1;
                    if(food_times[i] == 0){
                        nonZeroCount--;
                    }
                }
                if(temp == remainder+1){
                    return i+1;
                }
            }
        }
        return -1;
    }
}
