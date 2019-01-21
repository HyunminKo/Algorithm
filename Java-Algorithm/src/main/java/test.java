import java.util.Arrays;
import java.util.Scanner;

public class test{
    static int N;
    static int[] dp = new int[11];
    public static void main(String[] args) {
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4 ; i < 11; i++){
            go(i);
        }
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0 ; i < N; i++){
            System.out.println(go(sc.nextInt()));
        }
    }

    private static int go(int n) {
        if(dp[n] != -1) return dp[n];
        int result = 0;
        result += go(n-3);
        result += go(n-2);
        result += go(n-1);
        dp[n] = result;
        return result;
    }
}
