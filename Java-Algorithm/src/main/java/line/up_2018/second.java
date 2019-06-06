package line.up_2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userX = sc.nextInt();
        int userY = sc.nextInt();
        int T = sc.nextInt();
        List<Shop> shopList = new ArrayList<>();
        for(int i = 0 ; i < T; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            String name = sc.next();
            int coupon = sc.nextInt();
            shopList.add(new Shop(x,y,coupon,calDistance(userX,userY,x,y),name));
        }
        Collections.sort(shopList);
        for(Shop shop : shopList){
            System.out.println(shop);
        }
        System.out.println("9".compareTo("L"));
    }

    private static int calDistance(int userX, int userY, int x, int y) {
        int distance = 0;
        distance = Math.abs(userX - x) + Math.abs(userY-y);
        distance /= 100;
        distance *= 100;
        return distance;
    }

    private static class Shop implements Comparable<Shop>{
        int x,y,coupon,distance;
        String name;

        public Shop(int x, int y, int coupon, int distance, String name) {
            this.x = x;
            this.y = y;
            this.coupon = coupon;
            this.distance = distance;
            this.name = name;
        }

        @Override
        public int compareTo(Shop o) {
            if(this.distance == o.distance){
                if(this.coupon == o.coupon){
                    return this.name.compareTo(o.name);
                }else {
                    return o.coupon - this.coupon;
                }
            }else {
                return this.distance - o.distance;
            }
        }

        @Override
        public String toString() {
            return String.format("%d %d %s %d",x,y,name,coupon);
        }
    }
}

