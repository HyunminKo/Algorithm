package line.up_2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class fourth {
    static int buildingN;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        buildingN = sc.nextInt();
        ArrayList<Integer> buildings = new ArrayList<>();
        for(int i = 0 ; i < buildingN; i++){
            buildings.add(sc.nextInt());
        }
        int select = 0;
        int distance = 0;
        for(int i = 0 ; i < buildings.size() ; i++){
            if(i == 0) continue;
            if(buildings.get(select) > buildings.get(i)) continue;
            distance = Math.max(distance,Math.abs(select - i));
            if(buildings.get(select) <= buildings.get(i)) select = i;
        }
        Collections.reverse(buildings);
        for(int i = 0 ; i < buildings.size() ; i++){
            if(i == 0) continue;
            if(buildings.get(select) > buildings.get(i)) continue;
            distance = Math.max(distance,Math.abs(select - i));
            if(buildings.get(select) <= buildings.get(i)) select = i;
        }
        System.out.println(distance);
    }
}

