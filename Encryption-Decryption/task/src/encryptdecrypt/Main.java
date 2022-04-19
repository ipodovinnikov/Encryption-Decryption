package encryptdecrypt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static encryptdecrypt.Constants.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, String> mappedArgs = mapArgs(args);
        if (mappedArgs.get(ALGORITHM).equals(UNICODE)) {
            UnicodeEncryptor unicodeEncryptor = new UnicodeEncryptor();
            unicodeEncryptor.encrypt(mappedArgs);
        }
        if (mappedArgs.get(ALGORITHM).equals(SHIFT)) {
            ShiftEncryptor shiftEncryptor = new ShiftEncryptor();
            shiftEncryptor.encrypt(mappedArgs);
        }
    }

    public static Map<String, String> mapArgs(String... args) {

        Map<String, String> dataMap = new HashMap<>();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case MODE:
                    dataMap.put(MODE, args[i + 1]);
                    break;
                case KEY:
                    dataMap.put(KEY, args[i + 1]);
                    break;
                case DATA:
                    dataMap.put(DATA, args[i + 1]);
                    break;
                case IN:
                    dataMap.put(IN, args[i + 1]);
                    break;
                case OUT:
                    dataMap.put(OUT, args[i + 1]);
                    break;
                case ALGORITHM:
                    dataMap.put(ALGORITHM, args[i + 1]);
                    break;
            }
        }
        if (!dataMap.containsKey(MODE)) {
            dataMap.put(MODE, ENC);
        }
        if (!dataMap.containsKey(KEY)) {
            dataMap.put(KEY, "0");
        }
        if (!dataMap.containsKey(ALGORITHM)) {
            dataMap.put(ALGORITHM, SHIFT);
        }
        if (!dataMap.containsKey(DATA) && !dataMap.containsKey(IN)) {
            dataMap.put(DATA, "");
        }
        if (dataMap.containsKey(DATA) && dataMap.containsKey(IN)) {
            dataMap.remove(IN);
        }
        if (!dataMap.containsKey(OUT)) {
            dataMap.put(OUT, SOUT);
        }
        return dataMap;
    }


}
