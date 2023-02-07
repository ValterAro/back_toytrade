package ee.valiit.back_toytrade.validator;


import lombok.Getter;

@Getter
public enum ErrorMessage {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", "600"),
    DUPLICATE_USERNAME("Selline kasutajanimi on olemas", "400");


    private String message;
    private String code;

    ErrorMessage(String message, String code) {
        this.message = message;
        this.code = code;
    }

}
