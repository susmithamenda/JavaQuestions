package LinkedLists;

import java.util.Scanner;

import LinkedLists.LinkedList;

public class QueueLL {
	public static void main(String...args){
		/*System.out.println("Please select an option");
		System.out.println("1.Add at first");
		System.out.println("2.Add at the end");
		System.out.println("3.Add at position");
		System.out.println("4.Remove from first");
		System.out.println("5.Remove from end");
		System.out.println("6.Remove at position");
		
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		System.out.println("option: "+option);*/
		Node top,np,last = null, prev = null, curr =null;
		top =null;
		System.out.println("Please enter a number");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n != 0){
			np = new Node(n);
			if(top == null)
				top = np;
			else{
				last.next = np;
			}
			last = np;
			n = in.nextInt();
		}
		System.out.println("Elements in the linked lists are : ");
		printf(top);
		curr = top;
		while(curr.next != null){
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
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
