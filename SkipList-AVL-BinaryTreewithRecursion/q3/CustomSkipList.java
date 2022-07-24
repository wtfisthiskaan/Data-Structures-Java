import java.util.Random;
import java.io.*;
import java.util.*;  
public class CustomSkipList<T extends Comparable<? super T>> implements SkippableList<T> {

  private final SkipNode<T> head = new SkipNode<>(null);
  private final Random rand = new Random();
  private HashSet<T> tallItems=new HashSet(); 
  private int LEVELS = 2;
  private int size=0;
  public CustomSkipList(){}

  public CustomSkipList(int lev){
    LEVELS=lev;
  }
  @Override
  public void insert(T data) {
    SkipNode<T> skipNode = new SkipNode<>(data);
    insert(skipNode, 0);
    int probability=calc_probability(data);
   // System.out.println(probability);
    for (int i = 1; i < LEVELS; i++) {
      if (rand.nextInt(10) < probability){
        tallItems.add(data);
        insert(skipNode, i);
      }
      else{
        break;
      }
    }
    size++;
    if(size%10==0)
      reArrange();/**/
  }

  public void reArrange(){
    int oldLevels=LEVELS;
    LEVELS++;
    SkipNode<T>[] temp = head.next;
    head.next=(SkipNode<T>[]) new SkipNode[LEVELS]; 
    for(int i = 0;i < oldLevels;i++){
      head.next[i]=temp[i];
    }

    SkipNode<T> temp2;
    for(int i = 1;i < 2 ;i++){


      temp2 = head.getNext(i);
      while(temp2!=null){
        //System.out.println(temp2.data);
        SkipNode<T> skipNode = new SkipNode<>(temp2.data);
        insert(skipNode,searchReturnLevel(temp2.data,true)+1);
        temp2=temp2.getNext(i);
      }
      
    }

  }


  public int calc_probability(T data){
   int leftDistance=0; 
   int rightDistance=0;
   SkipNode<T> current = this.head.getNext(0);
   while(current.getNext(0) != null && current.data.compareTo(data)!=0){
        if(tallItems.contains(current.data)){
          leftDistance=0;
        }
        else{
          leftDistance++;
        }
        current=current.getNext(0);
   }

   current = this.head.getNext(0);

   while(current.data.compareTo(data)!=0){
         current=current.getNext(0);
   }
   while(current.getNext(0) != null){
        if(tallItems.contains(current.data)){
          break;
        }
        else{
          rightDistance++;
        }
        current=current.getNext(0);
   }

   return rightDistance+leftDistance;


    }


  @Override
  public boolean delete(T target) {
    System.out.println("Deleting " + target);
    SkipNode<T> victim = search(target, true);
    if (victim == null) return false;
    victim.data = null;

    for (int i = 0; i < LEVELS; i++) {
      head.refreshAfterDelete(i);
    }

    System.out.println("deleted...");
    return true;
  }

  @Override
  public SkipNode<T> search(T data) {
    return search(data, true);
  }

  @Override
  public void print() {
    for (int i = LEVELS-1; i >= 0 ; i--) {
      head.print(i);
    }
    System.out.println();
  }

  private void insert(SkipNode<T> SkipNode, int level) {
    head.insert(SkipNode, level);
  }

  private SkipNode<T> search(T data, boolean print) {
    SkipNode<T> result = null;
    for (int i = LEVELS-1; i >= 0; i--) {
      if ((result = head.search(data, i, print)) != null) {
        if (print) {
          //System.out.println("Found " + data.toString() + " at level " + i + ", so stopped" );
          //System.out.println();
        }
        break;
      }
    }

    return result;
  }

  private int searchReturnLevel(T data,boolean print){
        SkipNode<T> result = null;
        for (int i = LEVELS-2; i >= 0; i--) {
          if ((result = head.search(data, i, print)) != null) {
            if (print) {
              return i;
            }
            break;
          }
        }
        return 0;
  }

}