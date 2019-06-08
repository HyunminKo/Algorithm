package nts;

public class five {
    public static void main(String[] args) {
        int[][] interval = {{1,3},{1,4},{4,5}};
        System.out.println(solution("abcde",interval));
    }
    public static String solution(String S, int[][] interval) {
        char[] temp = new char[S.length()];
        for(int i = 0 ; i < S.length(); i++){
            temp[i] = S.charAt(i);
        }
        for(int i = 0 ; i <interval.length; i++){
            int a = interval[i][0]-1;
            int b = interval[i][1]-1;
            reverseStr(temp,a,b);
        }
        return String.valueOf(temp);
    }

    private static void reverseStr(char[] temp, int a, int b) {
        int size = (b - a + 1) / 2;
        for(int i = 0; i < size; i++){
            char t = temp[a+i];
            temp[a+i] = temp[b-i];
            temp[b-i] = t;
        }
    }
}
