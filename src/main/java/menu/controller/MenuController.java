package menu.controller;


import static menu.constant.MenuProperty.DAY_COUNT;
import static menu.constant.MenuProperty.MENU_INDEX;
import static menu.constant.OutputMessage.ALLERGIC_FOOD_PROMPT;
import static menu.constant.OutputMessage.COACH_NAME_PROMPT;
import static menu.constant.OutputMessage.END_MESSAGE;
import static menu.constant.OutputMessage.WELCOME_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.constant.Menus;
import menu.model.AllergicFoods;
import menu.model.Categories;
import menu.model.Coach;
import menu.model.Name;
import menu.service.AllergicFoodsService;
import menu.service.NameService;
import menu.util.Task;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.println(WELCOME_MESSAGE.toString());

        List<Coach> coaches = readCoaches();
        Categories categories = new Categories();

        for (int i = 0; i < DAY_COUNT; i++) {
            Menus menus = categories.chooseAvailableMenus();

            coaches.forEach(coach -> chooseMenuForCoach(coach, menus));
        }

        outputView.printCoachesFoods(coaches, categories);
        outputView.println(END_MESSAGE.toString());
    }

    private List<Coach> readCoaches() {
        List<Name> names = readNames();
        List<Coach> coaches = new ArrayList<>(names.size());

        for (Name name : names) {
            coaches.add(new Coach(name, readAllergicFoods(name)));
        }
        return coaches;
    }

    private List<Name> readNames() {
        return Task.retryTillNoException(
                () -> {
                    outputView.println(COACH_NAME_PROMPT.toString());
                    return NameService.parseNames(inputView.readLine());
                },
                outputView
        );
    }

    private AllergicFoods readAllergicFoods(Name name) {
        return Task.retryTillNoException(
                () -> {
                    outputView.println(ALLERGIC_FOOD_PROMPT.format(name));
                    return new AllergicFoods(AllergicFoodsService.parseAllergicFoods(inputView.readLine()));
                },
                outputView
        );
    }

    private void chooseMenuForCoach(Coach coach, Menus menus) {
        while (true) {
            String menu = Randoms.shuffle(menus.toList()).get(MENU_INDEX);

            if (coach.catEat(menu)) {
                coach.eat(menu);
                break;
            }
        }
    }
}
