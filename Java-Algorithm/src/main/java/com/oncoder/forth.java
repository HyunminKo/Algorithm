package com.oncoder;

public class forth {
    private static int count = 0;
    public static void solution(int[] arr, int p){
        DFS(arr, 0,p);
    }

    private static void DFS(int[] arr, int index,int p){
        if(index >= arr.length - 1){
            for(int i = 0; i < arr.length-1; i++){
                int temp = arr[i] - arr[i+1];
                if(temp % p == 0){
                    return;
                }
            }
            count++;
            return;
        }

        for(int i = index; i < arr.length; i++){
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            DFS(arr, index+1, p);

            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
//        int[] numbers = new int[] {-1,0,1,2,3,-1,0,1,2,3,-1,0,1,2,3,-1,0,1,2,3,-1,0,1,2,3,-1,0,1,2,3};
        int[] numbers = new int[] {-1,0,1,2,3};
        int p = 10;
        solution(numbers,10);
        System.out.println(count);
    }
}