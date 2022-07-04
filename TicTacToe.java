/**
 * Author: Kareem Idris, S#: 0881393, Ultimate esquire 
 * Program: TicTacToe.java
 * Purpose:  
 * Date: Jul 3, 2022
 */


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener{
	
	//instance of the random class
	Random rand = new Random();
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel(); //panel to hold our buttons
	JLabel messageLabel = new JLabel(); //label for messages/text
	JButton[] buttons = new JButton[9]; //we need an array of jbuttons here
	boolean playerTurn;//whos turn?
	
	//constructor
	TicTacToe(){
		
		//set the frame settings
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		//the text field settings
		messageLabel.setBackground(new Color(20,20,20));
		messageLabel.setForeground(Color.green);
		messageLabel.setFont(new Font("Ink Free", Font.ROMAN_BASELINE,75));//font and its size
		messageLabel.setHorizontalAlignment(JLabel.CENTER); //center the text
		messageLabel.setText("Tic-Tac-Toe");
		messageLabel.setOpaque(true);
		
		
		//the title
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0,0,800,100);
		
		buttonPanel.setLayout(new GridLayout(3,3)); // set the grid
		buttonPanel.setBackground(new Color(150,35,235));
		
		//for each button we want a new buttons, then add to panel
		for(int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("SansSerif Bold", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);//if clicked
		}
		
		
		
		titlePanel.add(messageLabel);
		titlePanel.setFocusable(false);
		
		
		frame.add(titlePanel, BorderLayout.NORTH);
		
		frame.add(buttonPanel);
		
		//make a rand first turn
		firstTurn();
		
	}//end ttt constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		// this will run 9 times for each button clicked
		for (int i = 0; i < 9; i++) {
			if(e.getSource() == buttons[i]) {
				if(playerTurn) {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255,0,0));//set to blue
						buttons[i].setText("X");
						playerTurn = false; //first player turn is over
						messageLabel.setText("O's Turn");
						check();
					}
				}
				else {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0,0,255));//set to blue
						buttons[i].setText("O");
						playerTurn = true; //first player turn is on
						messageLabel.setText("X's Turn");
						check();
					}
				}//end else
				
			}
		}
		
	}// end action preformed
	
	public void firstTurn() {
		
		//set thread to a timer("sleep"), so that our title shows for 2 secs
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//make the first turn random
		if(rand.nextInt(2)==0) {
			playerTurn = true;
			messageLabel.setText("X's turn");
		}
		else {
			playerTurn = false;
			messageLabel.setText("O's turn");
		}
		
	}//end FirstTurn
	
	//check to see who wins
	public void check() {
		//we need to check if 3 buttons in a row have
		//text that matches
		
		//check if x wins
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) 
		{
			xWins(0,1,2);
			
		}
		if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) 
		{
			xWins(3,4,5);	
		}
		if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) 
		{
			xWins(6,7,8);	
		}
		if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) 
		{
			xWins(0,3,6);	
		}
		if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) 
		{
			xWins(1,4,7);	
		}
		if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) 
		{
			xWins(2,5,8);	
		}
		if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) 
		{
			xWins(0,4,8);	
		}
		if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) 
		{
			xWins(2,4,6);	
		}
		//end x check
		
		//check if o wins
		if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) 
		{
			oWins(0,1,2);
			
		}
		if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) 
		{
			oWins(3,4,5);	
		}
		if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) 
		{
			oWins(6,7,8);	
		}
		if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) 
		{
			oWins(0,3,6);	
		}
		if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) 
		{
			oWins(1,4,7);	
		}
		if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) 
		{
			oWins(2,5,8);	
		}
		if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) 
		{
			oWins(0,4,8);	
		}
		if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) 
		{
			oWins(2,4,6);	
		}
	}//end check
	
	//this one is for x wins
	public void xWins(int a, int b, int c) {
		//indicate if player 1 has won
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		//disable all buttons
		for(int i=0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		messageLabel.setText("X WINS!");
	}
	//this one is for o wins
	public void oWins(int a, int b, int c) {
		//indicate if player 1 has won
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		//disable all buttons
		for(int i=0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		messageLabel.setText("O WINS!");
	}
	
	
}
