package test;

import java.io.*;
import java.sql.*;
class Node<T> {
    T data = null;
    Node<T> next = null;

    Node(T t, Node<T> n) {
        data = t;
        next = n;
    }
}
class LinkedList<U> {
    private Node<U> head = null;
    private Node<U> tail = null;
    private int size = 0;
    public LinkedList(){
        head = new Node<U>(null,null);
        tail = head;
    }
    public void add(U d){
        tail.next = new Node<U>(d,null);
        tail = tail.next;
        size++;
    }
    public void print() {
        for(Node<U> n = head.next; n != null; n = n.next){
            System.out.println(n.data);
        }
    }
    public void save(String fileName) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeInt(this.getSize());
        for(Node<U> n = head.next; n!=null; n=n.next){
            DataUtil.populate(n.data, out);
        }
        out.close();
    }
     public void load(String fileName) throws Exception {
         ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
         int size = in.readInt();
         for(int i = 0 ; i < size; i++){
             this.add((U) new Score(in.readUTF(),in.readInt()));
         }
     }
    public int getSize() { return this.size; }
}
class DataUtil {
    public static void populate(Object ob, ObjectOutputStream out) throws Exception {
        if(ob instanceof Score){
            Score sc = (Score) ob;
            out.writeUTF(sc.getId());
            out.writeInt(sc.getScore());
        }
    }
}
class Score {
    private String id = null;
    private int score = 0;
    public Score(String i, int s){
        id = i;
        score = s;
    }

    public String getId() { return id; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return "Score{" +
                "id='" + id + '\'' +
                ", score=" + score +
                '}';
    }
}
public class Test091{
    public static void main(String[] args) throws Exception{
//        LinkedList<Score> ls = new LinkedList<>();
//        ls.add( new Score("10101",100));
//        ls.add( new Score("10102",90));
//        ls.add( new Score("10103",80));
//        ls.add( new Score("10104",70));
//        ls.save("file.txt");
//        ls.print();

        LinkedList<Score> ls2 = new LinkedList<>();
        ls2.load("file.txt");
        ls2.print();
        "file".indexOf("fi");

        System.out.println((Math.random()*10)%3);
    }
}