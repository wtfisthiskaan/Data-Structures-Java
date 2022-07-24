import java.util.*;

public class Main{


	@SuppressWarnings("unchecked")
	public static void main(String[] arg){
		//-----------Table Example
		HashtableHybrid<Integer,Integer> tempmap=new HashtableHybrid<Integer,Integer>(10);
		tempmap.put(3,3);
		tempmap.put(12,12);
		tempmap.put(13,13);
		tempmap.put(25,25);
		tempmap.put(23,23);
		tempmap.put(51,51);
		tempmap.printTable();
		tempmap.remove(25);
		tempmap.printTable();


		//-----------Table Example
		HashtableHybrid<Integer,Integer> map=new HashtableHybrid<Integer,Integer>(100);
		int i,j;
		int int_random=0;
		long startTime1 = System.nanoTime();
		/*--------HASH TABLE CHAINING BST EMPRICAL EXPERIMENT---------*/
		System.out.println("--------HASH TABLE HYBRID EMPRICAL EXPERIMENT---------");
		System.out.println("--------100 ARRAY WITH 100 CAPACITY.---------");
		for(i=0;i<100;i++){
			map=new HashtableHybrid<Integer,Integer>(100);
			for(j=0;j<100;j++){
				Random rand = new Random(); 
      			//int upperbound = 1000;
      			int_random = rand.nextInt(100);
      			//System.out.print(int_random);
      			map.put(int_random,int_random);
			}
			map.get(54);
			map.remove(42);
			//System.out.print(int_random);
		}	
		//map.printTable();
		System.out.println("------------------------------------------------------------");
		long stopTime1 = System.nanoTime();


		System.out.println("--------HASH TABLE HYBRID EMPRICAL EXPERIMENT---------");
				System.out.println("--------100 ARRAY WITH 1000 CAPACITY.---------");

		long startTime2 = System.nanoTime();
		for(i=0;i<100;i++){
			map=new HashtableHybrid<Integer,Integer>(1000);
			for(j=0;j<10000;j++){
				Random rand = new Random(); 
      			//int upperbound = 1000;
      			int_random = rand.nextInt(10000);
      			map.put(int_random,int_random);
			}
			map.get(54);
			map.remove(10001);
			//System.out.print(int_random);
		}
		/*--------HASH TABLE CHAINING BST EMPRICAL EXPERIMENT---------*/
		
		//map.printTable();
		
		System.out.println("------------------------------------------------------------");
		long stopTime2 = System.nanoTime();

		System.out.println("--------HASH TABLE HYBRID EMPRICAL EXPERIMENT---------");
		System.out.println("--------100 ARRAY WITH 10000 CAPACITY.---------");
		long startTime3 = System.nanoTime();
		for(i=0;i<100;i++){
			map=new HashtableHybrid<Integer,Integer>(10000);
			for(j=0;j<100000;j++){
				Random rand = new Random(); 
      			//int upperbound = 1000;
      			int_random = rand.nextInt(100000);
      			map.put(int_random,int_random);
			}
			map.get(54);
			map.remove(100001);
			//System.out.print(int_random);
		}
		/*--------HASH TABLE CHAINING BST EMPRICAL EXPERIMENT---------*/

		//map.printTable();
		
		System.out.println("------------------------------------------------------------");
		long stopTime3 = System.nanoTime();


		System.out.println("  HASH TABLE HYBRID EMPRICAL EXPERIMENT(100) in nanoSeconds:  "+(stopTime1 - startTime1));
		System.out.println();
		System.out.println(" HASH TABLE HYBRID EMPRICAL EXPERIMENT(1000) in nanoSeconds:  "+(stopTime2 - startTime2));
		System.out.println();
		System.out.println("HASH TABLE HYBRID EMPRICAL EXPERIMENT(10000) in nanoSeconds:  "+(stopTime3 - startTime3));
		System.out.println();
	}
}