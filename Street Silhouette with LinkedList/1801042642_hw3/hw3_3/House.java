/** Represents an House Class.
 * @author Omer Kaan Uslu
 * @version 1.0
 * @since 1.0
*/
public class House extends Building{
	//defining variables for attributes of House type.
	private int roomNums;
	private String color;
	//base constructor
	public House(){}
		/** Market Constructor.
	* @param owner owner of building.
	* @param position position of building.
	* @param length length of building.
	* @param height height of building.
	* @param roomNums roomNums of House.
	* @param color color of House.
	*/
	public House(String owner,int position,int length,int height,int roomNums,String color){
		this.setOwner(owner);
		this.setPosition(position);
		this.setLength(length);
		this.setHeight(height);
		this.roomNums=roomNums;
		this.color=color;
		this.setType("House");
	}
	/**getter method for roomNums*/
	public int getRoomNums(){
		return roomNums;
	}
	/**getter method for color*/
	public String getColor(){
		return color;
	}
	/**,Overrided getInfo Method. Displays Info of building.*/
	public void getInfo(){
		System.out.println("Type: "+this.getType());
		System.out.println("Room Number: "+roomNums);
		System.out.println("Color: "+color);
	}
	/**setter method for roomNums 
	@param roomNums roomNums Variable*/
	public void setRoomNums(int roomNums){
		this.roomNums=roomNums;
	}
	/**setter method for color 
	@param color color Variable*/
	public void setColor(String color){
		this.color=color;
	}
	/**,Overrided focus method.*/
	public String focus(){
		return getOwner();
	}
}