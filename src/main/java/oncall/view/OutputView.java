package oncall.view;

import java.util.List;
import oncall.model.date.DayOfWeek;
import oncall.model.employee.Employee;
import oncall.model.date.Month;
import oncall.model.OncallInfo;
import oncall.model.date.PublicHoliday;
import oncall.model.employee.ScheduledEmployees;

public class OutputView {

    private static final String SCHEDULE_RESULT_FORMAT = "%d월 %d일 %S%S %S%n";

    public void printResult(OncallInfo oncallInfo, ScheduledEmployees scheduledEmployees) {
        int month = oncallInfo.getMonth().getMonthOfYear();
        List<Employee> employees = scheduledEmployees.getEmployees();

        int startDayOfWeekId = getStartDayOfWeek(oncallInfo);
        int daysOfMonth = oncallInfo.getMonth().getDaysOfMonth();
        for (int date = 1, dayOfWeekId = startDayOfWeekId, employeeIdx = 0; date <= daysOfMonth;
             date++, dayOfWeekId++, employeeIdx++) {
            String dayOfWeekName = getDayOfWeekName(dayOfWeekId);
            String employeeNickname = getEmployeeNickname(employees, employeeIdx);
            String holidayNotice = getHolidayNotice(oncallInfo, date);
            System.out.printf(SCHEDULE_RESULT_FORMAT, month, date, dayOfWeekName, holidayNotice, employeeNickname);
        }
    }

    private int getStartDayOfWeek(OncallInfo oncallInfo) {
        DayOfWeek dayOfWeek = oncallInfo.getDayOfWeek();
        return dayOfWeek.getId();
    }

    private String getDayOfWeekName(int dayOfWeekId) {
        dayOfWeekId %= 7;
        return DayOfWeek.getName(dayOfWeekId);
    }

    private String getEmployeeNickname(List<Employee> employees, int employeeIdx) {
        Employee employee = employees.get(employeeIdx);
        return employee.getNickname();
    }

    private String getHolidayNotice(OncallInfo oncallInfo, int date) {
        Month month = oncallInfo.getMonth();
        DayOfWeek dayOfWeek = oncallInfo.getDayOfWeek();
        if (PublicHoliday.isHoliday(month, date) && dayOfWeek.isWeekDays()) {
            return "(휴일)";
        }
        return "";
    }
}
