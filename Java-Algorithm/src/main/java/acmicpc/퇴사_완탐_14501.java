package acmicpc;

import java.util.Scanner;

public class 퇴사_완탐_14501 {
    static int N, ans = 0;
    static int[] days, value;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        days = new int[N];
        value = new int[N];

        for(int i = 0 ; i < N; i ++){
            days[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        go(1,0,0);
        System.out.println(ans);
    }

    private static void go(int index, int day, int val) {
        if(index > N){
            ans = Math.max(val,ans);
            return ;
        }
        if(day == 0 && index + days[index-1] <= N+1){
            go(index+1,days[index-1]-1,val + value[index-1]);
        }else {
            go(index+1,day-1,val);
        }
        go(index+1,day, val);
    }
}
