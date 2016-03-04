package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListsPractice {

	List<Integer> al_numbers = Arrays.asList(9, 0 ,-1 ,4,90 -100);
	
	public void forEachListOfNumbers()
	{
		Collections.sort(al_numbers);
		 
		System.out.println("For each");
		
		for(Object obj : al_numbers)
		{
			System.out.println("Item: "+ obj + " at "+ al_numbers.indexOf(obj));
		}
	}
	
	public void whileIteratorListOfNumbers()
	{
		System.out.println("Iterator while");
		
		Iterator<Integer> iterator = al_numbers.iterator();
		
		while (iterator.hasNext())
		{
			Object obj = iterator.next();
			System.out.println("Item: "+ obj + " at "+ al_numbers.indexOf(obj));
		}
		
	}
	
	public void forIteratorListOfNumbers()
	{
		System.out.println("Iterator For loop");
		
		for(Iterator<Integer> itr = al_numbers.iterator(); itr.hasNext();)
		{
			int intValue = itr.next();
			System.out.println("Item: "+ intValue + " at "+ al_numbers.indexOf(intValue));
		}
	}
	
	public void duplicateElements(){
		
		List<Integer> numbers = new ArrayList(); 
		numbers.add(1);
		numbers.add(2);
		numbers.add(2);
		numbers.add(4);
		int index = 0;
		
		/*for(int value: numbers)
		{
			if(numbers.inde xOf(value) != numbers.lastIndexOf(value))
			{
				int index = numbers.lastIndexOf(value);
				numbers.remove(index);
				numbers.add(value);
			}
			System.out.println(value);
		}*/
		
		while(index < numbers.size()){
			
			int value = numbers.get(index);
			int lastindex = 0;
			
			if(numbers.indexOf(value) != numbers.lastIndexOf(value))
			{
				lastindex = numbers.lastIndexOf(value);
				numbers.remove(lastindex);
				numbers.add(value);
			}
			System.out.println(value);
			
			index ++;
		}
	}
}
