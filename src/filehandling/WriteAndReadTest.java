package filehandling;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class WriteAndReadTest {

	@Test
	public void writeTest(){
		/*ArrayList<Student> students = new ArrayList<Student>();
		
		students.add(new Student("steve", 2.0315));
		students.add(new Student("bob", 1.258));
		students.add(new Student("jason", 9.25));*/
		
		WriteAndRead wr = new WriteAndRead();
		
		//wr.write(" dummeis");
		
		wr.read();
		
		//wr.writeStudents(students);
		
		//wr.readStudentObjects();
	}
	
}
