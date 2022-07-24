import java.util.Random;
import java.util.*;

public class Main{
	public static void main(String args[]){
		HashTableChainingBST<Integer,Integer> map=new HashTableChainingBST<Integer,Integer>(100);
		int i,j;
		int int_random=0;
		long startTime1 = System.nanoTime();
		/*--------HASH TABLE CHAINING BST EMPRICAL EXPERIMENT---------*/
		System.out.println("--------HASH TABLE CHAINING BST EMPRICAL EXPERIMENT---------");
		System.out.println("--------100 ARRAY WITH 100 CAPACITY.---------");
		for(i=0;i<100;i++){
			map=new HashTableChainingBST<Integer,Integer>(100);
			for(j=0;j<100;j++){
				Random rand = new Random(); 
      			//int upperbound = 1000;
      			int_random = rand.nextInt(1000);
      			map.put(int_random,int_random);
			}
			map.get(54);
			map.remove(1001);

		}	
		map.printTable();
		System.out.println("------------------------------------------------------------");
		long stopTime1 = System.nanoTime();


		System.out.println("--------HASH TABLE CHAINING BST EMPRICAL EXPERIMENT---------");
				System.out.println("--------100 ARRAY WITH 1000 CAPACITY.---------");

		long startTime2 = System.nanoTime();
		for(i=0;i<100;i++){
			map=new HashTableChainingBST<Integer,Integer>(1000);
			for(j=0;j<10000;j++){
				Random rand = new Random(); 
      			int_random = rand.nextInt(10000);
      			map.put(int_random,int_random);
			}
			map.get(54);
			map.remove(10001);
		}
		/*--------HASH TABLE CHAINING BST EMPRICAL EXPERIMENT---------*/
		
		
		System.out.println("------------------------------------------------------------");
		long stopTime2 = System.nanoTime();

		System.out.println("--------HASH TABLE CHAINING BST EMPRICAL EXPERIMENT---------");
		System.out.println("--------100 ARRAY WITH 10000 CAPACITY.---------");
		long startTime3 = System.nanoTime();
		for(i=0;i<100;i++){
			map=new HashTableChainingBST<Integer,Integer>(10000);
			for(j=0;j<100000;j++){
				Random rand = new Random(); 
      			int_random = rand.nextInt(100000);
      			map.put(int_random,int_random);
			}
			map.get(54);
			map.remove(100001);
		}
		/*--------HASH TABLE CHAINING BST EMPRICAL EXPERIMENT---------*/

		System.out.println("------------------------------------------------------------");
		long stopTime3 = System.nanoTime();


		System.out.println("  HASH TABLE CHAINING BST EMPRICAL EXPERIMENT(100) in nanoSeconds:  "+(stopTime1 - startTime1));
		System.out.println();
		System.out.println(" HASH TABLE CHAINING BST EMPRICAL EXPERIMENT(1000) in nanoSeconds:  "+(stopTime2 - startTime2));
		System.out.println();
		System.out.println("HASH TABLE CHAINING BST EMPRICAL EXPERIMENT(10000) in nanoSeconds:  "+(stopTime3 - startTime3));
		System.out.println();
		
	}
}