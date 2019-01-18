package kakao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 숏코딩_15956 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        ExperSet experSet = new ExperSet();
        String[] condExpers = expr.split("&&");
        for(String cexper :condExpers){
            if(cexper.contains("==")){
                experSet.add(cexper,"==");
            }else {
                experSet.add(cexper,"!=");
            }
        }
        System.out.println(experSet.makeEqualCode());
        return;
    }
    private static class ExperSet {
        private ArrayList<String> expers = new ArrayList<>();
        private ArrayList<EqualGroup> equalSubset = new ArrayList<>();
        private ArrayList<NotEqualGroup> notEqualSubset = new ArrayList<>();
        boolean isAllTrue = false;
        boolean isOneFalse = false;
        public void add(String str, String delimeter){
            expers.add(str);
            String[] operand = str.split(delimeter);
            if(delimeter.equals("==")){
                boolean temp = false;
                for(int i = 0 ; i < equalSubset.size(); i++){
                    EqualGroup group = equalSubset.get(i);
                    if(group.contains(operand[0]) || group.contains(operand[1])){
                        temp = true;
                        if(!group.add(operand[0])){
                            isOneFalse = true;
                        }
                        if(!group.add(operand[1])){
                            isOneFalse = true;
                        }
                    }
                }
                if(!temp){
                    EqualGroup group = new EqualGroup();
                    group.add(operand[0]);
                    group.add(operand[1]);
                    equalSubset.add(group);
                }
            }else {
                notEqualSubset.add(new NotEqualGroup(operand[0],operand[1]));
            }
        }

        public String makeEqualCode() {
            StringBuilder sb = new StringBuilder();
            Set<String> result = new HashSet<>();
            for(int i = 0 ; i < expers.size(); i++){
                String exper = expers.get(i);
                if(exper.contains("==")){
                    if(result.contains(exper)) continue;
                    String[] operand = exper.split("==");

                } else {

                }
            }
            return null;
        }
    }
    private static class EqualGroup {
        int number = -1;
        String shortStr = null;
        Set<String> variables = new HashSet<>();

        public boolean add(String var){
            if(Character.isDigit(var.charAt(0))){
                if(number == -1){
                    number = Integer.parseInt(var);
                    return true;
                }else {
                    return false;
                }
            }
            if(shortStr == null){
                shortStr = var;
            }else {
                if(shortStr.length() > var.length()){
                    shortStr = var;
                }
            }
            variables.add(var);
            return true;
        }
        public boolean contains(String var){
            if(variables.contains(var)) return true;
            return false;
        }
    }
    private static class NotEqualGroup {
        private String first = null;
        private String second = null;

        public NotEqualGroup(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public String getFirst() {
            return first;
        }

        public String getSecond() {
            return second;
        }
    }
}
