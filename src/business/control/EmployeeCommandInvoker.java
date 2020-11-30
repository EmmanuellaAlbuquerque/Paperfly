package business.control;

import java.util.TreeSet;

import business.model.Employee;

public class EmployeeCommandInvoker {
  public TreeSet<Employee> executeCommand(Employee employee, EmployeeCommand employeeCommand) {
    return employeeCommand.execute(employee);
  }
}
