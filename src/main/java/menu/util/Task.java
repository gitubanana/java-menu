package menu.util;

import menu.view.OutputView;

public interface Task<T> {
    static <T> T retryTillNoException(Task<T> task, OutputView outputView) {
        while (true) {
            try {
                return task.run();
            } catch (IllegalArgumentException e) {
                outputView.println(e.getMessage());
            }
        }
    }

    T run();
}
