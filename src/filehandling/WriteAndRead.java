package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteAndRead {

	//writes to the file
	public void write(String str){
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Susmitha\\Desktop\\filehandling.txt", true));
			bw.write(str);
			bw.close();
		}
		catch(IOException io)
		{
			Logger.getLogger(WriteAndRead.class.getName()).log(Level.SEVERE, null, io);
		}
	}

	//writing object to a file
	public void writeStudents(ArrayList<Student> students){

		try
		{
			FileOutputStream fo = new FileOutputStream("C:\\Users\\Susmitha\\Desktop\\objectfilestore.txt");
			ObjectOutputStream output = new ObjectOutputStream(fo);
			

			for(Student s : students){

				output.writeObject(s);
			}	
			output.close();
			fo.close();
		}
		catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
		}
		catch(IOException io){
			io.printStackTrace();
		}
	}

	//reads from the file
	public void read(){

		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Susmitha\\Desktop\\filehandling.txt"));
			String s = "";

			while((s = br.readLine()) !=  null){
				System.out.println(s);
			}
			br.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void readStudentObjects(){

		ArrayList<Student> students = new ArrayList<Student>();

		try 
		{
			FileInputStream  fi = new FileInputStream("C:\\Users\\Susmitha\\Desktop\\objectfilestore.txt");
			ObjectInputStream input = new ObjectInputStream(fi);

			try
			{
				while(true)
				{

					Student s = (Student) input.readObject();
					students.add(s);
					
				}
			}
			catch(EOFException eof)
			{
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}

		} 
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		for(Student s : students)
		{

			System.out.println(s);
		}

	}
}
