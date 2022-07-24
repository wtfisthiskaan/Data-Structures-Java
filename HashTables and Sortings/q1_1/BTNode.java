/** Represents an BTNode Class.
 * @author Omer Kaan Uslu
 * @version 1.0
 * @since 1.0
*/
public class BTNode<K  extends Comparable<K>,V  extends Comparable<V>>
{
    BTNode left, right;
    K key;
    V value;
 
    /* Constructor */
    public BTNode()
    {
        left = null;
        right = null;
    }
    /** Constructor 
     * @param key is key of entry;
     * @param value is value of key.
     * */
    public BTNode(K key, V value)
    {
        this.key=key;
        this.value=value;
        left = null;
        right = null;
    }
}
 