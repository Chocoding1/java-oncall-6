package oncall.model;

import java.util.HashSet;
import java.util.List;

public class HolidayEmployees {

    private final List<Employee> employees;

    public HolidayEmployees(List<String> nicknames) {
        List<Employee> employees = nicknames.stream()
                .map(Employee::new)
                .toList();
        validateDuplicateEmployee(employees);
        validateEmployeeCount(employees);
        this.employees = employees;
    }

    private void validateDuplicateEmployee(List<Employee> employees) {
        HashSet<Employee> uniqueEmployees = new HashSet<>(employees);
        if (uniqueEmployees.size() != employees.size()) {
            throw new IllegalArgumentException("[ERROR] 중복 근무자가 존재합니다.");
        }
    }

    private void validateEmployeeCount(List<Employee> employees) {
        if (employees.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 비상 근무자는 2명 이상이어야 합니다.");
        }
    }
}
