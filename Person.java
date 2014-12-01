//Person.java
import java.io.*;

public class Person implements Serializable{
	private String name;
	private int age;
	private char gender;
	private int highScore;
	
	// Constructor methods 
	
	// Four argument Constructor
	public Person(String name, int age, char gender, int highScore) {
				setName(name);
				setAge(age);
				setGender(gender);
				setHighScore(highScore);
	}
	
	// No argument Constructor
	public Person() {
				this("Unknown",0,'U',0);
	}
	
	//Accessor methods
	public String getName() { 
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public char getGender() { 
		return gender;
	}
	
	public int getHighScore() { 
		return highScore;
	}
	
	//Mutator methods
	public void setName( String name) {
				this.name = name;
	}
	
	public void setAge (int age) {
				this.age = age;
	}
	
	public void setGender(char gender) {
				this.gender = gender;
	}
	
	public void setHighScore (int highScore) {
				this.highScore = highScore;
	}
	
	//toString method for output
	
	public String toString() {
				return "--------------- Your Account Details --------------- \n\n\nName: " + getName() + "\nAge: " + getAge() + "\nGender: " + getGender()";
	}
}