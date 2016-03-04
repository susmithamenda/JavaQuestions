package LinkedLists;

import java.util.Scanner;

public class InsertAfterPostionLL {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		Node top,np, last = null, prev = null, curr = null;
		int size = 0;
		
		System.out.println("Enter enter a number");
		int n = in.nextInt();
		
		top = null;
		while(n != 0){
			np = new Node(n);
			if(top == null){
				top = np;
			}else{
				last.next = np;
			}
			last = np;
			n = in.nextInt();
		}
		/*System.out.println("The values are");
		while(top != null){
			System.out.print(top.data + " ");
			top = top.next;
		}
		System.out.println();*/
		
		System.out.println("Enter new value to be inserted");
		int newValue = in.nextInt();
		System.out.print("Enter the position to be inserted");
		int pos = in.nextInt();
		
		Node newNode;
		curr = top;
		while(curr != null){
			prev = curr;
			curr = curr.next;
			size++;
			if(size == pos){
				break;
			}
		}
		if(size == pos){
			newNode = new Node(newValue);
			newNode.next = curr;
			prev.next = newNode;
		}
		
		System.out.println("Enter new value to be delete");
		newValue = in.nextInt();
		
		curr = top;
		while( curr!= null && curr.data != newValue){
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
		
		System.out.println("The values are");
		while(top != null){
			System.out.print(top.data + " ");
			top = top.next;
		}
		System.out.println();
	}
}
