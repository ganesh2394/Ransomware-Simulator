package ransomware.com;

import javax.swing.*;
import java.io.File;

public class FileSelector {

    public String selectFileOrFolder() {
        // Create JFileChooser instance
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Allow both files and directories

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }else{
            return null; // Return null if no file was selected
        }

    }
}
