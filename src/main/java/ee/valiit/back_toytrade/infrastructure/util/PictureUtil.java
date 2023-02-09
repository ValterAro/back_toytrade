package ee.valiit.back_toytrade.infrastructure.util;

import java.nio.charset.StandardCharsets;

public class PictureUtil {


    public static String byteArrayToString(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        } else {
            return new String(byteArray);
        }
    }
//        One liner ternary
//        return byteArray == null ? null : new String(byteArray);

    }

