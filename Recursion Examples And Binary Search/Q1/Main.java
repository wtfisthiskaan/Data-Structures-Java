
public class Main{
	public static int searchString(String query,String field,int index,int i,int currI){
		System.out.println(query+"   "+field);
		if(query.length()>field.length()){
			return -1;
		}
		if(field.substring(0,query.length()).equals(query))
			currI+=1;
		if(i==currI)
			return index;
		return searchString(query,field.substring(1,field.length()),index+1,i,currI);
	}
	public static void main(String [] args){
		System.out.println(searchString("abc","abcdabcd",0,3,0));

	}
}