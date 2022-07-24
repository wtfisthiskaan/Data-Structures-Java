/** Represents an Office Class.
 * @author Omer Kaan Uslu
 * @version 1.0
 * @since 1.0
*/
public class Office extends Building{
	//defining variables for attributes of Office type.
	private String jobType;
	//base constructor
	public Office(){}
		/** Office Constructor.
	* @param owner owner of building.
	* @param position position of building.
	* @param length length of building.
	* @param height height of building.
	* @param jobType jobtype of office.
	*/

	public Office(String owner,int position,int length,int height,String jobType){
		this.setOwner(owner);
		this.setPosition(position);
		this.setLength(length);
		this.setHeight(height);
		this.jobType=jobType;
		this.setType("Office");
	}
	/**getter method for jobType*/
	public String getJobType(){
		return jobType;
	}
	/**,Overrided getInfo Method. Displays Info of building.*/
	public void getInfo(){
		System.out.println("Type: "+this.getType());
		System.out.println("Job Type: "+jobType);
	}
	/**setter method for jobType 
	@param jobType jobType Variable*/
	public void setJobType(String jobType){
		this.jobType=jobType;
	}
	/**,Overrided focus method.*/
	public String focus(){
		return getJobType();
	}
}