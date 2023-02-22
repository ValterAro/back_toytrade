package ee.valiit.back_toytrade.infrastructure.util;

public class PictureUtil {


    public static String byteArrayToString(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        } else {
            return new String(byteArray);
        }
    }
}

