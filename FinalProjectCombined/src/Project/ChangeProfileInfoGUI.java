package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

class ChangeProfileInfoGUI extends JFrame {
    private JTextField newUsernameField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;

    public ChangeProfileInfoGUI(String username) {
        // Set up the JFrame for changing profile info
        setTitle("Edit Profile");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create and add components for changing profile info
        JPanel changeProfilePanel = new JPanel(new GridLayout(4, 1, 5, 5));

        JLabel changeProfileLabel = new JLabel("Edit Profile");
        changeProfileLabel.setHorizontalAlignment(SwingConstants.CENTER);
        changeProfilePanel.add(changeProfileLabel);

        JPanel inputPanel1 = new JPanel(new GridLayout(1, 2, 5, 5));
        inputPanel1.add(new JLabel("New Username:"));
        newUsernameField = new JTextField();
        inputPanel1.add(newUsernameField);
        changeProfilePanel.add(inputPanel1);

        JPanel inputPanel2 = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel2.add(new JLabel("New Password:"));
        newPasswordField = new JPasswordField();
        inputPanel2.add(newPasswordField);
        inputPanel2.add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField();
        inputPanel2.add(confirmPasswordField);
        changeProfilePanel.add(inputPanel2);

        JButton saveChangesButton = new JButton("Save Changes");
        saveChangesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your logic to save changes to profile info
                // For now, let's just display a message
                JOptionPane.showMessageDialog(null, "Changes saved successfully!");
                dispose();
                try {
					new ProfilePageGUI(username);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        changeProfilePanel.add(saveChangesButton);

        add(changeProfilePanel, BorderLayout.CENTER);

        // Display the JFrame
        setVisible(true);
    }
}