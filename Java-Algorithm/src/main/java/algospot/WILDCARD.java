package algospot;

import java.util.Scanner;

public class WILDCARD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i < n; i++){
            String pattern = sc.nextLine();
            int m = sc.nextInt();
            sc.nextLine();
            for(int j = 0 ; j < m; j++){
                String str = sc.nextLine();
                if(patternMatch(pattern,str)){
                    System.out.println(str);
                }
            }
        }

    }

    private static boolean patternMatch(String p, String s) {
        int pos = 0;
        while( pos < p.length() && pos < s.length() && (p.charAt(pos) == '?'||p.charAt(pos) == s.charAt(pos))){
            pos++;
        }
        if(pos == p.length())
            return pos == s.length();
        if(p.charAt(pos) == '*'){
            for(int skip = 0; pos+skip <= s.length(); skip++){
                if(patternMatch(p.substring(pos+1),s.substring(pos+skip))){
                    return true;
                }
            }
        }
        return false;
    }
}
