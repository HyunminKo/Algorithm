package programmers;

public class 길찾기게임 {
    static int[][] map;
    static boolean[][] check;
    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        solution(nodeinfo);
    }
    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        int[] info = findInfo(nodeinfo);
        map = new int[info[4]+1][info[4]+1]; //최대 크기
        check = new boolean[info[4]+1][info[4]+1];
        buildingMap(map,nodeinfo);
        BST bst = new BST();
        MakeTree(map,bst,info[2],info);
        return answer;
    }

    private static void buildingMap(int[][] map, int[][] nodeinfo) {
        for(int i = 0 ; i <nodeinfo.length; i++){
            int pos[] = nodeinfo[i];
            map[pos[1]][pos[0]] = i+1;
        }
    }

    private static void MakeTree(int[][] map, BST bst, int index, int[] info) {
        bst.tree = new Node(index,null,null);
        findLeftChildren(bst.tree,info[3],info[1],info[4],info[0]-1);
        findRightChildren(bst.tree,info[3],info[1],info[4],info[0]-1);
        System.out.println();
    }

    private static boolean findRightChildren(Node node, int left, int pivot, int right, int level) {
        if(level < 0) return false;
        for(int i = pivot+1; i <= right; i++){
            if(map[level][i] != 0 && !check[level][i]){
                check[level][i] = true;
                node.rightChild = new Node(map[level][i],null,null);
                findRightChildren(node.rightChild,left,i,right,level-1);
                findLeftChildren(node,left,i,right,level-1);
                return true;
            }
        }
        if(findRightChildren(node,left,pivot,right,level-1)){
            findLeftChildren(node,left,pivot,right,level-1);
            return true;
        }else {
            return false;
        }
    }

    private static boolean findLeftChildren(Node node, int left, int pivot, int right, int level) {
        if(level < 0) return false;
        for(int i = left; i < pivot; i++){
            if(map[level][i] != 0 && ! check[level][i]){
                check[level][i] = true;
                node.leftChild = new Node(map[level][i],null,null);
                findLeftChildren(node.leftChild,left,i,right,level-1);
                findRightChildren(node,left,i,right,level-1);
                return true;
            }
        }
        if(findLeftChildren(node,left,pivot,right,level-1)){
            findRightChildren(node,left,pivot,right,level-1);
            return true;
        }else {
            return false;
        }

    }

    private static int[] findInfo(int[][] nodeinfo) {
        int x=0,y=0,index=0;
        int left = 100000;
        int right = 0;
        for(int i = 0 ; i < nodeinfo.length; i++){
            int[] pos = nodeinfo[i];
            if(pos[1]>x){ // find root node
                x = pos[1];
                y = pos[0];
                index = i+1;
            }
            if(pos[0] > right){
                right = pos[0];
            }
            if(pos[0] < left){
                left = pos[0];
            }
        }
        return new int[]{x,y,index,left,right};
    }

    private static class BST {
        Node tree;
        public int[] preOrder() {
            return new int[]{};
        }
        public int[] postOrder() {
            return new int[]{};
        }
    }
    private static class Node{
        int root;
        Node leftChild;
        Node rightChild;

        public Node(int root, Node leftChild, Node rightChild) {
            this.root = root;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}
