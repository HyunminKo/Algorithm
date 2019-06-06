package study;

public class dfs_bitmask {
    //5개 중에 3개 뽑는 경우의 수 나열
    public static void main(String[] args) {
        long size = 3;
        long one = 1;
        System.out.println(((long)1 << size) - (long)1);
        for(long i = 0 ; i <= ( one <<size) - one; i++){
            if(Long.bitCount(i) == 3){
                System.out.println(Long.toBinaryString(i));
            }
        }

    }
}
