package graphs;

import java.util.Scanner;

public class DijkstraAlgo {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int size = 5;
		int[] distance = new int[size];
		int[] visited = new int[size];
		int[][] matrix = new int[size][size];
		int[] preD = new int[size];
		int min;
		int nextNode = 0;
		
		System.out.println("Enter matrix");
		for(int i = 0; i < size ; i++){
			
			visited[i] = 0;
			preD[i] = 0;
			
			for(int j = 0; j < size; j++){
				
				matrix[i][j] = in.nextInt();
				
				if(matrix[i][j] == 0)
					matrix[i][j] = 999;
			}
		}
		distance = matrix[0];
		distance[0] = 0;
		visited[0] = 1;
		
		for( int i = 0; i < size; i++){
			
			min = 999;
			
			for(int j = 0; j < size; j++){
				
				if(min > distance[j] && visited[j] != 1){
					
					min = distance[j];
					nextNode = j;
					
				}
				
			}
			
			visited[nextNode] = 1;
			
			for(int c = 0; c < 5; c++){
				
				if(visited[c] != 1){
					
					if(min + matrix[nextNode][c] < distance[c]){
						
						distance[c] = min + matrix[nextNode][c];
						preD[c] = nextNode;
						
					}
					
				}
				
			}
			
		}
		for(int i =0; i < size ; i++){
			System.out.print("|"+ distance[i]);
		}
		System.out.print("|");
		
		//printing the path
		for(int  i =0; i < 5; i++){
			int j;
			System.out.println("Path = "+ i);
			j = i;
			
			do{
				j = preD[j];
				System.out.println(" <- " + j);
			}while(j != 0);
			
			System.out.println();
		}
	}
}
