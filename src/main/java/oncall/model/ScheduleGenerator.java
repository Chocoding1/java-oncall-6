package oncall.model;

public class ScheduleGenerator {

    private final OncallInfo oncallInfo;
    private final OncallEmployees oncallEmployees;

    public ScheduleGenerator(OncallInfo oncallInfo, OncallEmployees oncallEmployees) {
        this.oncallInfo = oncallInfo;
        this.oncallEmployees = oncallEmployees;
    }

    public ScheduledEmployees generate() {
        Month month = oncallInfo.getMonth();
        int date = 1;
        int dayOfWeekId = getStartDayOfWeek();
        ScheduledEmployees scheduledEmployees = new ScheduledEmployees();
        for (int i = 0; i < month.getDaysOfMonth(); i++) {
            dayOfWeekId %= 7;
            Employees employees = getEmployees(month, date, dayOfWeekId);
            assignEmployee(scheduledEmployees, employees);
        }
        return scheduledEmployees;
    }

    private int getStartDayOfWeek() {
        DayOfWeek dayOfWeek = oncallInfo.getDayOfWeek();
        return dayOfWeek.getId();
    }

    private Employees getEmployees(Month month, int date, int dayOfWeekId) {
        if (isHoliday(month, date, dayOfWeekId)) {
            return oncallEmployees.getHolidayEmployees();
        }
        return oncallEmployees.getWeekdaysEmployees();
    }

    private boolean isHoliday(Month month, int date, int dayOfWeekId) {
        return dayOfWeekId == 0 || dayOfWeekId == 6 || PublicHoliday.isHoliday(month, date);
    }

    private void assignEmployee(ScheduledEmployees scheduledEmployees, Employees employees) {
        Employee employee = employees.nextEmployee(scheduledEmployees);
        scheduledEmployees.assignEmployee(employee);
    }
}
