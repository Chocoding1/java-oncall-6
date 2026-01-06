package oncall.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OncallEmployees {

    private final WeekdaysEmployees weekdaysEmployees;
    private final HolidayEmployees holidayEmployees;

    public OncallEmployees(WeekdaysEmployees weekdaysEmployees, HolidayEmployees holidayEmployees) {
        validateEmployeesCount(weekdaysEmployees, holidayEmployees);
        this.weekdaysEmployees = weekdaysEmployees;
        this.holidayEmployees = holidayEmployees;
    }

    private void validateEmployeesCount(WeekdaysEmployees weekdaysEmployees, HolidayEmployees holidayEmployees) {
        Set<Employee> uniqueEmployees = Stream.of(weekdaysEmployees.getEmployees(), holidayEmployees.getEmployees())
                .flatMap(List::stream)
                .collect(Collectors.toSet());

        if (uniqueEmployees.size() < 5 || 35 < uniqueEmployees.size()) {
            throw new IllegalArgumentException("[ERROR] 전체 비상 근무자는 최소 5명에서 최대 35명까지만 가능합니다.");
        }
    }
}
