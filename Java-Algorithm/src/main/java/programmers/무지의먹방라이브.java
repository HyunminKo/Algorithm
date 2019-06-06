package programmers;

import java.util.ArrayList;
import java.util.List;

public class 무지의먹방라이브 {
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
        List<Food> foods = new ArrayList<>();
        int n = food_times.length;
        for(int i = 0 ; i < n; i++){
            foods.add(new Food(i+1,food_times[i]));
        }
        foods.sort((Food a, Food b)->a.time-b.time);

        int preTime = 0;
        int i = 0;
        for(Food food : foods){
            long diff = food.time - preTime;
            if(diff != 0){
                long spend = diff * n;
                if(spend <= k){
                    k-=spend;
                    preTime=food.time;
                }else {
                    k %= n;
                    foods.subList(i,food_times.length).sort((Food a, Food b)-> a.index - b.index);
                    return foods.get(i+(int)k).index;
                }
            }
            i++;
            n--;
        }
        return -1;
    }

    private static class Food {
        int index;
        int time;

        public Food(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}
