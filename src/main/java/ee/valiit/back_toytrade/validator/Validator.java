package ee.valiit.back_toytrade.validator;

import ee.valiit.back_toytrade.domain.user.User;
import ee.valiit.back_toytrade.infrastructure.exception.DataNotFoundException;


import java.util.Optional;

public class Validator {
    public static User getValidUser(Optional<User> user) {
        if (user.isEmpty()) {
            throw new DataNotFoundException(ErrorMessage.INCORRECT_CREDENTIALS.getMessage(),ErrorMessage.INCORRECT_CREDENTIALS.getCode());
        }
        return user.get();

    }

}
