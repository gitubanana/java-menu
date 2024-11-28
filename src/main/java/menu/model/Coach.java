package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final Name name;
    private final AllergicFoods allergicFoods;
    private final List<String> eatenFoods;

    public Coach(Name name, AllergicFoods allergicFoods) {
        this.name = name;
        this.allergicFoods = allergicFoods;
        this.eatenFoods = new ArrayList<>();
    }

    public boolean catEat(String food) {
        return !allergicFoods.contains(food) && !eatenFoods.contains(food);
    }

    public void eat(String food) {
        eatenFoods.add(food);
    }

    public List<String> getEatenFoods() {
        return List.copyOf(eatenFoods);
    }

    public Name getName() {
        return name;
    }
}
