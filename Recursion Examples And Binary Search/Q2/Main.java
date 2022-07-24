
public class Main{
	public static int findNum(int[] arr,int first, int last,int targetLower,int targetUpper,boolean check){
		if(check){
			if(first>last)
				return -1;
			else{
				int middle=(first+last)/2;
						if(arr[middle]==targetLower){
							return findNum(arr,0,arr.length-1,targetLower,targetUpper,false)-middle;
						}
						else if(arr[middle]>targetLower){
							return findNum(arr,first,middle-1,targetLower,targetUpper,check);
						}
						else if(arr[middle]<targetLower){
							return findNum(arr,middle+1,last,targetLower,targetUpper,check);
						}
				}
		}
		else{
			if(first>last)
				return -1;
			else{
				int middle=(first+last)/2;
						if(arr[middle]==targetUpper){
							return middle;
						}
						else if(arr[middle]>targetUpper){
							return findNum(arr,first,middle-1,targetLower,targetUpper,check);
						}
						else if(arr[middle]<targetUpper){
							return findNum(arr,middle+1,last,targetLower,targetUpper,check);
						}
				}
		}
		return 0;
	}
	public static void main(String [] args){
		int[] arr={0,1,2,3,4,5,6,7,8,9};

		System.out.println(findNum(arr,0,9,3,7,true));

	}
}