public class Main{
	public static void printPossibilities(char[] arr,int length,int i,boolean inIt){
		if(length>arr.length)//base case where array have no place to fill array with blocks.
			return;
		if(i>arr.length-length){//increments lengths by one and initializes i from 0 to loop over again.
			printPossibilities(arr,length+1,0,inIt);
			return;
		}
		else{System.out.println();
		for(int j=i;j<length+i;j++){//array filling part
			arr[j]='*';
		}
		for(int j=0;j<arr.length;j++){//print array
			System.out.print(arr[j]);
		}
		if(arr.length-length>length+i){//if array is continuable(if there is enough space to continue filling blocks)
				   						//intialize i from i+length+1 and do not empty array.
			printPossibilities(arr,length,length+i+1,true);//inIt boolean turns true. it cuts extra printing for if block below.
		}
		if(!inIt){//increment i by one and continue recursion.
			emptyArray(arr);
			printPossibilities(arr,length,i+1,inIt);
		}

		}
	}
	public static void emptyArray(char[] arr){//helper function empties array.
		for(int i=0;i<arr.length;i++){
			arr[i]='_';
		}
	}
	public static void main(String[] args) {
		char[] arr={'_','_','_','_','_','_','_','_','_','_','_'};
		printPossibilities(arr,3,0,false);
		
	}
}
