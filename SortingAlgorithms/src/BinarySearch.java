
public class BinarySearch {

	static int[] a = {2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 19, 21};

	public static void main(String[] args) {
		int index = find(13);
		System.out.println("Element found at: "+ (index+1));
	}
	public static int find(int element){
		
		int left = 0;
		int right = a.length-1;
		
		while(left <= right){
			int mid = (right+left)/2;
			if(element > a[mid]){
				left = mid+1;
			}else if(element < a[mid]){
				right = mid-1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}

}
