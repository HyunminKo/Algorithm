package study;

public class combination_dp {
    static long[][] dp = new long[51][51];
    public static void main(String[] args) {
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        for(int i = 2; i < 51; i++){
            for(int j = 0; j <= i; j++){
                if(j ==0 || i == j){
                    dp[i][j]=1;
                }else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        System.out.println(dp[50][25]);
        System.out.println(dp[31][1]);
    }
}