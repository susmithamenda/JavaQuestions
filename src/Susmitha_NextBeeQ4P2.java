
public class Susmitha_NextBeeQ4P2 {

	public static void main(String[] args){
		int[] input = {1, 3, 4, 1, 3, 6, 1, 9, 8, 3, 9, 8};

		for(int i=0; i< input.length; i++){
			for(int j=i+1; j< i+4 && j< input.length; j++){
				if(input[i] == input[j])
					System.out.println("Duplicate integer: " + input[i]);
			}
		}
	}
}
