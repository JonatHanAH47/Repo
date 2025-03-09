/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The CryptoManager class handles encryption and decryption using the Caesar and Bellaso ciphers.
 *  isStringInBounds checks if all characters in a string are within the allowed ASCII range. 
 *  caesarEncryption encrypts a string by shifting characters with a key, wrapping around if needed. 
 *  caesarDecryption reverses the Caesar encryption using the same key. 
 *  bellasoEncryption encrypts a string by combining characters with a key string, wrapping around if necessary. 
 *  bellasoDecryption reverses the Bellaso encryption using the same key string.
 *  The FXDriver and FXMainPane classes were given, they make the GUI.
 * Due: 03/10/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Jonathan Herrera
*/

/**
 * 
 */

/**
 * 
 */
public class CryptoManager {

    // Define the allowable ASCII range
    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    /**
     * Checks if all characters in the plainText are within the allowable bounds.
     *
     * @param plainText The string to be checked.
     * @return true if all characters are within bounds, false otherwise.
     */
    public static boolean isStringInBounds(String plainText) {
        for (char c : plainText.toCharArray()) {
            if (c < LOWER_RANGE || c > UPPER_RANGE) {
                return false;
            }
        }
        return true;
    }

    /**
     * Encrypts a string using the Caesar Cipher.
     *
     * @param plainText The string to be encrypted.
     * @param key       The offset for the substitution.
     * @return The encrypted string, or an error message if plainText is out of bounds.
     */
    public static String caesarEncryption(String plainText, int key) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }
        StringBuilder encryptedText = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            int encryptedChar = c + key;
            while (encryptedChar > UPPER_RANGE) {
                encryptedChar -= RANGE;
            }
            encryptedText.append((char) encryptedChar);
        }
        return encryptedText.toString();
    }

    /**
     * Decrypts a string encrypted with the Caesar Cipher.
     *
     * @param encryptedText The string to be decrypted.
     * @param key           The offset used for encryption.
     * @return The decrypted string.
     */
    public static String caesarDecryption(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
            int decryptedChar = c - key;
            while (decryptedChar < LOWER_RANGE) {
                decryptedChar += RANGE;
            }
            decryptedText.append((char) decryptedChar);
        }
        return decryptedText.toString();
    }

    /**
     * Encrypts a string using the Bellaso Cipher.
     *
     * @param plainText  The string to be encrypted.
     * @param bellasoStr The key word for encryption.
     * @return The encrypted string.
     */
    public static String bellasoEncryption(String plainText, String bellasoStr) {
        StringBuilder encryptedText = new StringBuilder();
        int bellasoLength = bellasoStr.length();
        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);
            char bellasoChar = bellasoStr.charAt(i % bellasoLength);
            int encryptedChar = plainChar + bellasoChar;
            while (encryptedChar > UPPER_RANGE) {
                encryptedChar -= RANGE;
            }
            encryptedText.append((char) encryptedChar);
        }
        return encryptedText.toString();
    }

    /**
     * Decrypts a string encrypted with the Bellaso Cipher.
     *
     * @param encryptedText The string to be decrypted.
     * @param bellasoStr    The key word used for encryption.
     * @return The decrypted string.
     */
    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        StringBuilder decryptedText = new StringBuilder();
        int bellasoLength = bellasoStr.length();
        for (int i = 0; i < encryptedText.length(); i++) {
            char encryptedChar = encryptedText.charAt(i);
            char bellasoChar = bellasoStr.charAt(i % bellasoLength);
            int decryptedChar = encryptedChar - bellasoChar;
            while (decryptedChar < LOWER_RANGE) {
                decryptedChar += RANGE;
            }
            decryptedText.append((char) decryptedChar);
        }
        return decryptedText.toString();
    }
}