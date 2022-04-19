package encryptdecrypt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static encryptdecrypt.Constants.*;

public abstract interface BaseEncryptor {

    /**
     * Created by ipodovinnikov (podovinnii@ae.com) on 3/31/22.
     */

    default void encrypt(Map<String, String> mappedArgs) throws IOException {
        if (mappedArgs.containsKey(IN) && !mappedArgs.get(OUT).equals(SOUT)) {

            Path in = Paths.get(mappedArgs.get(IN));
            Path out = Paths.get(mappedArgs.get(OUT));

            try (BufferedReader reader = Files.newBufferedReader(in);
                 BufferedWriter writer = Files.newBufferedWriter(out)) {
                writer.write(encrypt(mappedArgs.get(MODE), reader.readLine(), Integer.parseInt(mappedArgs.get(KEY))));
            }
        } else if (mappedArgs.containsKey(IN) && mappedArgs.get(OUT).equals(SOUT)) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(mappedArgs.get(IN)))) {
                System.out.println(encrypt(mappedArgs.get(MODE), reader.readLine(), Integer.parseInt(mappedArgs.get(KEY))));
            }
        }
    }

    default String encrypt(String mode, String data, int key) {
        switch (mode) {
            case ENC:
                return encrypt(data, key);
            case DEC:
                return decrypt(data, key);
            default:
                return NO_MODE_ERROR;
        }
    }

    String encrypt(String message, int key);

    String decrypt(String message, int key);
}
