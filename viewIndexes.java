import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.table.*;


public class viewIndexes extends JFrame implements ActionListener {

	JFrame mainFrame;
	JPanel mainPanel;
	JScrollPane scroller;
	JButton back;
	
	public viewIndexes(String title, File f) { 
		
		super(title);
		mainFrame = new JFrame();
		mainPanel = new JPanel();
		scroller = new JScrollPane();
		back = new JButton("Back");
		
		back.addActionListener(this);
		
		setLayout(new FlowLayout());
		add(back);
		//Table with File contents read into it -- Provides a convenient visual display of the phonebook for the user. 
		//Make sure isCellEditable is set to false for all instances.
		String columns[] =  {  "Name", "Age", "Email Address", "Cell Number"  };
		JTable contactTable = new JTable() {
			
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    
	    DefaultTableModel tableModel;
	   
	    // table with 4 columns
	    tableModel = new DefaultTableModel(0,4);
	    tableModel.setColumnIdentifiers(columns);
	    contactTable.setModel(tableModel);
	    
	    //Place the JTable into a JScrollPane's viewport. You can do this by passing the JTable into the JScrollPane's constructor, 
	    //or by calling setViewportView(...) on the JScrollPane and passing in the JTable.
	    //Then place the JScrollPane, not the JTable, into your GUI.
		scroller.setViewportView(contactTable);
	    add(scroller);
		
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	    contactTable.getTableHeader().setDefaultRenderer(centerRenderer);
	    contactTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
	    
		//Read contents from file and display them in table (File -> JTable)
		String line;
	    BufferedReader reader;
	    try {       
	        
	    	reader = new BufferedReader(new FileReader(f));

	        while((line = reader.readLine()) != null) { //this gives me an error???
	        
	           tableModel.addRow(line.split(", ")); //this has a comma and a space bc that                        is how the file is written to
	        }
	        reader.close();
	     }
	    catch(IOException e) {
	        JOptionPane.showMessageDialog(null, "Buffered Reader issue.");
	    }
	    
		mainFrame.add(mainPanel);
		this.setSize(1100,300);
		this.setVisible(true);
		getContentPane().setBackground(new Color(0, 0, 0, 0));
		((JComponent) getContentPane()).setOpaque(false);
		setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}		

	
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
