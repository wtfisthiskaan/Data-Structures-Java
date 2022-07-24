import java.util.List;
import java.util.AbstractList;
/** Represents an Street Class.
 * @author Omer Kaan Uslu
 * @version 1.0
 * @since 1.0
*/
public class LDLinkedList extends AbstractList implements List
{
    public Node head;
    public Node tail;
    //for lazy deletion part.
    public Node trashHead;
    public Node trashTail;
    /** Constructor of LDLinkedList class.
	*/
    public LDLinkedList()
    {
        head = null;
        tail = null;
        trashHead=null;
        trashTail=null;
    }
    /** Add Function.
	* @param b building to be added.
	*/
    //@Override
    public Building add(Building b)
    {
    	//Node t = new Node(b);
    	Node t = new Node(b);
    	Node temp=trashHead;
    	boolean inIt=false;
    	while(temp!=null){
    		if(temp.b==b){
    			inIt=true;
    			t=temp;
    			t.next=null;
    			break;
    		}
    	}	
        if(tail == null)
        {
            head = t;
            tail = t;
            tail.next = null;
        }
        else
        {
            tail.next = t;
            tail = t;
            tail.next = null;

        }
        return b;
    }
    /** Get Function.
	* @param index index of node to be get.
	*/
    @Override
    public Building get(int index)
    {
        Node t = head;
        int count = 0;
        while(t!=null && count<index)
        {
            t = t.next;
            count++;
        }

        if(t!=null)
        {
            return t.b;
        }
        else
            return null;
     }
     /** size Function.
	* To Get size of Linked List;
	*/
	@Override
	public int size()
	{
	    Node t = head;
	    int count = 0;
	    while(t!=null)
	    {
	        count++;
	        t = t.next;
	    }
	    return count;
	}
	/** remove Function.
	* @param index index of node to be removed.
	*/
	@Override
	public Building remove(int index)
    {
        // If linked list is empty
        if (head == null)
            return null;
 
        // Store head node
        Node temp = head;
 
        // If head needs to be removed
        if (index == 0) {
            head = temp.next; // Change head
            Node t=temp;
            /*LAZY DELETION ADDITION PART*/
            t.next=null;
			if(trashTail==null){
				trashHead=t;
				trashTail=t;
				trashTail.next=null;
			}
			else{
				tail.next = t;
            	tail = t;
            	tail.next = null;
			}
			/*LAZY DELETION ADDITION PART*/
            return null;
        }
 
        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < index - 1;
             i++)
            temp = temp.next;
 
        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return null;
 
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        /* LAZY  DELETION ADDITION PART*/
			Node t=temp.next;
			t.next=null;
			if(trashTail==null){
				trashHead=t;
				trashTail=t;
				trashTail.next=null;
			}
			else{
				tail.next = t;
            	tail = t;
            	tail.next = null;
			}

		/*LAZY DELETION ADDITION PART*/
        

        Node next = temp.next.next;
        temp.next = next; // Unlink the deleted node from list
        return null;
    }

}