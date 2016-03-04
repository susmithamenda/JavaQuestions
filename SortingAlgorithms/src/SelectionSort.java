
public class SelectionSort {

	public static void main(String args[]){
		int[] ar_unsorted = {4,7,92,58,89,38,35,89,2,5};
		int min;
		
		for(int i=0; i<ar_unsorted.length-1; i++){
			min=i;
			for(int j = i+1; j<ar_unsorted.length-1;j++){
				if(ar_unsorted[j] < ar_unsorted[min])
					min = j;
			}
			if(ar_unsorted[i] > ar_unsorted[min]){
				int temp = ar_unsorted[i];
				ar_unsorted[i] = ar_unsorted[min];
				ar_unsorted[min] = temp;
			}
		}
		for(int i=0;i<ar_unsorted.length-1;i++){
			System.out.println("position at: "+i + " value is: "+ar_unsorted[i]);
		}
		
	}
	
}
