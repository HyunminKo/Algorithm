package leetcode;

public class removeOuterParentheses_1021 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("()()"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
    public static String removeOuterParentheses(String S) {
        int count = -1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < S.length(); i++){
            char c = S.charAt(i);
            if(c=='(' && count == -1){
                count++;
                continue;
            }else {
                if(c=='('){
                    count++;
                    sb.append(c);
                }else if(c==')'){
                    if(count==0){
                        count--;
                        continue;
                    }
                    count--;
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
