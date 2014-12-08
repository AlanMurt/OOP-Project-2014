//Person.java
import java.io.*;

/**This is an instantiable Person class.
 @author Alan Moriarty
 @version 1.0 */ 
public class Person implements Serializable{
	
	//attributes
	private String name;
	private int age;
	private char gender;
	
	// Constructor methods 
	
	/**  Four argument constructor method
	 @param name, age and gender the name, age and gender of the person */
	public Person(String name, int age, char gender) {
				setName(name);
				setAge(age);
				setGender(gender);
	}
	
	/**  No argument constructor method
	 @No param for this person method */
	public Person() {
				this("Unknown",0,'U');
	}
	
	//Accessor methods
	/** acessor method to return the person name
	 *@return the name of the person */
	public String getName() { 
		return name;
	}
	
	/** acessor method to return the person age
	 *@return the age of the person */
	public int getAge() {
		return age;
	}
	/** acessor method to return the person gender
	 *@return the gender of the person */	
	public char getGender() { 
		return gender;
	}
	
	//Mutator methods
	/** mutator method to set the person name
	 *@param name the name of the person */
	public void setName( String name) {
				this.name = name;
	}
	
	/** mutator method to set the person age
	 *@param age the age of the person */
	public void setAge (int age) {
				this.age = age;
	}
	
	/** mutator method to set the person age
	 *@param age the age of the person */
	public void setGender(char gender) {
				this.gender = gender;
	}

	
	//toString method for output
	/** toString method to return the student details
	 *@return the name and status of the student as a string */
	public String toString() {
				return "\n\nName: " + getName() + "\nAge: " + getAge() + "\nGender: " + getGender();
	}
}


