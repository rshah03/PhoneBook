import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.table.*;

public class FrontEndUI extends JFrame implements ActionListener {
	
	JFrame mainFrame;
	JPanel mainPanel;
	JButton view;
	JButton search;
	JButton delete;
	JButton add;	
	JButton exit;
	JScrollPane scroller;
	File fileInFrontEnd;
	
	public FrontEndUI(String title, File f) {
		
		super(title);
		fileInFrontEnd = f;
		mainFrame = new JFrame();
		mainPanel = new JPanel();
		view = new JButton("View Indexes");
		search = new JButton("Search Indexes");
		delete = new JButton("Delete Indexes");
		add = new JButton("Add Indexes");
		exit = new JButton("Quit");
		scroller = new JScrollPane();
		
		
		view.addActionListener(this);
		search.addActionListener(this);
		delete.addActionListener(this);
		add.addActionListener(this);
		exit.addActionListener(this);
		
		GridLayout grid = new GridLayout(3,2,10,10);
		setLayout(grid);
//		add(view);
		add(search);
		add(delete);
		add(add);
		add(exit);
		
		
	    
		//Table with File contents read into it -- Provides a convenient visual display of the phonebook for the user. 
		//Make sure isCellEditable is set to false for all instances.
		String columns[] =  {  "Name", "Age", "Email Address", "Cell Number"  };
		JTable contactTable = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
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
	    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	    contactTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
	    contactTable.getTableHeader().setDefaultRenderer(centerRenderer);
	    contactTable.setDefaultRenderer(String.class, centerRenderer);
	    
	    
		//Read contents from file and display them in table (File -> JTable)
		String line;
	    BufferedReader reader;
	    try {       
	        
	    	reader = new BufferedReader(new FileReader(fileInFrontEnd));

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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Add Indexes")) {
			repaint();
			addIndexes addToFile = new addIndexes("Add Indexes", fileInFrontEnd);
		}
		
		if(e.getActionCommand().equals("Quit")) {
			System.exit(0);
		}
	}
	
	
}
