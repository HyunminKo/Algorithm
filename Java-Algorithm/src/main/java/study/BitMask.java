package study;

public class BitMask {
    public static void main(String[] args) {
        int[] intArray = new int[]{1,2,3};// 이거보이지
        int sizeOfSet = 3;
        int bit = 7;

        for(int subset = bit; subset != 0; subset -= 1){
            String temp = "";
            String temp2 = "";
            for(int i = 2 ; i >= 0; i--){
                if((subset & (1 << i)) != 0){
                    temp2 += intArray[i];
                    temp +="1";
                }else {
                    temp +="0";
                }
            }
//            System.out.println(temp);
            System.out.println(temp2);
        }
    }
}
