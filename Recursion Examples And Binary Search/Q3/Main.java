public class Main{
	public static void findNum(int[] arr,int i, int j,int target){
		if(i==arr.length)
			return;
		else if(j==arr.length)
			findNum(arr,i+1,i+1,target);
		else{
			int sum=0;
			for(int k=i;k<=j;k++){
				sum+=arr[k];
			}
			if(sum==target){
				for(int k=i;k<=j;k++){
					System.out.print(arr[k]+"  ");
				}
				System.out.println();
			}
			findNum(arr,i,j+1,target);
		}
	}
	public static void main(String [] args){
		int[] arr={0,1,2,3,4,1,5,0,6,-1};

		findNum(arr,0,0,5);

	}
}