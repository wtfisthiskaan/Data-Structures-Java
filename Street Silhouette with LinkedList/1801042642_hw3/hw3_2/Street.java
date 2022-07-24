import java.util.LinkedList;
/** Represents an Street Class.
 * @author Omer Kaan Uslu
 * @version 1.0
 * @since 1.0
*/
public class Street{
	//private Building[][] buildings;
	//creates linkedlist of linkedlists
	private LinkedList<LinkedList<Building>> buildings;
	//length of street 
	private int length;
	//2 count variable in order to know how many building front side and back side of street have.
	//private int buildings.get(0).size()=0;
	//private int buildings.get(1).size()=0;
	//constructors
	public Street(){}
	/** Constructor of Street class.
	* @param length Length of street.
	* @param maxBuildingNum max Building Numbers each side have.
	*/
	public Street(int length,int maxBuildingNum){
		this.length=length;
		buildings= new LinkedList<LinkedList<Building>>();
    	buildings.add(new LinkedList<Building>());
    	buildings.add(new LinkedList<Building>());
	}
	/** Add Function.
	* @param b building to be added.
	* @param side side parameter.
	*/
	public void add(Building b,int side){
		//check if building is acceptable conditions for current street.
		int i,j;

		if((side==0 || side==1) && (b.getPosition()+b.getLength()<=length) && (b.getPosition()>=0) && (b.getLength()<=length)){
			if(side==0){
				//check for building overlap
				for(i=0;i<buildings.get(0).size();i++){
					//check if there is overlap situation
					if(!((buildings.get(side).get(i).getPosition()>b.getLength()+b.getPosition()) 
						|| (buildings.get(side).get(i).getPosition()+buildings.get(side).get(i).getLength()<b.getPosition())))
						throw new IllegalArgumentException("error message");//
				}
				buildings.get(side).add(b);
				//increment count
			}
			else{//check for building overlap
				for(i=0;i<buildings.get(1).size();i++){
					//check if there is overlap situation
					if(!((buildings.get(side).get(i).getPosition()>=b.getLength()+b.getPosition()) 
						|| (buildings.get(side).get(i).getPosition()+buildings.get(side).get(i).getLength()<=b.getPosition())))
						throw new IllegalArgumentException("error message");;//
				}
				buildings.get(side).add(b);
				//increment count
			}

		}
	}
	/** Remove Function.
	* @param index index parameter which is going to be removed..
	* @param side side parameter.
	*/
	public void remove(int index,int side){
		if(side==0){
			if(index>=buildings.get(0).size())
				throw new IllegalArgumentException("Out Of Index");
			buildings.get(0).remove(index);
		}
		else if(side==1){
			if(index>=buildings.get(1).size())
				throw new IllegalArgumentException("Out Of Index");
			buildings.get(1).remove(index);

		}
	}
	/** List Playgrounds Function
	*List all Playgrounds
	*/
	public void list_playgrounds(){
		for(int i=0;i<buildings.get(0).size();i++){
			if(buildings.get(0).get(i).getType()=="Playground")
			System.out.println(buildings.get(0).get(i).focus());
		}
		for(int i=0;i<buildings.get(1).size();i++){
			if(buildings.get(1).get(i).getType()=="Playground")
			System.out.println(buildings.get(1).get(i).focus());
		}
	}
	/** List Buildings Function
	*List all Buildings
	*/
	public void list_buildings(){
		for(int i=0;i<buildings.get(0).size();i++){
			if(buildings.get(0).get(i).getType()!="Playground")
			System.out.println(buildings.get(0).get(i).focus());
		}
		for(int i=0;i<buildings.get(1).size();i++){
			if(buildings.get(1).get(i).getType()!="Playground")
			System.out.println(buildings.get(1).get(i).focus());
		}
	}
	/** Display Remaining lands Function
	*Display total lands' length which is empty.
	*/
	public void displayRemainingLands(){
		int total=0;
		for(int i=0;i<buildings.get(0).size();i++){
			total+=buildings.get(0).get(i).getLength();
		}
		for(int i=0;i<buildings.get(1).size();i++){
			total+=buildings.get(1).get(i).getLength();
		}
		System.out.println("Total remaining lands: "+((length*2)-total));
	}
	/** Display Buildings Function
	*Display buildings' infos.
	*/
	public void displayBuildings(){
		System.out.println("-----------");
		for(int i=0;i<buildings.get(0).size();i++){
			System.out.println("Building No: (Front Side)"+i);
			buildings.get(0).get(i).getInfo();
			System.out.println("-----------");

		}
		for(int i=0;i<buildings.get(1).size();i++){
			System.out.println("Building No: (Back Side)"+i);
			buildings.get(1).get(i).getInfo();
			System.out.println("-----------");
		}
	}
	/** Ratio Playgrounds Function
	*calculate and display ratio of playgrounds.
	*/
	public void ratioPlaygrounds(){
		float total=0;
		int totalplNum=0;
		for(int i=0;i<buildings.get(0).size();i++){
			if(buildings.get(0).get(i).getType()=="Playground"){
				total+=buildings.get(0).get(i).getLength();
				totalplNum++;
			}
			
		}
		for(int i=0;i<buildings.get(1).size();i++){
			if(buildings.get(1).get(i).getType()=="Playground"){
				total+=buildings.get(1).get(i).getLength();
				totalplNum++;
			}
			
		}
		total=(total/(length*2))*100;
		System.out.println("The numbers of playgrounds: "+(totalplNum));
		System.out.println("The  ratio of length of playgrounds: "+total);
	}
	/** Calculate Length Function
	*@param type corresponding type for builldings
	*Calculate Length of corresponding type
	*/
	public void calculateLength(String type){
		int total=0;
		for(int i=0;i<buildings.get(0).size();i++){
			if(buildings.get(0).get(i).getType()==type){
				System.out.println("ba");
				total+=buildings.get(0).get(i).getLength();
			}
			
		}
		for(int i=0;i<buildings.get(1).size();i++){
			if(buildings.get(1).get(i).getType()==type){
				System.out.println("ba");
				total+=buildings.get(1).get(i).getLength();
			}
			
		}
		System.out.println("The total length of corresponding type "+type+" is: "+total);
	}
	/** Display Skyline Silhoutte Function
		*Displays Silhouette
		*/
	public void drawSkylineSil(){
		//heightsArr array for store Maximum Length for corresponding position
		int[] heightsArr=new int[length];
		//loop variables, and temporaries.
		int i,j,pos,len,height;
		//fill all array with 0
		for(i=0;i<length;i++){
			heightsArr[i]=0;
		}
		//fill front
		for(i=0;i<buildings.get(0).size();i++){
			pos=buildings.get(0).get(i).getPosition();
			len=buildings.get(0).get(i).getLength();
			height=buildings.get(0).get(i).getHeight();
			for(j=pos;j<pos+len;j++){
				heightsArr[j]=height;
			}
		}
		//fill back
		for(i=0;i<buildings.get(1).size();i++){
			pos=buildings.get(1).get(i).getPosition();
			len=buildings.get(1).get(i).getLength();
			height=buildings.get(1).get(i).getHeight();
			for(j=pos;j<pos+len;j++){
				if(height>heightsArr[j])
				heightsArr[j]=height;
			}
		}
		int maxHeight=0;
		//find maxHeight in order to calculate array size
		for(i=0;i<length;i++){
			if(heightsArr[i]>maxHeight)
				maxHeight=heightsArr[i];
		}
		//silhouette double array
		char[][] silhouette=new char[maxHeight+2][length];
		//fill all matrice with ' ' character
		for(i=0;i<maxHeight+2;i++){
			for(j=0;j<length;j++){
				silhouette[i][j]=' ';
			}
		}
		//fill borders of buildings with '_' and '|' characters. top and bottom of buildings represented with '_'
		for(i=0;i<length;i++){
			if(heightsArr[i]==0)
				silhouette[maxHeight-(heightsArr[i])][i]='_';
			else
				silhouette[maxHeight-(heightsArr[i])][i]='_';
			if((i==0 && heightsArr[i]>0) || (i==length-1 && heightsArr[i]>0)){//if head or end of array, and arr > 0, draw borders to bottom
				for(j=maxHeight-(heightsArr[i]);j<maxHeight+1;j++){
					silhouette[j+1][i]='|';
				}
			}
			else if(i!=0 && heightsArr[i]>heightsArr[i-1]){//draw borders to bottom
				for(j=maxHeight-(heightsArr[i]);j<maxHeight-heightsArr[i-1];j++){
					silhouette[j+1][i]='|';
				}
			}
			else if(i!=length-1 && heightsArr[i]>heightsArr[i+1]){//draw borders to top
				for(j=maxHeight-(heightsArr[i]);j<maxHeight-heightsArr[i+1];j++){
					silhouette[j+1][i]='|';
				}
			}
			
		}
		for(i=0;i<maxHeight+2;i++){//print silhouette
			for(j=0;j<length;j++){
				System.out.print(silhouette[i][j]);
			}
			System.out.println();
		}
	}
}