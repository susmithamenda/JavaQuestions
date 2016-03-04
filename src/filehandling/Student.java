package filehandling;

import java.io.Serializable;

public class Student implements Serializable{

	private String name;
	private double score;
	
	Student(String name, double score){
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	@Override
	public String toString(){
		
		return "Student --> name: "+ name + " --- score: "+ score;
	}
	
	
}
