package collections;

import org.junit.Test;

public class ArrayListsPracticeTest {

	@Test
	public void ArrayListsPracticetest(){
		
		ArrayListsPractice  arraylist = new ArrayListsPractice();
		
/*		arraylist.forIteratorListOfNumbers();
		System.out.println();
		arraylist.whileIteratorListOfNumbers();
*/		
		arraylist.duplicateElements();
		System.out.println();
		//arraylist.forEachListOfNumbers();
	}
	
	@Test
	public void Queuell(){
		
		QueueLL queuell = new QueueLL();
		
		queuell.queueLinkedList();
		queuell.stackLinkedList();
	}
	
	@Test
	public void comparatorArrays()
	{
		ComparableNode cn = new ComparableNode();
		cn.addElements();
	}
}
 	 