package collections;

import java.util.Arrays;

import LinkedLists.Node;

public class ComparableNode {

	public void addElements()
	{
		Node node1 = new Node(10);
		Node node2 = new Node(20);
		Node node3 = new Node(90);
		Node node4 = new Node(40);
		Node node5 = new Node(5);
		
		Node[] nodes = new Node[5];
		nodes[0] = node1;
		nodes[1] = node2;
		nodes[2] = node3;
		nodes[3] = node4;
		nodes[4] = node5;
		
		for(Node node : nodes)
		{
			System.out.println(node.getData());
		}
		
		Arrays.sort(nodes);
		
		for(Node node : nodes)
		{
			System.out.println(node.getData());
		} 
	}
}
