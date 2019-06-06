package line.up_2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class third {
    static int leftN, rightN;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        leftN = sc.nextInt();
        sc.nextLine();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<ZipCode> zipCodes = new ArrayList<>();
        String[] tableOneHeader = {};
        String[] tableTwoHeader= {};
        for(int i = 0 ; i < leftN; i++){
            if(i == 0){
                tableOneHeader = sc.nextLine().split(" ");
            }else {
                String[] line = sc.nextLine().split(" ");
                if(line.length == 2){
                    customers.add(new Customer(Integer.parseInt(line[0]),line[1],2));
                }else {
                    customers.add(new Customer(Integer.parseInt(line[0]),line[1],line[2],3));
                }
            }
        }
        rightN = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i < rightN ; i++){
            if(i == 0){
                tableTwoHeader = sc.nextLine().split(" ");
            }else {
                String[] line = sc.nextLine().split(" ");
                if(line.length == 2){
                    zipCodes.add(new ZipCode(Integer.parseInt(line[0]),line[1],2));
                }else {
                    zipCodes.add(new ZipCode(Integer.parseInt(line[0]),line[1],line[2],3));
                }
            }
        }
        Collections.sort(customers);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < tableOneHeader.length; i++){
            sb.append(tableOneHeader[i] + " ");
        }
        for(int i = 0 ; i < tableTwoHeader.length; i++){
            if(i == 0) continue;
            if(i == tableTwoHeader.length - 1){
                sb.append(tableTwoHeader[i] + "\n");
            }else {
                sb.append(tableTwoHeader[i] + " ");
            }
        }
        for(Customer customer : customers){
            int id = customer.id;
            int zipIndex = -1;
            for(int i = 0 ; i < zipCodes.size() ; i++){
                if(zipCodes.get(i).id == id){
                    zipIndex = i;
                    break;
                }
            }
            if(customer.numOfHeader == 2){
                sb.append(customer.id + " " + customer.H1 + " ");
            }else {
                sb.append(customer.id + " " + customer.H1 + " " + customer.H2 + " ");
            }
            if(zipIndex != -1){
                ZipCode zipCode = zipCodes.get(zipIndex);
                if(zipCode.numOfHeader == 2){
                    sb.append(zipCode.H1 + "\n");
                }else {
                    sb.append(zipCode.H1 + " " + zipCode.H2 + "\n");
                }
            }else {
                if(zipCodes.get(0).numOfHeader == 2){
                    sb.append("NULL\n");
                }else {
                    sb.append("NULL NULL\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
    private static class Customer implements Comparable<Customer>{
        int id;
        String H1;
        String H2;
        int numOfHeader;

        public Customer(int id, String h1, int numOfHeader) {
            this.id = id;
            H1 = h1;
            this.numOfHeader = numOfHeader;
        }

        public Customer(int id, String h1, String h2, int numOfHeader) {
            this.id = id;
            H1 = h1;
            H2 = h2;
            this.numOfHeader = numOfHeader;
        }

        @Override
        public int compareTo(Customer o) {
            return this.id - o.id;
        }
    }
    private static class ZipCode {
        int id;
        String H1;
        String H2;
        int numOfHeader;

        public ZipCode(int id, String h1, int numOfHeader) {
            this.id = id;
            H1 = h1;
            this.numOfHeader = numOfHeader;
        }

        public ZipCode(int id, String h1, String h2, int numOfHeader) {
            this.id = id;
            H1 = h1;
            H2 = h2;
            this.numOfHeader = numOfHeader;
        }
    }
}
