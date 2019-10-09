package chap10;

import java.util.Scanner;

public class section_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = null;
        if(containsAlphabet(str)){ //알파벳 포함된 경우: 16진수
            res = convertHextoDec(str);
        }else { //10진수
            res = convertDectoHex(str);
        }
        System.out.println(res);
    }

    private static String convertDectoHex(String str) {
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(str);
        int q = num;
        while(q > 0){
            int r = q % 16;
            q = q / 16;
            if(r == 15){
                sb.append("F");
            }else if(r == 14){
                sb.append("E");
            }else if(r == 13){
                sb.append("D");
            }else if(r == 12){
                sb.append("C");
            }else if(r == 11){
                sb.append("B");
            }else if(r == 10){
                sb.append("A");
            }else {
                sb.append(r);
            }
        }
        sb.reverse();
        return sb.toString();
    }

    private static String convertHextoDec(String str) {
        int sum = 0;
        for(int i  = 0 ; i < str.length(); i++){
            int size = str.length() - i - 1;
            char c = str.charAt(i);
            if(containsAlphabet(String.valueOf(c))){
                if(c =='A'){
                    sum += 10*(int)Math.pow(16,size);
                }else if(c=='B'){
                    sum += 11*(int)Math.pow(16,size);
                }else if(c=='C'){
                    sum += 12*(int)Math.pow(16,size);
                }else if(c=='D'){
                    sum += 13*(int)Math.pow(16,size);
                }else if(c=='E'){
                    sum += 14*(int)Math.pow(16,size);
                }else if(c=='F'){
                    sum += 15*(int)Math.pow(16,size);
                }
            }else {
                sum += Integer.parseInt(String.valueOf(c))*((int)Math.pow(16,size));
            }
        }
        return String.valueOf(sum);
    }

    private static boolean containsAlphabet(String str) {
        str = str.toUpperCase();
        if(str.contains("A") || str.contains("B") || str.contains("C") || str.contains("D") || str.contains("E") || str.contains("F"))
            return true;
        return false;
    }
}
