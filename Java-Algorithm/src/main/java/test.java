import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] cntFavorPerson = new int[n];
        double[] sumOfFavor = new double[n];
        double[] sumOfSquareFavor = new double[n];
        int k = input.nextInt();

        for(int i = 0; i < n; i++) {
            cntFavorPerson[i] = input.nextInt();
        }

        double temp = 0;
        double squareTemp = 0;
        for(int i = 0; i< n;i++) {//누적 합
            temp += cntFavorPerson[i];
            sumOfFavor[i] = temp;
            squareTemp += Math.pow(cntFavorPerson[i], 2);
            sumOfSquareFavor[i] = squareTemp;
        }
        double standard_deviation = 0x3f3f3f3f;
        for(int i = k; i< cntFavorPerson.length;i++) {
            for(int j = 0; j< sumOfFavor.length-i+1;j++) {
                double average = 0;
                double sumOfSquare = 0;
                if(i ==1) {
                    average = (sumOfFavor[i-1+j] - sumOfFavor[j])/i;
                    sumOfSquare = sumOfSquareFavor[i-1+j] - sumOfSquareFavor[j];
                }
                else {
                    if(j == 0) {
                        average = (sumOfFavor[i-1+j])/i;
                        sumOfSquare = sumOfSquareFavor[i-1+j];
                    }
                    else {
                        average = (sumOfFavor[i-1+j] - sumOfFavor[j-1])/i;
                        sumOfSquare = sumOfSquareFavor[i-1+j] - sumOfSquareFavor[j-1];
                    }
                }
                double squareOfEverage = Math.pow(average, 2);
                double temp_standard = Math.sqrt((sumOfSquare/i) - squareOfEverage);
                if(temp_standard < standard_deviation) {
                    standard_deviation = temp_standard;
                }
                System.out.println(i + " " + j);
            }
        }
        System.out.println(String.format("%.11f",standard_deviation));
    }
}