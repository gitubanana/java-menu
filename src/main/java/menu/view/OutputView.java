package menu.view;

import static menu.constant.OutputMessage.ALIGNED_LINE;
import static menu.constant.OutputMessage.DAY_OF_RECOMMEND;
import static menu.constant.OutputMessage.DELIMITER;
import static menu.constant.OutputMessage.RECOMMEND_START_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import menu.model.Categories;
import menu.model.Coach;

public class OutputView {
    public void println(String message) {
        System.out.println(message);
    }

    public void printCoachesFoods(List<Coach> coaches, Categories categories) {
        println(RECOMMEND_START_MESSAGE.toString());
        println(DAY_OF_RECOMMEND.toString());
        printCategories(categories);

        coaches.forEach(this::printCoachFoods);
    }

    private void printCategories(Categories categories) {
        println(ALIGNED_LINE.format(
                "카테고리",
                categories.toList().stream()
                        .map(Enum::name)
                        .collect(Collectors.joining(DELIMITER.toString()))
        ));
    }

    private void printCoachFoods(Coach coach) {
        println(ALIGNED_LINE.format(
                coach.getName(),
                coach.getEatenFoods().stream()
                        .collect(Collectors.joining(DELIMITER.toString()))
        ));
    }
}
