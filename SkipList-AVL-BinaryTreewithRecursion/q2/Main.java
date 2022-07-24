import java.util.Scanner;
import java.io.*;
public class Main{

    public static void main(String[] args){
        BinarySearchTree<Integer> t1= new BinarySearchTree<Integer>();
       /*t1.add(1);
       t1.add(2);
       t1.add(3);
       t1.add(4);
       t1.add(5);
       t1.add(6);
       t1.add(7);*/
        t1.add(4);
        t1.add(1);
        t1.add(2);
        t1.add(3);
        t1.add(5);
        t1.add(6);
        t1.add(15);
        t1.add(16);
        t1.add(10);
        t1.add(9);
        t1.add(12);
        t1.add(7);
        System.out.println(t1.toString());
        t1.convert_avl();
        System.out.println(t1.toString());
    }


}