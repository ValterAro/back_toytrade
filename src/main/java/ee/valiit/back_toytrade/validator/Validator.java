package ee.valiit.back_toytrade.validator;

import ee.valiit.back_toytrade.domain.user.User;

import java.util.Optional;

public class Validator {
    public static User getValidUser(Optional<User> user) {
        if (user.isEmpty()) {
            //Error
        }
        return user.get();

    }

}
