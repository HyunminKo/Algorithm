package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 실패율 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] test = solution(N,stages);
        for(int item : test){
            System.out.println(item);
        }
    }
    public static int[] solution(int N, int[] stages) {
        int[] numOfUserOnStage = new int[N];
        int[] numOfUserPassStage = new int[N];
        for(int i = 0 ; i < stages.length; i++){
            for(int j = 0 ; j <= stages[i]-1 ; j++){
                if(j == N) break;
                numOfUserPassStage[j]++;
            }
            if(stages[i] == N + 1) continue;
            numOfUserOnStage[stages[i]-1]++;
        }
        ArrayList<InfoStages> infoStages = new ArrayList<>();
        for(int i = 0 ; i < numOfUserOnStage.length; i++){
            if(numOfUserPassStage[i] == 0) {
                infoStages.add(new InfoStages(i+1,0));
            }else {
                infoStages.add(new InfoStages(i+1,(double)numOfUserOnStage[i]/(double)numOfUserPassStage[i]));
            }
        }
        Collections.sort(infoStages);
        int[] answer = new int[infoStages.size()];
        for(int i = 0 ; i < infoStages.size(); i++){
            answer[i] = infoStages.get(i).index;
        }
        return answer;
    }
    private static class InfoStages implements Comparable<InfoStages>{
        int index;
        double failRate;

        public InfoStages(int index, double failRate) {
            this.index = index;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(InfoStages o) {
            if(this.failRate == o.failRate){
                return this.index - o.index;
            }else {
                if(this.failRate > o.failRate){
                    return -1;
                }else{
                    return 1;
                }
            }
        }
    }
}
