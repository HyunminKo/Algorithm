package main.java.programmers;

public class 멀쩡한사각형 {
    public static void main(String[] args) {
        System.out.println(solution(8,12));
    }
    public static long solution(int w,int h) {
        long answer = 0;
        double lean = Double.valueOf(w) / Double.valueOf(h);
        for(int x = 1; x < h; x++){
            double y = lean * x;
            int count = (int) Math.floor(y);
            answer += count;
        }
        return answer*2;
    }
}
