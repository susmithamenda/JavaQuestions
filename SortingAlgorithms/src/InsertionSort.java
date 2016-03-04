import java.util.Arrays;


public class InsertionSort {
	public static void main(String args[]){
		int[] a = {13,19,9,5,12,8,7,4,21,2,6,11};	
		
		for(int i = 1; i < a.length ;i++){
			int key = a[i];
			int j = i-1;
			while(j >= 0 && a[j] > key){
				a[j+1] = a[j];
				j=j-1;
			}
			a[j+1] = key;
		}
		
		System.out.println(Arrays.toString(a));
	}
}
