
public class QuickSort {

	public static void main(String[] args) {
		int[] ar_unsorted = {13,19,9,5,12,8,7,4,21,2,6,11};	
		
		for(int i=0; i< ar_unsorted.length; i++){
			System.out.print(ar_unsorted[i] + ",");			
		}
		System.out.println();
		quicksort(ar_unsorted,0,ar_unsorted.length-1);
		
		for(int i=0; i< ar_unsorted.length; i++){
			System.out.print(ar_unsorted[i] + ",");			
		}
	}
	public static void quicksort(int[] ar_unsorted, int p, int r){
		
		if(p < r){
			int q = partition(ar_unsorted,p,r);
			quicksort(ar_unsorted,p,q-1);
			quicksort(ar_unsorted,q+1,r);
		}
	}
	
	public static int partition(int[] ar_unsorted, int p, int r){
		
		int pivot_element = ar_unsorted[r];
		int i= p-1;
		
		for(int j=p; j <= r-1; j++){
			if (ar_unsorted[j] <= pivot_element){
				i =i+1;
				swap(ar_unsorted, i, j);
			}
		}
		swap(ar_unsorted, i+1, r);
		/*for(int m=0; m< ar_unsorted.length-1; m++){
			System.out.print(ar_unsorted[m]+ " , ");			
		}
		System.out.println();
		System.out.println("i value: "+ i);*/
		
		return i+1;
	}
	public static void swap(int[] ar_unsorted , int i, int j){
		int temp = ar_unsorted[i];
		ar_unsorted[i]= ar_unsorted[j];
		ar_unsorted[j] = temp;
	}
	
	

}
