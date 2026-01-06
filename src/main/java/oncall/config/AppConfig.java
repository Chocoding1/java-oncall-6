package oncall.config;

import oncall.controller.ScheduleController;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {

    private ScheduleController scheduleController;
    private InputView inputView;
    private OutputView outputView;

    public ScheduleController scheduleController() {
        if (scheduleController == null) {
            scheduleController = new ScheduleController(inputView(), outputView());
        }
        return scheduleController;
    }

    private InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }
}
