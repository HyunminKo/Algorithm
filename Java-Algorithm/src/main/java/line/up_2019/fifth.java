package line.up_2019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class fifth {
    static int C,B;
    public static void main(String[] args) {
        final int MAX_DISTANCE = 200000;
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        B = sc.nextInt();
        boolean flag = false;
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(B);
        while(true){
            if( C >= MAX_DISTANCE){
                System.out.println(-1);
                break;
            }
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int x = q.poll();
                if( x == C ){
                    System.out.println(time);
                    flag = true;
                    break;
                }
                if( x > 0 ){
                    q.offer(x-1);
                }
                if( x < MAX_DISTANCE ){
                    q.offer(x+1);
                }
                if( x * 2 <= MAX_DISTANCE ){
                    q.offer(x*2);
                }
            }
            if(flag){
                break;
            }
            time++;
            C += time;
        }
    }
}
