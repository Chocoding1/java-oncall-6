package oncall.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WeekdaysEmployees extends Employees{

    private int currentEmployeeIdx = 0;
    private final Queue<Employee> changedEmployees;

    public WeekdaysEmployees(List<String> nicknames) {
        super(nicknames);
        this.changedEmployees = new LinkedList<>();
    }

    @Override
    public Employee nextEmployee(ScheduledEmployees scheduledEmployees) {
        Employee employee;
        currentEmployeeIdx %= employeesCount();
        if (changedEmployees.isEmpty()) {
            employee = currentEmployee(currentEmployeeIdx);
            if (scheduledEmployees.isAssignable(employee)) {
                currentEmployeeIdx++;
                return employee;
            }
            changedEmployees.offer(employee);
            currentEmployeeIdx++;
            return currentEmployee(currentEmployeeIdx++);
        }

        employee = changedEmployees.peek();
        if (scheduledEmployees.isAssignable(employee)) {
            return changedEmployees.poll();
        }
        return currentEmployee(currentEmployeeIdx++);
    }
}
