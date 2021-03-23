package main.java.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 종이접기 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }
    public static int[] solution(int n) {
        Node root = new Node(null,null,0);
        Queue<Node> leafNodes = new LinkedList<>();
        leafNodes.add(root);
        while(n-- > 1){
            int size = leafNodes.size();
            while(size-- > 0) {
                Node t = leafNodes.poll();
                t.left = new Node(null, null, 0);
                t.right = new Node(null, null, 1);
                leafNodes.add(t.left);
                leafNodes.add(t.right);
            }
        }
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root,sb);

        String[] result = sb.toString().split(" ");
        int[] answer = new int[result.length];
        for(int i = 0 ; i < result.length; i++){
            answer[i] = Integer.parseInt(result[i]);
        }
        return answer;
    }

    private static void inOrderTraversal(Node node,StringBuilder sb) {
        if(node.left != null) inOrderTraversal(node.left,sb);
        sb.append(node.value+" ");
        if(node.right != null) inOrderTraversal(node.right,sb);
    }

    public static class Node {
        Node left;
        Node right;
        int value;

        public Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}
