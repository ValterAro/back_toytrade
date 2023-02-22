package ee.valiit.back_toytrade.validator;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", "600"),
    DUPLICATE_USERNAME("Selline kasutajanimi on olemas", "400"),
    DUPLICATE_CATEGORY("Selline kategooria on olemas", "410"),
    DUPLICATE_CONDITION("Selline seisukord on olemas", "420"),
    DUPLICATE_CITY("Selline asukoht on olemas", "430");

    private String message;
    private String code;

    ErrorMessage(String message, String code) {
        this.message = message;
        this.code = code;
    }

}
