package business.control;

import java.util.TreeSet;

import business.model.Employee;
import infra.EmployeePersistenceFactory;
import infra.IPersistence;
import infra.PersistenceFactory;

public class AddEmployeeCommand implements EmployeeCommand {
	private TreeSet<Employee> employees = new TreeSet<Employee>();
	private PersistenceFactory<Employee> persistenceFactory = new EmployeePersistenceFactory();
	private IPersistence<Employee> iPersistence = persistenceFactory.createPersistence();
	private DBConnectionController<Employee> dbConnection = new DBConnectionController<Employee>();

  public AddEmployeeCommand() {
		setEmployees(dbConnection.loadFromDatabase(employees, iPersistence, "database-employee.bin"));
  }

	@Override
	public TreeSet<Employee> execute(Employee employee) {
		employees.add(employee);
		dbConnection.saveInDatabase(employees, iPersistence, "database-employee.bin");
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
