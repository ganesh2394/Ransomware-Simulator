package ransomware.com;

import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class KeyStorage {

    // Save the secret key to a file
    public void saveKey(SecretKey secretKey, String fileName) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(secretKey);
        }
    }

    // Load the secret key from a file
    public SecretKey loadKey(String fileName) throws Exception {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (SecretKey) ois.readObject();
        }
    }
}