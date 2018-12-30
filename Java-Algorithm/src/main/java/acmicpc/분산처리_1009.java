package acmicpc;

import java.io.*;
import java.util.ArrayList;

public class 분산처리_1009 {
    public static void findComNum(int a, int b,BufferedWriter bw) throws IOException {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(a);
        int temp = a,i = 1;
        for(i = 1; al.get(0) != (temp * a) % 10 && i < b; i++){
            temp = (temp * a) % 10;
            al.add(temp);
        }
        int index = b % i;
        if(index == 0){
            bw.write(al.get(i-1)+"\n");
        }else {
            bw.write(al.get(index-1)+"\n");
        }
    }
    public static void main(String [] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 0;
        try {
            n = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < n; i++){
                String[] line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                if (a % 10 == 0){
                    bw.write(10+"\n");
                }else {
                    findComNum(a,b,bw);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(n);
    }
}
