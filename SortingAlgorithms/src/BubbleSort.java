
public class BubbleSort {

	public static void main(String[] args) {
		int[] ar_unsorted = {4,7,92,58,89,38,35,90,2,5};
		
		for(int i=0; i< ar_unsorted.length-1 ;i++){
			for(int j=0; j < ar_unsorted.length-1-i; j++){
				if(ar_unsorted[j] > ar_unsorted[j+1]){
					int temp = ar_unsorted[j+1];
					ar_unsorted[j+1] = ar_unsorted[j];
					ar_unsorted[j] = temp;
				}
			}
		}
		for(int i=0;i<ar_unsorted.length-1;i++){
			System.out.println("position at: "+i + " value is: "+ar_unsorted[i]);
		}
	}

}
