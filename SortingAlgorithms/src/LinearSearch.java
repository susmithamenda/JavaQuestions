
public class LinearSearch {

	public static void main(String args[]){
		int[] ar_search = {4,7,92,58,89,38,35,90,2,5};
		int key = 36;
		
		for(int i =0; i < ar_search.length-1 ; i++){
			if(ar_search[i] == key){
				System.out.println("Element " + key + " found at position " + (i+1));
				break;
			}
		}
	}
}
