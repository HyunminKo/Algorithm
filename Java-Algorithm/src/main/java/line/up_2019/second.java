package line.up_2019;

import java.util.ArrayList;
import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chemicalForm = sc.nextLine();
        ArrayList<String> element = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        char prev = chemicalForm.charAt(0);
        int result = 0;
        for(int i = 0 ; i < chemicalForm.length(); i++){
            char c = chemicalForm.charAt(i);
            if(i == 0 && (Character.isLowerCase(c) || Character.isDigit(c))) {
                result = -1;
                break;
            }
            if(element.size() == 0 && Character.isDigit(c)){
                result = -1;
                break;
            }
            if(Character.isUpperCase(c)){
                element.add(Character.toString(c));
            }else {
                if(!Character.isDigit(c)){
                    String letter = element.get(element.size()-1);
                    element.remove(letter);
                    element.add(letter+c);
                }else {
                    numbers.add((int)c - 48);
                }
            }
            prev = c;
        }
        String resultStr = "";
        for(int i = 0 ; i < element.size(); i++){
            if(element.size() != numbers.size()){
                result = -1;
                break;
            }
            String s = element.get(i);
            int n = numbers.get(i);
            resultStr += s;
            if(n != 1){
                resultStr += n;
            }
        }
        resultStr += '\n';
        if(result == -1){
            System.out.println("error");
        }else {
            System.out.println(resultStr);
        }
    }
}
