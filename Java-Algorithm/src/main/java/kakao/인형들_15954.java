package kakao;

import java.util.Scanner;

public class 인형들_15954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        double[] numsOfLikeDoll = new double[n];
        double[] accumOfSum = new double[n];
        double[] accumOfSquareSum = new double[n];
        for(int i = 0 ; i < n; i++){
            numsOfLikeDoll[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n; i++){
            if(i == 0){
                accumOfSum[i] = numsOfLikeDoll[i];
                accumOfSquareSum[i] = Math.pow(numsOfLikeDoll[i],2);
            }else {
                accumOfSum[i] += numsOfLikeDoll[i];
                accumOfSum[i] += accumOfSum[i-1];
                accumOfSquareSum[i] = Math.pow(numsOfLikeDoll[i],2);
                accumOfSquareSum[i] += accumOfSquareSum[i-1];
            }
        }
        double result = Double.MAX_VALUE;
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(i > j) continue;
                if(j - i + 1 < k) continue;
                double variance = getMean(accumOfSquareSum,i,j,j - i + 1) - Math.pow(getMean(accumOfSum,i,j, j - i + 1),2);
                result = Math.min(result, Math.sqrt(variance));
            }
        }
        System.out.println(String.format("%.11f",result));
    }

    private static double getMean(double[] sum,int a, int b, int size) {
        if(a == 0){
            return sum[b] / (double) size;
        }else {
            return (sum[b] - sum[a-1]) / (double) size;
        }
    }
}