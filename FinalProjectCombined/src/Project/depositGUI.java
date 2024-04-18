//package Project;
package Project;

import javax.swing.*;

//import Project.ProfilePageGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class depositGUI extends JFrame{
	private JLabel balanceLabel;
	
	public  depositGUI() {
		
		// Set up the JFrame for Account Balance
        setTitle("Account Balance");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
		
        // Create and add components for entering account number
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        
        balanceLabel = new JLabel("Account Balance");
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(balanceLabel);
        
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		//
        	}
        });
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	    //new AccountGUI(username); // Open the profile page
        		
        	}
        });
        
        
        panel.add(submitButton);
        panel.add(backButton);

        add(panel, BorderLayout.CENTER);
          
     // Display the JFrame
        setVisible(true); 
	}
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new depositGUI();
	            }
	        });
	    }
	}
