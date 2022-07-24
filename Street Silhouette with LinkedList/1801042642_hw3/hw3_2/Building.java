/** Represents an Building Class.
 * @author Omer Kaan Uslu
 * @version 1.0
 * @since 1.0
*/
public class Building{
	/**owner variable*/
	private String owner;
	/**position variable*/
	private int position;
	/**length variable*/
	private int length;
	/**height variable*/
	private int height;
	//
	/**type variable in order to decide type in Street Class.*/
	private String type;

	/**getter method for owner */
	public String getOwner(){
		return owner;
	}
	/**getter method for position */
	public int getPosition(){
		return position;
	}
	/**getter method for length */
	public int getLength(){
		return length;
	}
	/**getter method for height */
	public int getHeight(){
		return height;
	}
	/**getter method for type */
	public String getType(){
		return type;
	}
	/**Get Info method to be overrided.*/
	public void getInfo(){}
	/**setter method for owner 
	@param owner Owner Variable*/
	public void setOwner(String owner){
		this.owner=owner;
	}
	/**setter method for position 
	@param position position Variable*/
	public void setPosition(int position){
		this.position=position;
	}
	/**setter method for length
	@param length length Variable */
	public void setLength(int length){
		this.length=length;
	}
	/**setter method for height
	@param height height Variable */
	public void setHeight(int height){
		this.height=height;
	}
	/**setter method for type 
	@param type type Variable*/
	public void setType(String type){
		this.type=type;
	}
	/**Constructor */
	public Building(){}
	/**Focus Method to be overrided */	
	public String focus(){
		return owner;
	}
}