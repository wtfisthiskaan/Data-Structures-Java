import java.util.*;
public class Main{
    /** mergeSort function
     * 
     * @param arr is array to be sorted.
     * @param l is head
     * @param r is tail
     * 
     * */
    public static void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
                    int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
  
       
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        }
    }
        /** swap helper function
     * 
     * @param arr is array to be sorted.
     * @param l is head
     * @param r is tail
     * 
     * */
    static void swap(int[] arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
    /** partition function
     * 
     * @param arr is array to be sorted.
     * @param head is head
     * @param tail is tail
     * 
     * */
static int partition(int[] arr, int head, int tail)
{
    int pivot = arr[tail];
    int i = (head - 1);
 
    for(int j = head; j <= tail - 1; j++)
    {
        if (arr[j] < pivot)
        {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, tail);
    return (i + 1);
}
     /** quickSort function
     * 
     * @param arr is array to be sorted.
     * @param head is head
     * @param tail is tail
     * 
     * */
static void quickSort(int[] arr, int head, int tail)
{
    if (head < tail)
    {
        int pi = partition(arr, head, tail);
        quickSort(arr, head, pi - 1);
        quickSort(arr, pi + 1, tail);
    }
}
     /** printArray function
     * 
     * @param arr is array to be printed.

     * 
     * */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

     /** min_max_finder function
     * 
     * @param arr is array to be finded min and max.
     * @param head is head
     * @param tail is tail
     * @return array of indices min and max of borders in array.
     * */
 public static int[] min_max_finder(int arr[], int head, int tail)
  {
    int[] result=new int[2]; 
    int[] left=new int[2]; 
    int[] right=new int[2];
    int mid;
    if (head == tail)
      {
          result[0] =head;
          result[1] = head;   
          return result;
      } 
    if (tail == head + 1)
      {  
         if (arr[head] > arr[tail]) 
      {
          	result[0] = head;
          	result[1] = tail;
      } 
    else
      {
          	result[0] = tail;
          	result[1] = head;
      } 
    return result;
   }
   mid = (head + tail)/2; 
   left = min_max_finder(arr, head, mid);
   right = min_max_finder(arr, mid+1, tail); 
   if (arr[left[1]] < arr[right[1]]){
    	result[1] = left[1];
   }
        
   else{   
	    result[1] = right[1]; 
   }

  if (arr[left[0]] >arr[right[0]]){
       result[0] = left[0];
   }
  else{
       result[0] = right[0];     
 }    
   
  return result;
 }


   public static int[] new_sort(int[] array,int head,int tail){
    	if(head>tail)
    		return array;
    	else{
    		int[] a=min_max_finder(array,head,tail);
    		//a[0]=max a[1]=min
    		int temp;
    		/*first swap*/
    		temp=array[head];
    		array[head]=array[a[1]];
    		array[a[1]]=temp;


    		/*second swap*/
    		temp=array[tail];
    		array[tail]=array[a[0]];
    		array[a[0]]=temp;

    		return new_sort(array,head+1,tail-1);
    	}
    }
  

	public static void main(String args[]){

		/*------------SIZE 100--------------------*/
		int[][] randomArr=new int[1000][100];
		int[][] quickRandomArr=new int[1000][100];
		int[][] mergeRandomArr=new int[1000][100];
		int int_random;
		for(int i = 0;i < 1000;i++){
			for(int j = 0;j < 100; j++){
				Random rand = new Random(); 
      			int_random = rand.nextInt();
      			randomArr[i][j]=int_random;
			}
		}
		quickRandomArr=randomArr;
		mergeRandomArr=randomArr;
		long mergeStartTime1 = System.nanoTime();
		for(int i = 0;i < 1000;i++){
			mergeSort(mergeRandomArr[i],0,mergeRandomArr[i].length-1);
		}
		long mergeStopTime1 = System.nanoTime();
		System.out.println("MergeSort with size 100 Average time: "+((mergeStopTime1-mergeStartTime1)/1000));
		long quickStartTime1 = System.nanoTime();
		for(int i = 0;i < 1000;i++){
			quickSort(quickRandomArr[i],0,quickRandomArr[i].length-1);
		}
		long quickStopTime1 = System.nanoTime();
		System.out.println("QuickSort with size 100 Average time: "+((quickStopTime1-quickStartTime1)/1000));
		long newStartTime1 = System.nanoTime();
		for(int i = 0;i < 1000;i++){
			new_sort(randomArr[i],0,randomArr[i].length-1);
		}
		long newStopTime1 = System.nanoTime();
		System.out.println("NewSort with size 100 Average time: "+((newStopTime1-newStartTime1)/1000));


		/*------------SIZE 1000--------------------*/
		randomArr=new int[1000][1000];
		quickRandomArr=new int[1000][1000];
		mergeRandomArr=new int[1000][1000];
		for(int i = 0;i < 1000;i++){
			for(int j = 0;j < 1000; j++){
				Random rand = new Random(); 
      			int_random = rand.nextInt();
      			randomArr[i][j]=int_random;
			}
		}
		quickRandomArr=randomArr;
		mergeRandomArr=randomArr;
		 mergeStartTime1 = System.nanoTime();
		for(int i = 0;i < 1000;i++){
			mergeSort(mergeRandomArr[i],0,mergeRandomArr[i].length-1);
		}
		mergeStopTime1 = System.nanoTime();
		System.out.println("MergeSort with size 1000 Average time: "+((mergeStopTime1-mergeStartTime1)/1000));
		quickStartTime1 = System.nanoTime();
		for(int i = 0;i < 1000;i++){
			quickSort(quickRandomArr[i],0,quickRandomArr[i].length-1);
		}
		 quickStopTime1 = System.nanoTime();
		System.out.println("QuickSort with size 1000 Average time: "+((quickStopTime1-quickStartTime1)/1000));
		 newStartTime1 = System.nanoTime();
		for(int i = 0;i < 1000;i++){
			new_sort(randomArr[i],0,randomArr[i].length-1);
		}
		 newStopTime1 = System.nanoTime();
		System.out.println("NewSort with size 1000 Average time: "+((newStopTime1-newStartTime1)/1000));





		/*------------SIZE 10000--------------------*/
		randomArr=new int[1000][10000];
		quickRandomArr=new int[1000][10000];
		mergeRandomArr=new int[1000][10000];
		for(int i = 0;i < 1000;i++){
			for(int j = 0;j < 10000; j++){
				Random rand = new Random(); 
      			int_random = rand.nextInt();
      			randomArr[i][j]=int_random;
			}
		}
		quickRandomArr=randomArr;
		mergeRandomArr=randomArr;
		 mergeStartTime1 = System.nanoTime();
		for(int i = 0;i < 1000;i++){
			mergeSort(mergeRandomArr[i],0,mergeRandomArr[i].length-1);
		}
		mergeStopTime1 = System.nanoTime();
		System.out.println("MergeSort with size 10000 Average time: "+((mergeStopTime1-mergeStartTime1)/1000));
		quickStartTime1 = System.nanoTime();
		for(int i = 0;i < 1000;i++){
			quickSort(quickRandomArr[i],0,quickRandomArr[i].length-1);
		}
		 quickStopTime1 = System.nanoTime();
		System.out.println("QuickSort with size 10000 Average time: "+((quickStopTime1-quickStartTime1)/1000));
		 newStartTime1 = System.nanoTime();
		for(int i = 0;i < 1000;i++){
			new_sort(randomArr[i],0,randomArr[i].length-1);
		}
		 newStopTime1 = System.nanoTime();
		System.out.println("NewSort with size 10000 Average time: "+((newStopTime1-newStartTime1)/1000));
		
	}
}