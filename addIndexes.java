import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;

import javax.swing.*;
import javax.swing.table.*;

public class addIndexes extends JFrame implements ActionListener {
	
	JFrame mainFrame;
	JPanel mainPanel;
	JButton add;
	JLabel name, age, email, number;
	JTextField nameSub, ageSub, emailSub, numberSub;
	NumberFormat phoneNumber;
	File fileInAddIndexes;


	public addIndexes(String title, File f) { 
		
		super(title);
		mainFrame = new JFrame();
		mainPanel = new JPanel();
		fileInAddIndexes = f;
//--------------------------------------------------------------------------
		add = new JButton("ADD INDEX");
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
		
		add.addActionListener(this);
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
		add(add);
		
		mainFrame.add(mainPanel);
		this.setSize(500,215);
		this.setVisible(true);
		getContentPane().setBackground(new Color(0, 0, 0, 0));
		((JComponent) getContentPane()).setOpaque(false);
		setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("ADD INDEX")) {
			
			try {
				
				BufferedWriter toFile = new BufferedWriter(new FileWriter(fileInAddIndexes, true));
				toFile.write(nameSub.getText());
				toFile.write(", ");
				toFile.write(ageSub.getText());
				toFile.write(", ");
				toFile.write(emailSub.getText());
				toFile.write(", ");
				long num = Long.parseLong(numberSub.getText());
				toFile.write(phoneNumber.format(num) + "\n");
				//toFile.newLine();
				toFile.close();
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
			dispose();
			
			
		}
		
	}
	
	

}
