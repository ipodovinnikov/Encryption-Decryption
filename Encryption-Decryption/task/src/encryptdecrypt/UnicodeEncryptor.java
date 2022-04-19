package encryptdecrypt;

public class UnicodeEncryptor implements BaseEncryptor {

    /**
     * Created by ipodovinnikov (podovinnii@ae.com) on 3/31/22.
     */

    @Override
    public String decrypt(String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            encryptedMessage.append((char) (message.charAt(i) - key));
        }
        System.out.println(encryptedMessage);
        return encryptedMessage.toString();
    }

    @Override
    public String encrypt(String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            encryptedMessage.append((char) (message.charAt(i) + key));
        }
        return encryptedMessage.toString();
    }
}
