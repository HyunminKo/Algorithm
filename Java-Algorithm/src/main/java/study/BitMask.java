package study;

public class BitMask {
    public static void main(String[] args) {
        int[] intArray = new int[]{1,2,3};
        int sizeOfSet = 3;
        int bit = (1 << sizeOfSet) - 1;

        for(int subset = bit; subset != 0; subset = ((subset-1) & bit)){
            String t1 = "";
            String t2 = "";
            for (int i = sizeOfSet - 1 ; i >= 0; i--){
                    if ((subset & ( 1 << i )) != 0){
                        t1 += '1';
                        t2 += intArray[i];
                    }else{
                        t1 += '0';
                    }
            }
            System.out.println(t1);
            System.out.println(t2);
        }
    }
}
