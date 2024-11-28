package menu.model;

import static menu.constant.MenuProperty.MAX_SAME_CATEGORY_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.constant.Menus;

public class Categories {
    private final List<Menus> categories = new ArrayList<>();

    public Menus chooseAvailableMenus() {
        while (true) {
            Menus menus = Menus.getMenusAt(Randoms.pickNumberInRange(1, 5));

            if (isAvailable(menus)) {
                categories.add(menus);
                break;
            }
        }
        return categories.get(categories.size() - 1);
    }

    private boolean isAvailable(Menus toCheck) {
        final int sameCategoryCount = (int) categories.stream()
                .filter(menus -> menus == toCheck)
                .count();

        return sameCategoryCount < MAX_SAME_CATEGORY_COUNT;
    }

    public List<Menus> toList() {
        return List.copyOf(categories);
    }
}
