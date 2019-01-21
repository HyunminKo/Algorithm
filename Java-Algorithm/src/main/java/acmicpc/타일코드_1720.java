package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 타일코드_1720 {
    static int[] dp = new int[31];
    static int[] s = new int[31];
    public static void main(String[] args) {
        Arrays.fill(dp,-1);
        dp[0] = 0; dp[1] = 1; dp[2] = 3;
        for(int i = 3; i < 31; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-2] ;
        }
        s[0] = 0; s[1] = 1; s[2] = 3;
        for(int i = 3; i <31; i++){
            if((i%2)==0){
                s[i] = (dp[i]+dp[i/2+1])/2;
            }else {
                s[i] = (dp[i]+dp[i/2])/2;
            }
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(s[n]);
    }
}
