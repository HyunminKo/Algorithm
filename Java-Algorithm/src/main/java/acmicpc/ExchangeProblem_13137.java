package acmicpc;

import java.util.Scanner;

public class ExchangeProblem_13137 {
    static int N;
    static final int MAX_MONEY = 300000;
    static int[] coins = new int[101];
    static int[] memo = new int[300001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0 ; i < N; i++){
            coins[i] = sc.nextInt();
        }
        coinChangeDP(MAX_MONEY);
        System.out.println(coinChangeGreedy(MAX_MONEY));
    }

    private static String coinChangeGreedy(int maxMoney) {
        String resultStr = "YES";
        for(int i = 1; i <= maxMoney; i++){
            int result = solveGreedy(i);
            if(memo[i] != result){
                System.out.println(memo[i] + " " + result);
                resultStr="NO";
                break;
            }
        }
        return resultStr;
    }

    private static int solveGreedy(int change) {
        int result = 0;
        for(int i = N - 1; i>=0 ; i--){
            if(change >= coins[i]){
                int quotient = change / coins[i];
                result += quotient;
                change = change % coins[i];
            }
        }
        return result;
    }

    private static int coinChangeDP(int maxMoney) {
        for(int i = 1 ; i <= maxMoney; i++){
            int minValue = 1000000;
            for(int j = 0; j < N; j++){
                if(i >= coins[j]){
                    int result = memo[i - coins[j]];
                    if(minValue > result){
                        minValue = result;
                    }
                }
            }
            memo[i] = minValue + 1;
        }
        return memo[maxMoney];
    }
}
