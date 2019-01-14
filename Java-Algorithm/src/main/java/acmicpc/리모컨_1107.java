package acmicpc;

import java.lang.reflect.Array;
import java.util.*;

public class 리모컨_1107 {
    static int[] memo = new int[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int channel = sc.nextInt();
        int M = sc.nextInt();
        Arrays.fill(memo,-1);
        Set<Integer> errorButtonSet = new HashSet<>();
        for(int i = 0 ; i < M; i++){
            errorButtonSet.add(sc.nextInt());
        }
        if(channel == 100){
            System.out.println(0);
            return;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        int size = Integer.toString(channel).length();
        int oneOfNum = channel;
        int upAndDown = 0;
        for(int i = size-1; i >= 0; i--){
            int divider = (int) Math.pow(10,i);
            upAndDown = checkButton(oneOfNum/divider,nums,errorButtonSet,upAndDown);
            if(upAndDown == 0x3f3f3f3f) break;
            oneOfNum = oneOfNum % divider;
        }
        String chosenNum = "";
        for(int i =0 ; i < nums.size(); i++){
            chosenNum += Integer.toString(nums.get(i));
        }
        int chosenIntNum = Integer.parseInt(chosenNum);
        int result;
        if(chosenIntNum == 0 && upAndDown != 0x3f3f3f3f){
            result = 1;
        }else {
            result = chosenNum.length();
        }
        if(upAndDown == 0x3f3f3f3f) result = 0x3f3f3f3f;
        result += Math.abs( chosenIntNum - channel );
        if(Math.abs(channel - 100) < result){
            result = Math.abs(channel - 100);
        }
        result = Math.min(result,differentSize(channel,size,errorButtonSet));
        System.out.println(result);
    }

    private static int differentSize(int channel,int size,Set<Integer> errorButtonSet) {
        int num = (int) Math.pow(10,size);
        int result = 0x3f3f3f3f;
        boolean isPossible = false;
        int possibleNum = 0;
        for(int i = 0 ; i < 10; i++){
            if(!errorButtonSet.contains(i)){
                isPossible = true;
                possibleNum = i;
                break;
            }
        }
        if(isPossible){
            result = size + 1;
            String tempStr = "1";
            for(int i = 0 ; i < size; i++){
                tempStr += Integer.toString(possibleNum);
            }
            result += (Integer.parseInt(tempStr) - channel);
        }
        if(size != 1){
            isPossible = false;
            for(int i = 9 ; i >= 0; i--){
                if(!errorButtonSet.contains(i)){
                    isPossible = true;
                    possibleNum = i;
                    break;
                }
            }
            if(isPossible){
                int tempResult = size -1;
                String tempStr = "";
                for(int i = 0 ; i < size -1; i++){
                    tempStr += Integer.toString(possibleNum);
                }
                tempResult += (channel - Integer.parseInt(tempStr));
                result = Math.min(result,tempResult);
            }
        }
        return result;
    }

    private static int checkButton(int num, ArrayList<Integer> nums,Set<Integer> errorButtonSet, int upAndDown)  {
        if(memo[num] != -1){
            nums.add(memo[num]);
            return upAndDown;
        }
        if(errorButtonSet.contains(num)){
            int up = num;
            int down = num;
            int upCount = 0;
            int downCount = 0;
            boolean changedUp = false;
            boolean changedDown = false;
            while(up < 9 && errorButtonSet.contains(up)){
                changedUp = true;
                upCount++;
                up++;
                if(up == 9 && errorButtonSet.contains(up)){
                    upCount = 10;
                }
            }
            while(down > 0 && errorButtonSet.contains(down)){
                changedDown = true;
                downCount++;
                down--;
                if(down == 0 && errorButtonSet.contains(down)){
                    downCount = 10;
                }
            }
            if(changedUp && changedDown){
                if(upAndDown == 0){
                    if(upCount > downCount){
                        memo[num] = down;
                        nums.add(down);
                        return -1;
                    }else {
                        memo[num] = up;
                        nums.add(up);
                        return 1;
                    }
                }else {
                    if(upAndDown > 0){
                        memo[num] = down;
                        nums.add(down);
                        return 1;
                    }else {
                        memo[num] = up;
                        nums.add(up);
                        return -1;
                    }
                }
            }else {
                if(upCount == 10 || downCount == 10){
                    nums.add(num);
                    return 0x3f3f3f3f;
                }
                if(changedUp){
                    memo[num] = up;
                    nums.add(up);
                    return 1;
                }else {
                    memo[num] = down;
                    nums.add(down);
                    return -1;
                }
            }
        }else {
            nums.add(num);
            return 0;
        }
    }
}
