package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] test = solution(record);
        for(String line : test){
            System.out.println(line);
        }
    }
    public static String[] solution(String[] record) {
        ArrayList<InstructionChat> ic = new ArrayList<>();
        HashMap<String,String> newNickNameMap = new HashMap<>();
        int commandSize = 0;
        for(String line : record){
            String[] lines = line.split(" ");
            if(lines[0].equals("Enter")){
                newNickNameMap.put(lines[1],lines[2]);
            }
            if(lines[0].equals("Change")){
                newNickNameMap.put(lines[1],lines[2]);
            }else {
                commandSize++;
            }
            if(lines.length == 3){
                ic.add(new InstructionChat(lines[0],lines[1],lines[2]));
            }else {
                ic.add(new InstructionChat(lines[0],lines[1]));
            }
        }
        String[] answer= new String[commandSize];
        int index = 0;
        for(InstructionChat item : ic){
            if(item.command.equals("Enter")){
                answer[index++] = String.format("%s님이 들어왔습니다.",newNickNameMap.get(item.uid));
            }else if(item.command.equals("Leave")){
                answer[index++] = String.format("%s님이 나갔습니다.",newNickNameMap.get(item.uid));
            }
        }
        return answer;
    }
    private static class InstructionChat{
        String command;
        String uid;
        String nickName;

        public InstructionChat(String command, String uid, String nickName) {
            this.command = command;
            this.uid = uid;
            this.nickName = nickName;
        }

        public InstructionChat(String command, String uid) {
            this.command = command;
            this.uid = uid;
        }
    }
}
