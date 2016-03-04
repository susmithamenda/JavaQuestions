
public class Queue {
	private int front;
	private int rear;
	private int[] list;
	private int maxSize;
	
	Queue(int maxSize){
		this.maxSize = maxSize;
		list = new int[maxSize];
		front = rear = -1;
	}
	public void enqueue(int entry){
		if ((front == maxSize) && (rear == maxSize)){
			front = rear = -1;
		}else if(front != maxSize){
			list[++front] = entry;
		}
		System.out.println("Entry "+ entry +" inserted at : " + front);
	}
	public int dequeue(){
		if ((front == maxSize) && (rear == maxSize)){
			front = rear =-1;
		}else if(rear < maxSize){
			return list[++rear];
		}
		return -1;
	}
	public void print(){
		for(int i = 0; i < maxSize ; i++){
			System.out.print(" a["+i+"]: " + list[i] + ",");
		}
	}
	
	public static void main(String agr[]){
		Queue queue = new Queue(10);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		int dequeueItem  = queue.dequeue();
		System.out.println("Entry deleted at : " + dequeueItem);
		queue.print();
	}
}
