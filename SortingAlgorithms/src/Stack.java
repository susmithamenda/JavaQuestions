
public class Stack {
	private int maxSize;
	private int[] entry;
	public int top;
	
	Stack(int maxSize){
		this.maxSize = maxSize;
		entry = new int[maxSize];
		top = -1;
	}
	public void push(int pushItem){
		if(top <= maxSize){
			++top;
		entry[top] = pushItem;
		}
	}
	public int pop(){
		if(top > -1){
			return entry[top--];
		}
		return -1;
	}
	public void print(){
		for(int i =0; i < maxSize ; i++){
			System.out.print(" a["+i+"]: " + entry[i] + ",");
		}
	}
	
	public static void main(String args[]){
		Stack ages = new Stack(10);
		ages.push(10);
		ages.push(40);
		ages.push(50);
		ages.push(20);
		ages.print();
		System.out.println();
		ages.pop();
		ages.print();
	}
}
