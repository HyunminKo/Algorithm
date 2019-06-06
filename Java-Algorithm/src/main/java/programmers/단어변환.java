package programmers;

public class 단어변환 {
    static int minValue = 0x3f3f3f3f;
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String[] words = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin,target,words));
    }
    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin,target,words,0,visited);
        if(minValue == 0x3f3f3f3f){
            return 0;
        }else {
            return minValue;
        }
    }

    private static void dfs(String begin, String target, String[] words, int count, boolean[] visited) {
        if(begin.equals(target)){
            minValue = Math.min(minValue , count);
            return;
        }
        if(count > words.length){
            return;
        }
        for(int i = 0 ; i < words.length ; i++){
            if(begin.equals(words[i])) continue;
            if(canSwitch(begin,words[i]) && !visited[i]){
                visited[i] = true;
                dfs(words[i],target,words,count+1, visited);
                visited[i] = false;
            }
        }
        return ;
    }

    private static boolean canSwitch(String begin, String word) {
        int count = 0;
        for(int i = 0 ; i < begin.length(); i++){
            if(begin.charAt(i) != word.charAt(i)) count++;
        }
        if(count == 1){
            return true;
        }else {
            return false;
        }
    }
}
