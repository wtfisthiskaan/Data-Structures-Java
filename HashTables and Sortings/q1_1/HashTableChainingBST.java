/** Represents an HashTableChainingBST Class.
 * @author Omer Kaan Uslu
 * @version 1.0
 * @since 1.0
*/
public class HashTableChainingBST<K extends Comparable<K>,V  extends Comparable<V>> implements KWHashMap<K,V>
{
    private BTNode<K,V>[] table;
    private int size;
    private int tableSize;
     /** Constructor 
     * @param tableSize is table size of hash table.;
     * */
    public HashTableChainingBST(int tableSize)
    {
        this.tableSize=tableSize;
        table = new BTNode[tableSize];
        size = 0;
    }
    /** Get Function.
  * @param key is key of corresponding value.
  * @return value of parameter key.
  */
    @Override
    public V get (K key){
        for(int i=0;i<tableSize;i++){
            if(table[i]!=null){
                BTNode<K,V> temp=table[i];
                while(temp!=null){
                    if(temp.key.compareTo(key)==0)
                        return temp.value;
                    else if (temp.key.compareTo(key)>=0) {
                        temp=temp.right;
                    }
                    else
                        temp=temp.left;
                }
            }
        }
        return null;
    }
     /** isEmpty Function.
  * @return true or false in cases map is empty or not.
  */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
    /** size Function.
  * @return size of hashmap.
  */
    @Override
    public int size()
    {
        return size;
    }
    /** put Function.
  * @param x is key to be added.
  * @param y is value of key.
  * @return value.
  */
    @Override
    public V put(K x,V y)
    {
        size++;
        int pos = hash(x);        
        BTNode root = table[pos];
        root = put(root, x,y);
        table[pos] = root;
        return y;       
    }
    /** put Function.
     * @param node is node to be added.
  * @param x is key to be added.
  * @param y is value of key.
  * @return BTNode of placed item.
  */  
    private BTNode put(BTNode<K,V> node, K x,V y)
    {
        if (node == null)
            node = new BTNode(x,y);
        else
        {
            if (x.compareTo(node.key) <= 0)
                node.left = put(node.left,x,y);
            else
                node.right = put(node.right,x,y);
        }
        return node;
    }
    /** remove Function.
  * @param x is key of value to be remove.
  * @return value of parameter key.
  */
    @Override
    public V remove(K x)
    {
        int pos = hash(x);        
        BTNode root = table[pos];
        V temp=get(x);
        try
        {

            root = delete(root, x);  
            size--;
            return temp;

        }
        catch (Exception e)
        {
            //System.out.println("\nElement not present\n");        
        }        
        table[pos] = root;
        return temp;   
    }
    /** delete Function.
     * @param root is root value of corresponding index.
  * @param key is key of value to be remove.
  * @return value of parameter key.
  */
    private BTNode delete(BTNode<K,V> root, K x)
    {
        BTNode p, p2, n;
        if (root.key == x)
        {
               BTNode lt, rt;
            lt = root.left;
            rt = root.right;
            if (lt == null && rt == null)
                return null;
            else if (lt == null)
            {
                p = rt;
                return p;
            }
            else if (rt == null)
            {
                p = lt;
                return p;
            }
            else
            {
                p2 = rt;
                p = rt;
                while (p.left != null)
                    p = p.left;
                p.left = lt;
                return p2;
            }
        }
        if (x.compareTo(root.key) <= 0)
        {
            n = delete(root.left, x);
            root.left = n;
        }
        else
        {
            n = delete(root.right, x);
            root.right = n;             
        }
        return root;
    }
    /** hash Function.
  * @param x is key.
  * @return hashed integer index.
  */
    private int hash(K x)
    {
        int hashVal = x.hashCode();
        hashVal %= table.length;
        if (hashVal < 0)
            hashVal += table.length;
        return hashVal;
    }
         /** printHashTable Function.
      */
    public void printTable ()
    {

        System.out.println();
            System.out.println("Hash V.\tKey");
        System.out.println();
        for (int i = 0; i < table.length; i++)
        {

            if(table[i]!=null ){
                System.out.print(i+"\t");
                inorder(table[i]);
                System.out.println();
                }
        }
    }  
    /* inorder traversal */
    private void inorder(BTNode r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.key+","+r.value +" ");
            inorder(r.right);
        }
    }     
}