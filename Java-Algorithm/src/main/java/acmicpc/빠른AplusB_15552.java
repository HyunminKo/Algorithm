package acmicpc;

import java.io.*;
import java.util.StringTokenizer;

public class 빠른AplusB_15552 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int result = 0;
                while(st.hasMoreTokens()){
                    result += Integer.parseInt(st.nextToken());
                }
                bw.write(result+"\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
