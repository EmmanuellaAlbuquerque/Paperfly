package business.control;

import java.util.TreeSet;

import business.model.Date;
import business.model.Employee;
import infra.EmployeePersistenceFactory;
import infra.IPersistence;
import infra.PersistenceFactory;

public class EmployeeController {
	private PersistenceFactory<Employee> persistenceFactory = new EmployeePersistenceFactory();
	private IPersistence<Employee> iPersistence = persistenceFactory.createPersistence();
	private DBConnectionController<Employee> dbConnection = new DBConnectionController<Employee>(iPersistence);

  private TreeSet<Employee> employees = new TreeSet<Employee>();
  private EmployeeCommandInvoker invoker = new EmployeeCommandInvoker();
  private EmployeeCommand executeService;

  public EmployeeController() {
    setEmployees(dbConnection.loadFromDatabase("database-employee.bin"));
  }

  public void add(String employeeId, String password, Date birthDate, String fullname, String address, String email, String phone) {
    Employee employee = new Employee(employeeId, password, birthDate, fullname, address, email, phone);
    executeService = new AddEmployeeCommand(dbConnection);
    setEmployees(invoker.executeCommand(employee, executeService));
  }

  public void update(Employee employee) {
    executeService = new UpdateEmployeeCommand(dbConnection);
    employees = invoker.executeCommand(employee, executeService);
  }

  public void listAll() {
    employees.forEach((value) -> {
      System.out.println(value.toString());
    });
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

  // public static void main(String[] args) throws NoSuchFieldException, SecurityException {
  //   EmployeeController employeeController =  new EmployeeController();
  //   Date date = new Date(12, 12, 2012);
  //   Employee employee = new Employee("AFADFADF8-7ADF", "dfadf8978ff", date, "Andre Marcelo Andrade", "Rua J", "andre@gmail.com", "3433-8336");
  //   // employeeController.add("AFADFADF8-7ADF", "dfadf8978ff", date, "Andre", "Rua J", "andre@gmail.com", "3433-8336");
  //   // employeeController.listAll();
  //   employeeController.update(employee);
  //   employeeController.listAll();
  // }
}
