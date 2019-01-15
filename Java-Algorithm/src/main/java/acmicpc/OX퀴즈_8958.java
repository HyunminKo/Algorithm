package acmicpc;

import java.util.Scanner;

public class OX퀴즈_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i < n; i++){
            String line = sc.nextLine();
            int result = 0;
            int temp = 0;
            for(int j = 0 ; j < line.length(); j++){
                if(line.charAt(j) == 'O'){
                    temp += 1;
                    result += temp;
                }else {
                    temp = 0;
                }
            }
            System.out.println(result);
        }
    }
}