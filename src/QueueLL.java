package collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueLL {

	public void queueLinkedList()
	{
		Queue queue = new LinkedList();
		
		queue.add("One");
		queue.add("Two");
		queue.add("Three");
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}
	public void stackLinkedList()
	{
		Stack<String> stack = new Stack<String>();
		
		stack.add("One");
		stack.add("Two");
		stack.add("Three");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
