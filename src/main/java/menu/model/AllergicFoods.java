package menu.model;

import static menu.constant.ErrorMessage.TOO_MANY_ALLERGIC_COUNT;
import static menu.constant.MenuProperty.MAX_ALLERGIC_COUNT;

import java.util.List;

public class AllergicFoods {
    private final List<String> allergicFoods;

    public AllergicFoods(List<String> allergicFoods) {
        validate(allergicFoods);
        this.allergicFoods = allergicFoods;
    }

    private void validate(List<String> allergicFoods) {
        validateAllergicCount(allergicFoods);
    }

    private void validateAllergicCount(List<String> allergicFoods) {
        if (allergicFoods.size() > MAX_ALLERGIC_COUNT) {
            throw new IllegalArgumentException(TOO_MANY_ALLERGIC_COUNT.getMessage());
        }
    }

    public boolean contains(String food) {
        return allergicFoods.contains(food);
    }
}
