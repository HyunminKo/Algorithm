package acmicpc;

import java.util.Scanner;

public class 음계_2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int[] numbers = new int[8];
        boolean isPass = true;
        for(int i = 0 ; i < line.length; i++){
            numbers[i] = Integer.parseInt(line[i]);
        }
        for(int i = 0 ; i < line.length - 1; i++){
            if(numbers[i+1] - numbers[i] != 1){
                isPass = false;
                break;
            }
        }
        if(isPass){
            System.out.println("ascending");
            return;
        }else {
            isPass = true;
        }
        for(int i = 0 ; i < line.length - 1; i++){
            if(numbers[i+1] - numbers[i] != -1){
                isPass = false;
                break;
            }
        }
        if(isPass){
            System.out.println("descending");
            return;
        }else {
            System.out.println("mixed");
        }
    }
}
