package ee.valiit.back_toytrade.validator;

import ee.valiit.back_toytrade.domain.user.User;
import ee.valiit.back_toytrade.infrastructure.exception.BusinessException;
import ee.valiit.back_toytrade.infrastructure.exception.DataNotFoundException;


import java.util.Optional;

import static ee.valiit.back_toytrade.validator.ErrorMessage.*;

public class Validator {
    public static User getValidUser(Optional<User> user) {
        if (user.isEmpty()) {
            throw new DataNotFoundException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getCode());
        }
        return user.get();

    }

    public static void validateUserExists(boolean userExists) {
        if (userExists) {
            throw new BusinessException(DUPLICATE_USERNAME.getMessage(), DUPLICATE_USERNAME.getCode());
        }
    }

    public static void validateCategoryExists(boolean categoryExists) {
        if (categoryExists) {
            throw new BusinessException(DUPLICATE_CATEGORY.getMessage(), DUPLICATE_CATEGORY.getCode());
        }
    }

    public static void validateConditionExists(boolean conditionExists) {
        if(conditionExists) {
            throw new BusinessException(DUPLICATE_CONDITION.getMessage(), DUPLICATE_CONDITION.getCode());
        }
    }

    public static void validateCityExists(boolean cityExists) {
        if(cityExists) {
            throw new BusinessException(DUPLICATE_CITY.getMessage(), DUPLICATE_CITY.getCode());
        }
    }
}
