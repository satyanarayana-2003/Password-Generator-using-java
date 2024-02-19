import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class PasswordEncryptor {

    public static String encryptPassword(String password) throws Exception {
        
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();

        
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

       
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());

        
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static void main(String[] args) {
        try {
            String generatedPassword = PasswordGenerator.generatePassword(12);
            String encryptedPassword = encryptPassword(generatedPassword);

            System.out.println("Generated Password: " + generatedPassword);
            System.out.println("Encrypted Password: " + encryptedPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
