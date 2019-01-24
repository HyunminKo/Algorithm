import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int count = 0;
        int quoient = a / b;
        sb.append(quoient);
        if(a % b != 0) sb.append(".");
        int remainder = a % b;
        while(remainder != 0){
            if(count > 1999){
                break;
            }
            remainder *= 10;
            sb.append(remainder/b);
            remainder %= b;
            count++;
        }
        System.out.println(sb.toString());
    }
}
