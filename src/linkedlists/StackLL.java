package LinkedLists;

import java.util.Scanner;

import LinkedLists.LinkedList;

public class StackLL {
	public static void main(String...args){
		
		Node top,np,last = null;
		top =null;
		System.out.println("Please enter a number");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n != 0){
			np = new Node(n);
			np.next = top;
			top = np;
			n = in.nextInt();
		}
		System.out.println("Elements in the linked lists are : ");
		printf(top);
		top = top.next;
		printf(top);
		
	}
	public static void printf(Node top){
		while(top != null){
			System.out.print(top.data +" ");
			top = top.next; 
		}
		System.out.println();
	}
}
