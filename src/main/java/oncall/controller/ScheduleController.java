package oncall.controller;

import static oncall.exception.ExceptionHandler.*;

import java.util.List;
import oncall.model.HolidayEmployees;
import oncall.model.OncallEmployees;
import oncall.model.OncallInfo;
import oncall.model.ScheduleGenerator;
import oncall.model.ScheduledEmployees;
import oncall.model.WeekdaysEmployees;
import oncall.util.CommaParser;
import oncall.view.InputView;

public class ScheduleController {

    private final InputView inputView;

    public ScheduleController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        OncallInfo oncallInfo = retryUntilSuccess(this::getOncallInfo);
        OncallEmployees oncallEmployees = retryUntilSuccess(this::getOncallEmployees);
        ScheduleGenerator scheduleGenerator = new ScheduleGenerator(oncallInfo, oncallEmployees);
        ScheduledEmployees scheduledEmployees = scheduleGenerator.generate();
    }

    private OncallEmployees getOncallEmployees() {
        WeekdaysEmployees weekdaysEmployees = getWeekdaysOncallEmployees();
        HolidayEmployees holidayEmployees = getHolidayOncallEmployees();
        return new OncallEmployees(weekdaysEmployees, holidayEmployees);
    }

    private OncallInfo getOncallInfo() {
        String input = inputView.readOncallInfo();
        List<String> oncallInfo = CommaParser.parse(input);
        return new OncallInfo(oncallInfo);
    }

    private WeekdaysEmployees getWeekdaysOncallEmployees() {
        String input = inputView.readWeekdaysOncallNicknames();
        List<String> nicknames = CommaParser.parse(input);
        return new WeekdaysEmployees(nicknames);
    }

    private HolidayEmployees getHolidayOncallEmployees() {
        String input = inputView.readHolidayOncallNicknames();
        List<String> nicknames = CommaParser.parse(input);
        return new HolidayEmployees(nicknames);
    }
}
