/** Represents an Market Class.
 * @author Omer Kaan Uslu
 * @version 1.0
 * @since 1.0
*/
public class Market extends Building{
	//defining variables for attributes of Market type.
	private String openingTime;
	private String closingTime;
	//base constructor
	public Market(){}
	/** Market Constructor.
	* @param owner owner of building.
	* @param position position of building.
	* @param length length of building.
	* @param height height of building.
	* @param openingTime openingTime of Market.
	* @param closingTime closingTime of Market.
	*/
	public Market(String owner,int position,int length,int height,String openingTime,String closingTime){
		this.setOwner(owner);
		this.setPosition(position);
		this.setLength(length);
		this.setHeight(height);
		this.openingTime=openingTime;
		this.closingTime=closingTime;
		this.setType("Market");
	}
	/**getter method for openingTime*/
	public String getOpeningTime(){
		return openingTime;
	}
	/**getter method for closingTime*/
	public String getClosingTime(){
		return closingTime;
	}
	/**,Overrided getInfo Method. Displays Info of building.*/
	public void getInfo(){
		System.out.println("Type: "+this.getType());
		System.out.println("Opening Time: "+openingTime);
		System.out.println("Closing Time: "+closingTime);
	}
		/**setter method for openingTime 
	@param openingTime openingTime Variable*/
	public void setOpeningTime(String openingTime){
		this.openingTime=openingTime;
	}
		/**setter method for closingTime 
	@param closingTime closingTime Variable*/
	public void setClosingTime(String closingTime){
		this.closingTime=closingTime;
	}
	/**,Overrided focus method.*/
	public String focus(){
		return getClosingTime();
	}

}