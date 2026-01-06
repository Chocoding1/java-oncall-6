package oncall.config;

import oncall.controller.ScheduleController;
import oncall.view.InputView;

public class AppConfig {

    private ScheduleController scheduleController;
    private InputView inputView;

    public ScheduleController scheduleController() {
        if (scheduleController == null) {
            scheduleController = new ScheduleController(inputView());
        }
        return scheduleController;
    }

    private InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }
}
