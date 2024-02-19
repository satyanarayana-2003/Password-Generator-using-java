import java.security.SecureRandom;

public class PasswordGenerator {


    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARACTERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        
        password.append(getRandomCharacter(LOWERCASE_CHARACTERS, random));
        password.append(getRandomCharacter(UPPERCASE_CHARACTERS, random));
        password.append(getRandomCharacter(NUMERIC_CHARACTERS, random));
        password.append(getRandomCharacter(SPECIAL_CHARACTERS, random));

       
        for (int i = 4; i < length; i++) {
            String characterSet = getRandomCharacterSet(random);
            password.append(getRandomCharacter(characterSet, random));
        }

        
        char[] passwordArray = password.toString().toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = passwordArray[index];
            passwordArray[index] = passwordArray[i];
            passwordArray[i] = temp;
        }

        return new String(passwordArray);
    }

    
    private static char getRandomCharacter(String characterSet, SecureRandom random) {
        int index = random.nextInt(characterSet.length());
        return characterSet.charAt(index);
    }

   
    private static String getRandomCharacterSet(SecureRandom random) {
        String[] characterSets = {LOWERCASE_CHARACTERS, UPPERCASE_CHARACTERS, NUMERIC_CHARACTERS, SPECIAL_CHARACTERS};
        int index = random.nextInt(characterSets.length);
        return characterSets[index];
    }

    public static void main(String[] args) {
        
        String generatedPassword = generatePassword(12);
        System.out.println("Generated Password: " + generatedPassword);
    }
}
