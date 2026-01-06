package oncall.controller;

import static oncall.exception.ExceptionHandler.*;

import java.util.List;
import oncall.exception.ExceptionHandler;
import oncall.model.OncallInfo;
import oncall.util.CommaParser;
import oncall.view.InputView;

public class ScheduleController {

    private final InputView inputView;

    public ScheduleController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        OncallInfo oncallInfo = retryUntilSuccess(this::getOncallInfo);
    }

    private OncallInfo getOncallInfo() {
        String input = inputView.readOncallInfo();
        List<String> oncallInfo = CommaParser.parse(input);
        return new OncallInfo(oncallInfo);
    }
}
