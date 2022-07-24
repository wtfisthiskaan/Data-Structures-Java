/** Represents an Playground Class.
 * @author Omer Kaan Uslu
 * @version 1.0
 * @since 1.0
*/
public class Playground extends Building{
	/** Playground Base Constructor.
	*/
	public Playground(){}
	/** Playground Constructor.
	* @param length length of building.
	* @param position position of building.
	*/
	public Playground(int position,int length){
		this.setPosition(position);
		this.setLength(length);
		this.setHeight(0);//supposed all playgrounds length are 0
		this.setType("Playground");
	}
	/** focus method overrided.
	*/
	public String focus(){
		return this.getLength()+"";
	}

}