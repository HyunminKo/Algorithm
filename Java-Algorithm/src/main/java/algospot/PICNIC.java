package algospot;

import java.util.Scanner;

public class PICNIC {
    static boolean[][] areFriends = new boolean[10][10];

    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
            n = sc.nextInt(); int m = sc.nextInt();
            boolean[] taken = new boolean[10];
            while(m-- > 0){
                int v1 = sc.nextInt(); int v2 = sc.nextInt();
                if(v1 > v2){
                    int temp = v1;
                    v1 = v2;
                    v2 = temp;
                }
                areFriends[v1][v2] = true;
            }
            int result = countPairings(taken);
            System.out.println(result);
            areFriends = new boolean[10][10];
        }
    }

    private static int countPairings(boolean[] taken) {
        int firstFree = -1;
        for(int i = 0 ; i < n; i++){
            if(!taken[i]){
                firstFree = i;
                break;
            }
        }
        if(firstFree == -1) return 1;
        int result = 0;

        for(int pairWith = firstFree + 1; pairWith < n; pairWith++){
            if(!taken[pairWith] && !taken[firstFree] && areFriends[firstFree][pairWith]){
                taken[firstFree] = taken[pairWith] = true;
                result += countPairings(taken);
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        return result;
    }
}
