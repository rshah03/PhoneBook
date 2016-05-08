import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;

import javax.swing.*;
import javax.swing.table.*;

public class deleteIndexes extends JFrame implements ActionListener {
	
	JFrame mainFrame;
	JPanel mainPanel;
	JButton delete;
	JLabel name, age, email, number;
	JTextField nameSub, ageSub, emailSub, numberSub;
	NumberFormat phoneNumber;
	File fileInAddIndexes;


	public deleteIndexes(String title, File f) { 
		
		super(title);
		mainFrame = new JFrame();
		mainPanel = new JPanel();
		fileInAddIndexes = f;
//--------------------------------------------------------------------------
		delete = new JButton("DELETE INDEX");
		name = new JLabel("               Name: ");
		age = new JLabel("                Age: ");
		email = new JLabel("              E-mail: ");
		number = new JLabel("             Preferred phone #: ");
//--------------------------------------------------------------------------
		nameSub = new JTextField(10);
		ageSub = new JTextField(10);
		emailSub = new JTextField(20);
		numberSub = new JTextField(10);
//--------------------------------------------------------------------------		
		phoneNumber = new DecimalFormat("(000)-000-0000");
		
		delete.addActionListener(this);
		GridLayout grid = new GridLayout(5,5,10,10);
		setLayout(grid);
		add(name);
		add(nameSub);
		add(age);
		add(ageSub);
		add(email);
		add(emailSub);
		add(number);
		add(numberSub);
		add(delete);
		
		mainFrame.add(mainPanel);
		this.setSize(500,215);
		this.setVisible(true);
		getContentPane().setBackground(new Color(0, 0, 0, 0));
		((JComponent) getContentPane()).setOpaque(false);
		setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("DELETE INDEX"))
		{
			String line;
			BufferedReader reader;
			
		}
	}
}