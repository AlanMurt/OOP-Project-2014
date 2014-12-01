//ButtonChaser

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class ButtonChaser extends JFrame implements ActionListener{
	
	//Menues
	JMenu buttonMenu;
	JMenu personMenu;
	
	//Labels
	JLabel response;
	JLabel backgroundPic1 = new JLabel(new ImageIcon("Reaction Test.jpg"));
	JLabel backgroundPic2 = new JLabel(new ImageIcon("pic2.png"));
	
	//Button
	JButton randomButton;
	
	public static void main(String args[]){
		
	//Creating frame 
	ButtonChaser frame = new ButtonChaser();
	frame.setVisible(true);	
	

	}
		
		public ButtonChaser(){
			//Setting frame properties
			setTitle("How fast are your hands?");
			setSize(1000,800);
			setLocation(400,300);			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			Container container = getContentPane();
			container.setLayout(new FlowLayout());
			
			//Creating Button 
			randomButton = new JButton("I'm over here");
			randomButton.setVisible(false);
			randomButton.addActionListener(new ButtonListener());
			container.add(randomButton);
			
			//Background Pictures
			container.add(backgroundPic1);
			backgroundPic1.setVisible(true);
			
			//Background Color "New Game"

			
			
			//Creating Menu
			createButtonMenu();
			createPersonMenu();
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			menuBar.add(buttonMenu);
			menuBar.add(personMenu);
			
			
			//Menu response
			response = new JLabel("Welcome to The Button Chaser - How quick are your responses?");
			response.setSize(250,50);
			container.add(response);
			
			//Text Color as white
			response.setForeground(Color.white);
					
	}
		
		public void actionPerformed(ActionEvent e){
			String menuName;
			menuName = e.getActionCommand();
			
			if(menuName.equals("New Game")){
				
				//Button to click appears 
				randomButton.setVisible(true);	
					
				//Welcome message dissapears
				response.setVisible(false);
				
				//My reaction Test picture dissapears
				backgroundPic1.setVisible(false);
				
				//container.setBackground(Color.red);
			//	if(randomButton.)
				
				
			}
			else if(menuName.equals("Delete high scores")){
				response.setText(menuName + ": are currently under construction");
			}
			else if(menuName.equals("Quit")){
				//response.setDefaultCloseOperation( EXIT_ON_CLOSE);
			}
			
			if(menuName.equals("New Account")){
				JOptionPane.showMessageDialog(null,"Please enter you details in the message box's");
				
				Person p1 = new Person();
				
				p1.setName(JOptionPane.showInputDialog("Enter you name: "));
				p1.setAge(Integer.parseInt(JOptionPane.showInputDialog("Enter you age: ")));
				char p1Gender;
				p1Gender=(JOptionPane.showInputDialog("Enter you gender: ").charAt(0));
				p1.setGender(p1Gender);
				
				JOptionPane.showMessageDialog(null,p1.toString());
			}
			else if(menuName.equals("Load Account")){
			}
		} 
			
		private void createButtonMenu(){
			JMenuItem item;
			buttonMenu = new JMenu("File");
			
			item = new JMenuItem("New Game");
			item.addActionListener( this);
			buttonMenu.add(item);
			
			item = new JMenuItem("Reset High Scores");
			item.addActionListener(this);
			buttonMenu.add(item);
			
			buttonMenu.addSeparator(); 
			
			item = new JMenuItem("Quit");
			item.addActionListener(this);
			buttonMenu.add(item);
		}
		
		private void createPersonMenu(){
			JMenuItem item1;
			personMenu = new JMenu("Account");
			
			item1 = new JMenuItem("New Account");
			item1.addActionListener(this);
			personMenu.add(item1);
			
			item1 = new JMenuItem("Load Account");
			item1.addActionListener(this);
			personMenu.add(item1);
			
		}
	
	private class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e)
	  	{
	  		//When the button is clicked the first time this puts the button in a random place on the screen
	  		//I got this code from program I made during lab sheet 4
	  		Random ran = new Random();
	  		
	  		for(int i=1;i<=10;i++){
	  		if(e.getSource()==randomButton){
	  			
	  			
	  			
	  			randomButton.setLocation(ran.nextInt(800),ran.nextInt(550));
	  			
	  		}
	  		}
	  	
	  			JOptionPane.showMessageDialog(null,"Well done, your time is ");
	  			randomButton.setVisible(false);
	  			
	  		
	  		
	  		
	  		
	  		}
	  		
	  	}
}

	
