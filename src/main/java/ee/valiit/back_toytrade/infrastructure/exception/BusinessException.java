package ee.valiit.back_toytrade.infrastructure.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private final String message;
    private final String errorCode;

    public BusinessException(String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
