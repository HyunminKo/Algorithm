package line.up_2018;

import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < T ; i++){
            String line = sc.nextLine();
            char temp = 0;
            int count = 0;
            for(int j = 0 ; j < line.length(); j++){
                if(j == 0){
                    temp = line.charAt(0);
                    count++;
                }else {
                    if(temp == line.charAt(j)){
                        count++;
                    }else {
                        System.out.print(count);
                        System.out.print(temp);
                        temp = line.charAt(j);
                        count = 1;
                    }
                }
            }
            System.out.print(count);
            System.out.println(temp);

        }
    }

}
