package study;

public class gcd {
    public static void main(String[] args) {
        System.out.println(gcd(15,45));
        System.out.println(gcd(15,46));
    }
    static int gcd(int a , int b){
        return (b % a != 0) ? gcd(b, a%b): a;
    }
}
