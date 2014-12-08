//ButtonChaser


//--------------------------Importing packages ---------------------
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

//--------------------------Handler / Listener class ------------------------

public class ButtonChaser extends JFrame implements ActionListener{		//extends JFrame is for inheriting from a base class	********** implements ActionListener is for implementing an interface
	
	//Creating array list 
	 static ArrayList <Person> people = new ArrayList <Person>();
	
	//Menus
	//Creates the menu for starting a new game or quitting the program
	JMenu buttonMenu;	
	//Creates the menu for creating a user	
	JMenu personMenu;
	
	//Container
	Container container = getContentPane();			
	
	//Labels
	//Will respond to a particular action
	JLabel response; 		
	//Displays the picture I made in photoshop to the screen
	JLabel backgroundPic1 = new JLabel(new ImageIcon("Reaction Test.jpg")); 
	//Used to begin the for loop below after it is given the value "yes" in the buttonListener class
	static String buttonResponse;	
	
	Difficulty d = new Difficulty();
	//create person object
	Person p1 = new Person();
	//Button
	//Creates the button that will be displayed randomly on the screen
	static JButton randomButton;
	static JButton startButton;
	//Attributes for the random button times
	//t3 is going to be the length of time its takes in seconds to click the button 10 times
	//t2m is going to be the current time in milliseconds after the user clicks the button for the tenth time
	//t1m is going to be the current time in milliseconds after the user clicks the button for the first time
	static long t3=0, t2m=0, t1m=0;
	//This attribute will count how many time the user clicks the button so the program know when to come to a halt
	int count;
	//t1 and t2 are attributes of the GregorianCalendar class 
	GregorianCalendar t1, t2;
	
//--------------------------------Driver --------------------------------
	
	public static void main(String args[]){
		
	//Creating frame for the program to run on
	ButtonChaser frame = new ButtonChaser();	
	//Displays the frame on the screen
	frame.setVisible(true);
	
	
	open();	
	display();	
		
		
	} //End of driver
		

//--------------------------------Start of consructor --------------------------------	
		
		public ButtonChaser(){
			
			//Setting frame properties
			//String to be outputted at the very top of the program
			setTitle("How fast are your hands?");	
			//Size of the window	
			setSize(1000,800);
			//Sets the location of the window								
			setLocation(250,50);		
			//Exits the program when you click ont the "x"			
			setDefaultCloseOperation(EXIT_ON_CLOSE);	
			
			//Creates container for code	
			container.setLayout(new FlowLayout());
			
			//Creating Button 
			//Creates a button with a message
			randomButton = new JButton("I'm over here");
			//Hides the button ie. its not visible 	
			randomButton.setVisible(false);				
			//Allows a response to occur when a particular action happens	
			randomButton.addActionListener(new ButtonListener());	
			//Adds the button to the container
			container.add(randomButton);
			
			//Background Picture
			//Adds background picture to the container
			container.add(backgroundPic1);	
			//Displays the button on screen		
			backgroundPic1.setVisible(true);		

			//Creating Menues
			createButtonMenu();
			createPersonMenu();
			
			//Creates a menu bar to hold the menus button and person
			JMenuBar menuBar = new JMenuBar(); 
			//Sets the menu  bar on the frame
			setJMenuBar(menuBar);	
			//Adds button menu to the menu bar		
			menuBar.add(buttonMenu);
			//Adds person menu to the menu bar		
			menuBar.add(personMenu);
			//Sets the color of the menu bar
			menuBar.setBackground(Color.lightGray);		
			
			
			//Menu response
			//Sets a welcome message
			response = new JLabel("Welcome to The Button Chaser - How quick are your responses?");	
			//Sets the size of the j label 
			response.setSize(250,50);		
			container.add(response);
			response.setVisible(false);
			
			//Text Color as white
			response.setForeground(Color.white);
					
	}	// End of constructor

//-----------------------------Start Save/Load/Display -------------------------------
	//	Got this code from your sample "BicycleFrame4.java" on the X: drive
      /** writes the array of people to the file "people.dat"
       */   
      private void save() throws IOException {
      	ObjectOutputStream os;
      	os = new ObjectOutputStream(new FileOutputStream ("people.dat"));
      	os.writeObject(people);
      	os.close();
      }	//emnd save()
      
      /** loads an array of people from the file "people.dat"
       */  
      public static void open() {
      	try{
      	  ObjectInputStream is;
      	  is = new ObjectInputStream(new FileInputStream ("people.dat"));
          people  = (ArrayList<Person>) is.readObject(); 
      	  is.close();
      	}
      	catch(Exception e){
      		JOptionPane.showMessageDialog(null,"open didn't work");
      		e.printStackTrace();
      	}
      } // end open()
      
      
      //	Displays the array of people
      public static void display(){
      	JTextArea area = new JTextArea();
      	area.setEditable(false);
      	int numPeople = people.size();
      	if (numPeople>0) {
      	  area.setText("Person List: ");
      	  for (int i = 0; i<numPeople; i++) 
      	    area.append( people.get(i).toString()+"\n");
      	  JOptionPane.showMessageDialog(null,area);
      	}
      	else
      	    JOptionPane.showMessageDialog(null,"No people in the system");
      } // end display                       
//-----------------------------End of Save/Load/Display ----------------------------
		
//-----------------------------Action Performed class ****** Sets the response when a menu item is selected ----------------------------		
		
		//For a response to occcur if i click on a menu item
		public void actionPerformed(ActionEvent e){	
			//Variable to decide which menu item was clicked	
			String menuName;
			//Sets the variable any of the actions that can occur from the menu items							
			menuName = e.getActionCommand();			
			
			//If the menu clicked is called "New Game" do the following.....
			if(menuName.equals("New Game")){
				
				
				d.setDifficulty(JOptionPane.showInputDialog("Select your difficulty - (easy or hard)"));
				
				String diff = d.getDifficulty();
				
				if(diff.equals("easy")){
					//Sets the new size of the jbutton 
					randomButton.setPreferredSize(new Dimension(150, 50));
				}	//end of easy difficulty if statement
				else if(diff.equals("hard")){
					//Button remains default size
				}	//end of hard difficulty if statement
/*				while(!diff.equal("easy") || !diff.equal("hard")){
			
					JOptionPane.showMessageDialog(null,"Invalid input");
		
					//End of if d is not easy or hard	
			}	//end of while validation loop	*/
				backgroundPic1.setVisible(false);	
				//Button to click appears 
				randomButton.setVisible(true);	
				
				container.setBackground(Color.gray);
				randomButton.setBackground(Color.red);
				buttonMenu.setVisible(true);
				
			//	if(count==10){
			//		if(d.equals("easy")){
	  				
		//			} //End of if equals "easy" statement			
			//		}
					}	//End of "New Game" action event if statement
			
			//If the menu clicked is called "Quit" exit the program
			else if(menuName.equals("Quit")){
				//Exit message
				JOptionPane.showMessageDialog(null,"Come back to test your reactions again");
				//Exit program
      	 		System.exit(0);
			}	////End of "Quit" action event if statement
			
			//If the menu clicked is called "New Account" do the following.....
			if(menuName.equals("New Account")){
				JOptionPane.showMessageDialog(null,"Please answer the following questions");

				//Input attributes for person object
				p1.setName(JOptionPane.showInputDialog("Enter you name: "));
				p1.setAge(Integer.parseInt(JOptionPane.showInputDialog("Enter you age: ")));
				char p1Gender;
				p1Gender=(JOptionPane.showInputDialog("Enter you gender: ").charAt(0));
				p1.setGender(p1Gender);
				
				//Daniel O Sullivan helped me setup this try{} and catch{} exception 
				//*starts here *
				
				people.add(p1);
				try{
					save();
				}
				catch(IOException j){
					j.printStackTrace();
				}			
				//*ends here*
			
				//Output deatils just entered by the user and confirm
				JOptionPane.showMessageDialog(null,"The details you entered are as follows \n\n " + p1.toString(),"" ,JOptionPane.INFORMATION_MESSAGE);
								
				buttonMenu.setVisible(true);
				personMenu.setVisible(false);
			}	//End of "New Account" action event class
			
			else if(menuName.equals("Quit")){
				//Exit message
				JOptionPane.showMessageDialog(null,"Come back to test your reactions again");
				//Exit program
      	 		System.exit(0);
			}	////End of "Quit" action event if statement
			
		} //End of action performed class
		
		
		//Class makes the menu to hold the menu items	
		private void createButtonMenu(){
			//JMenuItem to create each menu item option
			JMenuItem item;
			//Creates Menu "Test"
			buttonMenu = new JMenu("Test");
			buttonMenu.setVisible(false);
			//Sets the background colour of the item
			buttonMenu.setBackground(Color.gray);
			
			//Creates menu item "New Game"
			item = new JMenuItem("New Game");
			//adds a listener to the menu item
			item.addActionListener( this);
			//Adds the menu item to the menu
			buttonMenu.add(item);
			//Sets the background colour of the item
			item.setBackground(Color.gray);
			
			//adds a seperator line on top of the quit menu item
			buttonMenu.addSeparator(); 
			
			//Creates the menu item "Quit"
			item = new JMenuItem("Quit");
			//Adds a listener to the menu item 
			item.addActionListener(this);
			//Adds the menu item to the menu
			buttonMenu.add(item);
			//Sets the background colour of the item
			item.setBackground(Color.lightGray);
		} 	//End of createButtonMenu class
		
		//Class makes the menu to hold the menu items
		private void createPersonMenu(){
			//JMenuItem to create each menu item option
			JMenuItem item1;
			//Creates Menu "Account"
			personMenu = new JMenu("Account");
			//Creates menu item "New Account"
			item1 = new JMenuItem("New Account");
			//Adds a listener to the menu item
			item1.addActionListener(this);
			//Adds the menu item to the menu
			personMenu.add(item1);
			//Sets the background colour of the item
			item1.setBackground(Color.gray);
			
			//adds a seperator line on top of the quit menu item
			personMenu.addSeparator();
			
			//Creates the menu item "Quit"
			item1 = new JMenuItem("Quit");
			//Adds a listener to the menu item 
			item1.addActionListener(this);
			//Adds the menu item to the menu
			personMenu.add(item1);
			//Sets the background colour of the item
			item1.setBackground(Color.lightGray);
			
		}	//End of createPersonMenuclass
	
//------------------------------ Listener class ------------------------------
	private class ButtonListener implements ActionListener {
		//--------- ActionPerformed class ----------
			public void actionPerformed(ActionEvent e)
	  	{
	  		
	  		//When the button is clicked the first time this puts the button in a random place on the screen		
	  		if(e.getSource().equals(randomButton)){
	  			
	  			//This if statement will get the current time in milliseconds when the user clicks the button for the first time 
	  			if(count==0){
	  				
	  				//Makes t1 an object of the GregorianCalendar class
	  				t1 = new GregorianCalendar();
	  				//method of the GregorianCalendar class to get current time in milliseconds
	  				t1m=t1.getTimeInMillis();
	  			} 	//End of if(count==0) if statement 
	  			
	  												
	  			Random ran = new Random();						//creates a random object to put the randomButton in a random place on the screen
																		
	  			randomButton.setLocation(ran.nextInt(800),ran.nextInt(550));	//Puts the buttton in a random place 
	  			//adds 1 to the count so the program knows when to halt the button appearing
	  			count++;
	  			
	  			//count until 10 so the program know when to stop
	  			if(count==10){
	  				//The button dissapears when the user has clicked the button 10 times
	  				randomButton.setVisible(false);
	  				//Makes t2 an object of the GregorianCalendar class
	  				t2 = new GregorianCalendar();
	  				//method of the GregorianCalendar class to get current time in milliseconds
	  				t2m=t2.getTimeInMillis();
	  				//Takes the time when the user clicked the button for the last time away from the time when the user clicked the button for the first time
	  				//To give me the length of time in milliseconds and convert it to seconds to see how long it took the user to click the button 10 times
	  				t3 = (t2m-t1m)/(1000);
	  				//outputs the time in seconds 
	  				JOptionPane.showMessageDialog(null,"Well done " + p1.getName() + ", it only took you " + t3 + " seconds");
	  				
	  				//I set these two values back to zero so that the raection test can be taken again without closing down first
	  				count=0;
	  				t3=0;
	  			} 	//End of if(count==10) if statement 
	  				  				
	  		}		//End of if you click the button class ie.(e.getSource().equals(randomButton))	
	  		}	//End of action performed class
	  	}		// End of Listener class
}		//End of buttonChaser class
	
