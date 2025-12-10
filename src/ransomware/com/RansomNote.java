package ransomware.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

public class RansomNote {

    public void displayRansomNote() {
        JFrame frame = new JFrame("Ransom Note");

        JTextArea textArea = new JTextArea(10, 30);
        textArea.setText("Your files have been encrypted! Pay the ransom to get them back.");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setCaretPosition(0);
        textArea.setEditable(false);

        // Set a custom font and color.
        Font font = new Font("Serif", Font.BOLD, 18);
        textArea.setFont(font);
        textArea.setForeground(Color.RED);
        textArea.setBackground(Color.BLACK);

        // Add Scroll Pane
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Create a countDown label
        JLabel countDownLabel = new JLabel("Time left to pay : 10:00");
        countDownLabel.setFont(new Font("Arial", Font.BOLD, 16));
        countDownLabel.setForeground(Color.WHITE);

        // Create Buttons
        JButton payButton = new JButton("Pay Now");
        JButton learnMoreButton = new JButton("Learn More");

        // add button action
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(
                        frame,
                        "Do you want to simulate payment?",
                        "Payment",
                        JOptionPane.YES_NO_OPTION);

                 if (response == JOptionPane.YES_NO_OPTION){
                     JOptionPane.showMessageDialog(frame, "Simulating payment process...");
                 }else{
                     JOptionPane.showMessageDialog(frame, "You chose not to pay.");
                 }


            }
        });

        learnMoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display more information about the ransomware
                JOptionPane.showMessageDialog(
                        frame,
                        "This ransomware has encrypted your files and demands a ransom to decrypt them.\n"
                                + "Failure to pay may result in permanent loss of your data.",
                        "Learn More",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.add(payButton);
        buttonPanel.add(learnMoreButton);

        // create panel for the layout
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);
        panel.add(scrollPane,BorderLayout.CENTER);
        panel.add(countDownLabel,BorderLayout.NORTH);
        panel.add(buttonPanel,BorderLayout.SOUTH);

        // add the panel to the frame
        frame.getContentPane().add(panel);
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start the countdown timer

        new Timer(1000, new ActionListener() {
            int timeLeft = 600; // 10 min in seconds
            @Override
            public void actionPerformed(ActionEvent e) {
                  if(timeLeft > 0){
                       int minutes = timeLeft / 60;
                       int seconds = timeLeft % 60;
                       countDownLabel.setText("Time left to pay : " + String.format("%02d:%02d", minutes, seconds));
                       timeLeft--;
                  }else{
                      ((Timer)e.getSource()).stop();
                      countDownLabel.setText("Time is up!");
                      JOptionPane.showMessageDialog(frame, "Time is up! Files are lost forever.");
                  }
            }
        }).start();
    }
}


