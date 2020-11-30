package business.control;

import java.util.TreeSet;

import business.model.Employee;

public interface EmployeeCommand {
  public TreeSet<Employee> execute(Employee Employee);
}
