import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class Main{
            // Function to get the left height of
        // the binary tree
    static int left_height(Node node)
        {
            int ht = 0;
            while (node!=null) {
                ht++;
                node = node.left;
            }
         
            // Return the left height obtained
            return ht;
        }
         
        // Function to get the right height
        // of the binary tree
    static int right_height(Node node)
        {
            int ht = 0;
            while (node!=null) {
                ht++;
                node = node.right;
            }
         
            // Return the right height obtained
            return ht;
        }
         
        // Function to get the count of nodes
        // in complete binary tree
    static int TotalNodes(Node root)
        {
         
            // Base Case
            if (root == null)
                return 0;
         
            // Find the left height and the
            // right heights
            int lh = left_height(root);
            int rh = right_height(root);
         
            // If left and right heights are
            // equal return 2^height(1<<height) -1
            if (lh == rh)
                return (1 << lh) - 1;
         
            // Otherwise, recursive call
            return 1 + TotalNodes(root.left)
                   + TotalNodes(root.right);
        }
    public static void createBST(BinaryTree bt,Comparable[] items){
        List<Comparable> lows = new ArrayList<Comparable>();
        List<Comparable> ups = new ArrayList<Comparable>();
        for(int i=0;i<items.length;i++){
            lows = new ArrayList<Comparable>();
            ups = new ArrayList<Comparable>();
            int numLower=0,numUpper=0;
            for(int j=0;j<items.length;j++){
                if(items[i].compareTo(items[j]) > 0){
                    ups.add(items[j]);
                    numUpper++;
                }
                else if(items[i].compareTo(items[j]) < 0){
                    lows.add(items[j]);
                    numLower++;
                }
            }
            if(numUpper==TotalNodes(bt.root.left) && numLower==TotalNodes(bt.root.right)){
                bt.root.data=items[i];
                Comparable[] lowComp=new Comparable[numLower];
                Comparable[] upComp=new Comparable[numUpper];
                for(int j=0;j<numLower;j++){
                    lowComp[j]=lows.get(j);
                }
                for(int j=0;j<numUpper;j++){
                    upComp[j]=ups.get(j);
                }
                createBST(bt.getLeftSubtree(),upComp);
                createBST(bt.getRightSubtree(),lowComp);

            }
        }

    }

    public static BinarySearchTree crBST(BinaryTree bt,Comparable[] items){
        createBST(bt,items);
        BinarySearchTree<Integer> bres=new BinarySearchTree<Integer>(bt.root);
        return bres;
    }

    public static void printLeftView(Node bt){
        ArrayList<Integer> lst = new ArrayList<Integer>();
        helper(bt,0,lst);
    }

    public static void helper(Node node,int i,ArrayList<Integer> lst){
        if(node == null)
            return;
        if(!lst.contains(i)){
            System.out.println(node.data);
            lst.add(i);
        }

        helper(node.left,i+1,lst);
        helper(node.right,i+1,lst);
    }
    public static void main(String[] args){
        //BinarySearchTree<Integer> b1= new BinarySearchTree<Integer>();
       Node<Integer> n1=new Node(0);
        n1.left=new Node(0);
        n1.left.right=new Node(0);
        n1.right=new Node(0);
        n1.right.left=new Node(0);
        n1.right.left.right=new Node(0);
        n1.right.right=new Node(0);
        n1.right.right.right=new Node(0);
        BinaryTree<Integer> b1=new BinaryTree<Integer>(n1);

        //System.out.println(b1.toString());
        Integer[] arr=new Integer[]{15,30,20,25,45,10,55,35};
        BinarySearchTree<Integer> b2=crBST(b1,(Comparable[])arr);
        System.out.println(b2.toString());
        printLeftView(n1);

/*        System.out.println(b1.toString());
        Integer[] arr=new Integer[]{15,30,20,25,45,10,55,35};
        createBST(b1,(Comparable[])arr);
        System.out.println(b1.toString());
*/
         /*Node<Integer> n1=new Node(0);
        n1.right=new Node(0);
        n1.right.right=new Node(0);
        n1.right.right.right=new Node(0);
        n1.right.right.right.right=new Node(0);
        n1.right.right.right.right.right=new Node(0);
        n1.right.right.right.right.right.right=new Node(0);
        n1.right.right.right.right.right.right.left=new Node(0);
        BinaryTree<Integer> b1=new BinaryTree<Integer>(n1);
        
        System.out.println(b1.toString());
        Integer[] arr=new Integer[]{15,30,20,25,45,10,55,35};
        BinarySearchTree<Integer> b2=crBST(b1,(Comparable[])arr);
        System.out.println(b2.toString());*/

    }


}