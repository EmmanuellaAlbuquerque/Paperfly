package business.control;

import java.util.TreeSet;

import business.model.Employee;

public class AddEmployeeCommand implements EmployeeCommand {
	private TreeSet<Employee> employees = new TreeSet<Employee>();
	private DBConnectionController<Employee> dbConnection;

  public AddEmployeeCommand(DBConnectionController<Employee> dbConnection) {
		this.dbConnection = dbConnection;
		setEmployees(dbConnection.loadFromDatabase("database-employee.bin"));
  }

	@Override
	public TreeSet<Employee> execute(Employee employee) {
		employees.add(employee);
		dbConnection.saveInDatabase(employees, "database-employee.bin");
		return employees;
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
