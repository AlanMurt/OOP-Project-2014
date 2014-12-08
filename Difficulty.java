//Difficulty.java
import java.io.*;

public class Difficulty implements Serializable{
	private String difficulty;
	
	//Constructor method
	public Difficulty(String difficulty) {
				setDifficulty(difficulty);
	}
	
	// No argument Constructor
	public Difficulty() {
				this("easy");
	}
	
	//Accessor method
	public String getDifficulty() { 
		return difficulty;
	}
	
	//Mutator methods
	public void setDifficulty(String difficulty) {
				this.difficulty = difficulty;
	}
	
	
	//toString method for output
	
	public String toString() {
				return "Difficulty: " + getDifficulty();
	}
}