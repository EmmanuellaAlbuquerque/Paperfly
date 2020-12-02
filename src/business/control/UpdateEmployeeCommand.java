package business.control;

import java.util.TreeSet;

import business.model.Employee;

public class UpdateEmployeeCommand implements EmployeeCommand {
	private TreeSet<Employee> employees = new TreeSet<Employee>();
	private DBConnectionController<Employee> dbConnection;

  public UpdateEmployeeCommand(DBConnectionController<Employee> dbConnection) {
		this.dbConnection = dbConnection;
    setEmployees(dbConnection.loadFromDatabase("database-employee.bin"));
  }

	@Override
	public TreeSet<Employee> execute(Employee employee) {
    employees.forEach((value) -> {
      if (value.compareTo(employee) == 0) {
				value.setPassword(employee.getPassword());
				value.setBirthDate(employee.getBirthDate());
				// value.setFullname(employee.getFullname());
				value.setAddress(employee.getAddress());
				value.setEmail(employee.getEmail());
				value.setPhone(employee.getPhone());
			}
		});
		
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
