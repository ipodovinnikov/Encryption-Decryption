package encryptdecrypt;

import static encryptdecrypt.Constants.ABC_LOWERCASE;
import static encryptdecrypt.Constants.ABC_UPPERCASE;

public class ShiftEncryptor implements BaseEncryptor {

    /**
     * Created by ipodovinnikov (podovinnii@ae.com) on 3/31/22.
     */

    @Override
    public String decrypt(String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == (char) 32) encryptedMessage.append(" ");
            if (message.charAt(i) == (char) 33) encryptedMessage.append("!");
            for (int k = 0; k < ABC_LOWERCASE.length(); k++) {
                if (message.charAt(i) == ABC_LOWERCASE.charAt(k)) {
                    int index = (k - key) < 0 ? (k - key) + 26 : (k - key);
                    if (Character.isUpperCase(message.charAt(i))) {
                        encryptedMessage.append(ABC_UPPERCASE.charAt(index));
                    } else {
                        encryptedMessage.append(ABC_LOWERCASE.charAt(index));
                    }
                }
            }
        }
        return encryptedMessage.toString();
    }

    @Override
    public String encrypt(String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == (char) 32) encryptedMessage.append(" ");
            if (message.charAt(i) == (char) 33) encryptedMessage.append("!");
            for (int k = 0; k < ABC_LOWERCASE.length(); k++) {
                if (message.charAt(i) == ABC_LOWERCASE.charAt(k) || message.charAt(i) == ABC_UPPERCASE.charAt(k)) {
                    int index = (k + key) >= 26 ? (k + key) - 26 : (k + key);
                    if (Character.isUpperCase(message.charAt(i))) {
                        encryptedMessage.append(ABC_UPPERCASE.charAt(index));
                    } else {
                        encryptedMessage.append(ABC_LOWERCASE.charAt(index));
                    }
                }
            }
        }
        return encryptedMessage.toString();
    }
}
