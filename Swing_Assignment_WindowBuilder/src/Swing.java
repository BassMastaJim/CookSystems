package cookSystemsSwing;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Swing implements  ActionListener {

	private JFrame frame;
	private JComboBox<?> comboBox;
	private JTextField textBox;
	private JScrollPane topRightScrollPane, topLeftScrollPane, bottomScrollPane;
	private JLabel statusLabel;
	private MouseListener mouseListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing window = new Swing();
					//Set the window to be visible only after it has been fully completed
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Swing() {
		initialize(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Swing window) {
		frame = new JFrame("James Winter Swing Assignment");
		
		//Create configuration, layout and operation of ComboBox
		
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.setContentPane(window.createContentPane());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();  
	}
	
    /**
     * Create the mainpanel to hold all of the remaining swing elements
     * @return JPanel
     */
	private JPanel createContentPane() {
		//Create a JPanel for the GridBagLayout
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		
		//Create the GridBagConstraintsObject
		GridBagConstraints c = new GridBagConstraints();
		
		//Create the starting position for the widget ComboBox
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
				
		//Create the ComboBox
		createComboBox();
		
		//Add the widget comboBox to the mainPanel
		mainPanel.add(comboBox, c);
		
		//Create the textBox
		textBox = new JTextField("TextBox");
		textBox.setSize(100, 30);

		
		//Add the widget textBox to the mainPanel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 0;
		mainPanel.add(textBox, c);
		
		//Create the lowered border
		Border loweredbevel = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED); 
		
		//Create the TopPanel portion and give the lists a border
		createTopPanel();
		topLeftScrollPane.setBorder(loweredbevel);
		topRightScrollPane.setBorder(loweredbevel);
		
		//Add the widget topRightList to the mainPanel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 4;
		c.weightx = 0.0;
		c.weighty = 0.5;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		mainPanel.add(topLeftScrollPane, c);
		
		//Add the widget topLeftList to the mainPanel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 4;
		c.weightx = 0.0;
		c.weighty = 0.5;
		c.gridwidth = 2;
		c.gridx = 2;
		c.gridy = 2;
		mainPanel.add(topRightScrollPane, c);
		
		//Create the BottomList Portion and give it a border
		createBottomPanel();
		bottomScrollPane.setBorder(loweredbevel);
		
		//Add the widget bottomList
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 4;
		c.weightx = 0.0;
		c.weighty = 0.5;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 4;
		mainPanel.add(bottomScrollPane, c);
		
		//Create the StatusLabel or Footer for the window
		statusLabel = new JLabel("Status Label");
		
		//Add the widget StatusLabel
		c.fill = GridBagConstraints.VERTICAL;
		c.ipady = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 6;
		mainPanel.add(statusLabel, c);
		
		mainPanel.setOpaque(true);
		return mainPanel;
	
	}

	/**
	 * Create the BottomPanel and the mouse event listeners
	 */
	private void createBottomPanel() {
		//Create the bottomPanel String array
		String[] bottomPanelContent = {"Bottom Panel", 
		   "Some content in the Bottom Panel", "More content", "Some more content", 
		   "Even more content", "Content till you drop", "Content like it's hot",
		   "More and more content", "More and more content", "More and more content",
		   "More and more content", "More and more content", "More and more content",
		   "More and more content", "More and more content", "More and more content",
		   "More and more content", "More and more content", "More and more content",
		   "More and more content", "More and more content", "More and more content",
		   "More and more content", "That's all for now folks"};

		//Create the bottomList
		final JList<String> bottomList = new JList<String>(bottomPanelContent);
		
		//Create the mouseListener for bottomList
		mouseListener = new MouseAdapter() {
	       public void mouseClicked(MouseEvent e) {
	          if (e.getClickCount() == 2) {
	             String itemSelected = (String) bottomList.getSelectedValue();
	       	     textBox.setText(itemSelected);
	       	     statusLabel.setText(itemSelected); 
	          }
	       }
	    };
		
		//Configure the bottomList
        bottomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bottomList.setAutoscrolls(true);
        
        //Add the mouse listener to bottomList
        bottomList.addMouseListener(mouseListener);
     
        //Create the bottomScrollPane container
        bottomScrollPane = new JScrollPane(bottomList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        								    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
	}

	/**
	 * Create the two top panels and mouse event listeners
	 */
	private void createTopPanel() {

		//Create the topLeftContent String Array
		String[] topLeftContent = {"Top Left", "Some content in the Top Left",
				   "More content", "Some more content", "Even more content",
				   "Content till you drop", "Content like it's hot", "More and more content",
				   "More and more content", "More and more content", "More and more content",
				   "More and more content", "More and more content", "More and more content",
				   "More and more content", "More and more content", "More and more content",
				   "More and more content", "More and more content", "More and more content",
				   "More and more content", "More and more content", "More and more content",
				   "That's all for now folks"};
		
		//Create a JList for the topLeft
		final JList<String> topLeftList = new JList<String>(topLeftContent);
		
		//Create the mouseListener for topLeftList
		mouseListener = new MouseAdapter() {
	       public void mouseClicked(MouseEvent e) {
	          if (e.getClickCount() == 2) {
	             String itemSelected = (String) topLeftList.getSelectedValue();
	       	     textBox.setText(itemSelected);
	       	     statusLabel.setText(itemSelected); 
	          }
	       }
	    };

	    //Configure the topLeftList
        topLeftList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        topLeftList.setAutoscrolls(true);
        
        //Add the mouse listener to topLeftList
        topLeftList.addMouseListener(mouseListener);
		
        //Create the topLeftScrollPane container
        topLeftScrollPane = new JScrollPane(topLeftList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
     								        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
		
		//Create the topRightContent String Array
        String[] topRightContent = {"Top Right", "Some content in the Top Right",
				   "More content", "Some more content", "Even more content",
				   "Content till you drop", "Content like it's hot", "More and more content",
				   "More and more content", "More and more content", "More and more content",
				   "More and more content", "More and more content", "More and more content",
				   "More and more content", "More and more content", "More and more content",
				   "More and more content", "More and more content", "More and more content",
				   "More and more content", "More and more content", "More and more content",
				   "That's all for now folks"};
		
		//Create a JList for the Top right
		final JList<String> topRightList = new JList<String>(topRightContent);
		
		//Create the mouseListener for topRightList
		mouseListener = new MouseAdapter() {
	       public void mouseClicked(MouseEvent e) {
	          if (e.getClickCount() == 2) {
	             String itemSelected = (String) topRightList.getSelectedValue();
	       	     textBox.setText(itemSelected);
	       	     statusLabel.setText(itemSelected); 
	          }
	       }
	    };

	    //Configure the topRightList
        topRightList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        topRightList.setAutoscrolls(true);
        
        //Add the mouse listener to topRightList
        topRightList.addMouseListener(mouseListener);

        //Create the topRightScrollPane container
        topRightScrollPane = new JScrollPane(topRightList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        								    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
	}

	/**
	 * Create the ComboBox
	 */
	public void createComboBox() {
		// create the combo box array
		String[] comboBoxContent = {"ComboBox Values", "Some content in the ComboBox",
		   "More content", "Some more content", "Even more content",
		   "Content till you drop", "Content like it's hot", "More and more content",
		   "More and more content", "More and more content", "More and more content",
		   "More and more content", "More and more content", "More and more content",
		   "More and more content", "More and more content", "More and more content",
		   "More and more content", "More and more content", "More and more content",
		   "More and more content", "More and more content", "More and more content",
		   "That's all for now folks"};

		//Create the combo box
		comboBox = new JComboBox<Object>(comboBoxContent);
		
		//Configure the combo box
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(this);
		
	}

	/**
	 * Tell the listener what to do for comboBox
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String itemSelected;
		
		//If from the comboBox change the textBox and statusLabel
		if(e.getSource() == comboBox) {
			itemSelected = comboBox.getSelectedItem().toString();
			textBox.setText(itemSelected);
			statusLabel.setText(itemSelected);
		}
	}
}