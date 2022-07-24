
/* Class HashTableChainingBinaryTree */
public class HashTableChainingBST<K extends Comparable<K>,V  extends Comparable<V>> implements KWHashMap<K,V>
{
    private BTNode<K,V>[] table;
    private int size;
    private int tableSize;
    /* Constructor */
    public HashTableChainingBST(int tableSize)
    {
        this.tableSize=tableSize;
        table = new BTNode[tableSize];
        size = 0;
    }
    /* get method*/
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
    /* Function to check if hash table is empty */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
    /* Function to get size */
    @Override
    public int size()
    {
        return size;
    }
    /* Function to insert an element */
    @Override
    public V put(K x,V y)
    {
        size++;
        int pos = myhash(x);        
        BTNode root = table[pos];
        root = put(root, x,y);
        table[pos] = root;
        return y;       
    }
    /* Function to insert data */
    
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
    /* Function to remove an element */
    @Override
    public V remove(K x)
    {
        int pos = myhash(x);        
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
            System.out.println("\nElement not present\n");        
        }        
        table[pos] = root;
        return temp;   
    }
    /* Function to remove an element */
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
    /* Function myhash */
    private int myhash(K x)
    {
        int hashVal = x.hashCode();
        hashVal %= table.length;
        if (hashVal < 0)
            hashVal += table.length;
        return hashVal;
    }
    /* Function to generate next prime number >= n */

    /* printing hash table */
    public void printHashTable ()
    {
        System.out.println();
        for (int i = 0; i < table.length; i++)
        {
            System.out.print ("Bucket " + i + ":  ");            
            inorder(table[i]);
            System.out.println();
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