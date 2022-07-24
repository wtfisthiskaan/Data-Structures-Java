public class Main{
	public static void exploreMazes(int[][] arr,int length,int i,int j,int fillWith,int currlen,int countFilled){
		
		if((i>arr.length-1 || i<0 || j>arr[0].length-1 || j<0)){
			int a;
		}/**/
		else if(fillWith>arr.length){
			//System.out.print(2);
			int a;//do nothing
		}
		else if(countFilled==arr.length*arr.length){
			//System.out.print(2);
				for(int k=0;k<arr.length;k++){
				for(int d=0;d<arr.length;d++){
					System.out.print(arr[k][d]);
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
		else{
			if(arr[i][j]==0){
				if(currlen>=5){
					currlen=0;
					fillWith+=1;
				}
					arr[i][j]=fillWith;
					int[][] copyArr1=copyArr(arr);
					int[][] copyArr2=copyArr(arr);
					int[][] copyArr3=copyArr(arr);
					int[][] copyArr4=copyArr(arr);
					exploreMazes(copyArr1,length,i+1,j,fillWith,currlen+1,countFilled+1);
					exploreMazes(copyArr2,length,i-1,j,fillWith,currlen+1,countFilled+1);
					exploreMazes(copyArr3,length,i,j+1,fillWith,currlen+1,countFilled+1);
					exploreMazes(copyArr4,length,i,j-1,fillWith,currlen+1,countFilled+1);
						}
	}
}
	public static int[][] copyArr(int[][] arr){
		int[][] copy=new int[5][5];
		for (int i=0;i<5;i++) {
			for (int j=0;j<5;j++) {
					copy[i][j]=arr[i][j];
				}	
		}
		return copy;
	}
	public static boolean isArrayFull(int[][] arr){//helper function empties array.
		int[] counts={0,0,0,0,0};
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
			/*	if(arr[i][j]==1)
					counts[0]++;
				else if(arr[i][j]==2)
					counts[1]++;
				else if(arr[i][j]==3)
					counts[2]++;
				else if(arr[i][j]==4)
					counts[3]++;
				else if(arr[i][j]==5)
					counts[4]++;*/
				if(arr[i][j]==0)
					return false;	
			}
		}
		/*if(counts[0]==5 && counts[1]==5 && counts[2]==5 && counts[3]==5 && counts[4]==5)
			return true;
		else*/
			return true;
	}
	public static void main(String[] args) {
		int[][] arr=new int[5][5];
		//System.out.println(arr[0].length);
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				arr[i][j]=0;
			}
		}
		exploreMazes(arr,5,0,0,1,0,0);
		
	}
}
