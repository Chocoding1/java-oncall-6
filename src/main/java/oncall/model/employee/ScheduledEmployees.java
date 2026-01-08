package oncall.model.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScheduledEmployees {

    private final List<Employee> employees;

    public ScheduledEmployees() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public void assignEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean isAssignable(Employee employee) {
        if (employees.isEmpty()) {
            return true;
        }

        int lastIndex = employees.size() - 1;
        return !employees.get(lastIndex).equals(employee);
    }
}
