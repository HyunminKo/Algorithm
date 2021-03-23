package main.java.swexpert;

import java.util.Scanner;

public class 계산기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < 10 ; i++){
            sc.nextInt(); sc.nextLine();
            String line = sc.nextLine();
            int sum = 0;
            for(int j = 0 ; j < line.length(); j++){
                char num = line.charAt(j);
                if(Character.isDigit(num)){
                    if(j == line.length()-1){
                        sum += Integer.parseInt(String.valueOf(num));
                        break;
                    }
                    char nextOper = line.charAt(++j);
                    if(nextOper == '+'){
                        sum += Integer.parseInt(String.valueOf(num));
                    }else if(nextOper == '*'){
                        int tempSum = Integer.parseInt(String.valueOf(num));
                        int index = j+1;
                        for(; index < line.length() && nextOper == '*'; index++){
                            tempSum *= Integer.parseInt(String.valueOf(line.charAt(index++)));
                            if(index >= line.length()) break;
                            nextOper = line.charAt(index);
                        }
                        sum += tempSum;
                        j = index - 1;
                    }
                }
            }
            System.out.println(String.format("#%d %d",i+1,sum));
        }
    }
}
