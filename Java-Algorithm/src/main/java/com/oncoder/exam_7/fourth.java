package com.oncoder.exam_7;

import java.util.Arrays;

public class fourth {
    private static int count = 0;
    public static void solution(int[] arr, int p){
        DFS(arr, 0,p);
    }

    private static void DFS(int[] arr, int index,int p){
        if(index >= 1){
            for(int i = 0; i < index-1; i++){
                int temp = arr[i] - arr[i+1];
                if(temp % p == 0){
                    System.out.println("return. index: "+index+" "+Arrays.toString(arr));
                    return;
                }
            }
            if(index >= arr.length-1){
                for(int i = 0; i < arr.length-1; i++){
                    int temp = arr[i] - arr[i+1];
                    if(temp % p == 0){
                        System.out.println("return. index: "+i+" "+Arrays.toString(arr));
                        return;
                    }
                }
                System.out.println("success. "+Arrays.toString(arr));
                count++;
                return;
            }
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
//        int[] numbers = new int[] {0,-5,1,2,3,4,5,6,7,8,9,10,12,213,123,122,21,2136,4534,2312,12312,34543,2765,56756,462346,46434,4235,2353,352342,23433};
//        int[] numbers = new int[] {-1,0,1,2,3};
        int[] numbers = new int[] {1,2,3,4};
//        int[] numbers = new int[] {4,6,8,-3,7};
//        int[] numbers = new int[] {-252280,-368452,-303262,-374344,441497,-359356,-210649,-267136,-213643,740639,653444,951005,329633,929117,69836,903329,685898,219437,-612394,-20521,-67453,940187,-93178,-90208,-280285,282425,-659722,479129,-509179};
//        int[] numbers = new int[] {807395,227594,972638,777467,-103510,-71395,247016,250862,214823,-410032,357815};
        int p = 6;
        long startTime = System.nanoTime();
        solution(numbers,p);
        long stopTime = System.nanoTime();
        System.out.println("Time:");
        System.out.println(stopTime - startTime);
        System.out.println("Result:");
        System.out.println(count%1234567891);
        System.out.println(numbers.length);
    }
}