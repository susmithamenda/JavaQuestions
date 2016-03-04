package LinkedLists;

public class Node implements Comparable{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public int compareTo(Object obj){
		Node node = (Node) obj;
		if(this.getData() > node.getData())
		{
			return 1;
		}
		else if(this.getData() < node.getData()){
			return -1;
		}
		else{
			return (this.getData() - node.getData());
		}
	}
}