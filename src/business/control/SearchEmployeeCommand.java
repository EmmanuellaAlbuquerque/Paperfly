package business.control;

import java.util.TreeSet;

import business.model.Employee;

public class SearchEmployeeCommand implements EmployeeCommand {
	private TreeSet<Employee> employees = new TreeSet<Employee>();
	private DBConnectionController<Employee> dbConnection;

  public SearchEmployeeCommand(DBConnectionController<Employee> dbConnection) {
		this.dbConnection = dbConnection;
    setEmployees(dbConnection.loadFromDatabase("database-employee.bin"));
  }

	@Override
	public TreeSet<Employee> execute(Employee employee) {
		TreeSet<Employee> employeesResult = new TreeSet<Employee>();
		employees.forEach((value) -> {
      if (value.getFullname().equals(employee.getFullname())) {
				employeesResult.add(value);
			}
		});	
		return employeesResult;
	}

	/**
	 * @return TreeSet<Employee> return the employees
	 */
	public TreeSet<Employee> getEmployees() {
		return employees;
}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(TreeSet<Employee> employees) {
			this.employees = employees;
	}
}
