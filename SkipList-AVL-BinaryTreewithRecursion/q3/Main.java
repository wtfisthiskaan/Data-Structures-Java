import java.util.Scanner;
import java.io.*;
public class Main{
      public static void main(String[] args) {
          CustomSkipList<Integer> sl = new CustomSkipList<>(4);
    int[] data = {4,2,7,0,9,1,16,5,3};
    for (int i : data) {
      sl.insert(i);
    }

    sl.print();
    sl.insert(25);
    sl.print();
  }


}