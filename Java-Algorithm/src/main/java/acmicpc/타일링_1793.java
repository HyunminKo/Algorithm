package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 타일링_1793 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try {
                String line = br.readLine();
                if(line == null) break;
                BigInteger[] dp = new BigInteger[251];
                dp[0]=new BigInteger("1");
                dp[1]=new BigInteger("1");
                dp[2]=new BigInteger("3");
                for(int i = 3; i < 251; i++){
                    dp[i] = dp[i-1].add(dp[i-2].multiply(BigInteger.valueOf(2)));
                }
                int n = Integer.parseInt(line);
                System.out.println(dp[n]);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
