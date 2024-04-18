package Project;

import javax.swing.*;

import Project.Backend.CheckingAccount;
import Project.Backend.SavingsAccount;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountGUI extends JFrame {
    private JTextField accountNumberField;

    public AccountGUI(String filename, String accNum, String username) {
        // Set up the JFrame for entering account number
        setTitle("Account # " + accNum);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create and add components for entering account number
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));

        /*
        JLabel titleLabel = new JLabel("Enter Account Number:");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        accountNumberField = new JTextField();
        panel.add(accountNumberField)
         */
        
        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				try {
						new accountBalanceGUI(username, filename, accNum);
				} catch (IOException e1) {
						e1.printStackTrace();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				}
				dispose();
            }
        });
        panel.add(checkBalanceButton);
        
        JButton withdrawMoneyButton = new JButton("Withdraw Money");
        withdrawMoneyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               	new withdrawGUI();
            	dispose();
            }
        });
        panel.add(withdrawMoneyButton);     
        
        JButton depositMoneyButton = new JButton("Deposit Money");
        depositMoneyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               	new depositGUI();
            	dispose();
            }
        });
        panel.add(depositMoneyButton);        
        
        
        JButton transferMoneyButton = new JButton("Transfer Money");
        JButton closeAccountButton = new JButton("Close account");
        
        JButton goBackButton = new JButton("Go back");
        goBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // open the ProfilePageGUI
            	dispose();
            }
        });
        panel.add(goBackButton);
        add(panel, BorderLayout.CENTER);

        
        
        
        // Display the JFrame
        setVisible(true);
    }
    
	public static Object enterAccount(String accNum, String filename, String username) throws IOException { //////////////////////
		
		File file = new File(filename);
		Scanner reader = new Scanner(file);

		String accountOpenType = null;
		
		SavingsAccount openSavings = null;
		CheckingAccount openChecking = null;
		
		
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			String[] items = line.split(",");
			if (items[1].equals(accNum)) {
				if (items[0].equals("Savings")) {
					accountOpenType = "Savings";
					openSavings = new SavingsAccount(items[0], Integer.parseInt(items[1]), Double.parseDouble(items[2]));
				}
				else {
					accountOpenType = "Checking";
					openChecking = new CheckingAccount(items[0], Integer.parseInt(items[1]), Double.parseDouble(items[2]));
				}
			}
		}
		
		if (accountOpenType.equals("Savings")) {
			return openSavings;
		}
		else {
			return openChecking;
		}
		
	}
	
	/*
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nAccount #" + accNum + " - Choose an action: ");
		System.out.println("1. Check Balance\n2.Withdraw Money\n3.Deposit Money\n4.Close Account\n5. Quit");
		int userChoice = input.nextInt();
		
		String accNumString = accNum + "";
		
		if (accountOpenType.equals("Savings")) {
			if (action.equals("CheckBalance")) { //check balance
				System.out.println("Balance: " + openSavings.checkBalance());
			}
			if (userChoice == 2) { //withdraw money
				System.out.println("Enter amount to withdraw: ");
				double withdrawAmount = input.nextDouble();
				openSavings.withdraw(withdrawAmount);
				editAccount(accNum, openSavings, filename);
			}
			if (userChoice == 3) {
				System.out.println("Enter amount to deposit: ");
				double depositAmount = input.nextDouble();
				openSavings.deposit(depositAmount);
				editAccount(accNum, openSavings, filename);
			}
		}
		if (accountOpenType.equals("Checking")) {
			if (userChoice == 1) { //check balance
				System.out.println("Balance: " + openChecking.checkBalance());
			}
			if (userChoice == 2) { //withdraw money
				System.out.println("Enter amount to withdraw: ");
				double withdrawAmount = input.nextDouble();
				openChecking.withdraw(withdrawAmount);
				editAccount(accNum, openChecking, filename);
			}
			if (userChoice == 3) {
				System.out.println("Enter amount to deposit: ");
				double depositAmount = input.nextDouble();
				openChecking.deposit(depositAmount);
				editAccount(accNum, openChecking, filename);
			}
		}
		
		
		reader.close();
		input.close();
	}
	*/
	
	public static void editAccount(int accNum, Object account, String filename) throws IOException {
			
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			StringBuilder content = new StringBuilder();
			
			
			boolean isFound = false;
			
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String[] items = line.split(",");
				
				if (Integer.parseInt(items[1]) == accNum) {
					isFound = true;
				}
				else {
		            content.append(line).append("\n");
		        }
			}
			
			if (isFound == true) {
				
				content.append(account.toString()).append("\n");
				
	            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	            writer.write(content.toString());
	            writer.close();
	            System.out.println("Line cleared successfully.");
	        } 
			else {
	            System.out.println("Target number not found in the file.");
	        }
		}
}