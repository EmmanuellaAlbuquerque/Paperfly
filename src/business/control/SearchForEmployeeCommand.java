package business.control;

import java.util.TreeSet;

import business.model.Employee;

public class SearchForEmployeeCommand implements EmployeeCommand {

  public SearchForEmployeeCommand() {
    // loadFromDatabase
  }

	@Override
	public TreeSet<Employee> execute(Employee Employee) {
		return null;
	}
}
