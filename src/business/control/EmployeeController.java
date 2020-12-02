package business.control;

import java.util.Iterator;
import java.util.TreeSet;

import business.model.Date;
import business.model.Employee;
import infra.EmployeePersistenceFactory;
import infra.IPersistence;
import infra.PersistenceFactory;
import util.NothingToUndoMementoException;

public class EmployeeController {
  protected TreeSet<Employee> employees = new TreeSet<Employee>();
  private TreeSet<Employee> employeesSet =  new TreeSet<Employee>();
  private EmployeeCommandInvoker invoker = new EmployeeCommandInvoker();
  private EmployeeCommand executeService;
  EmployeesControllerCareTaker employeesControllerCareTaker;

	private PersistenceFactory<Employee> persistenceFactory = new EmployeePersistenceFactory();
	private IPersistence<Employee> iPersistence = persistenceFactory.createPersistence();
	private DBConnectionController<Employee> dbConnection = new DBConnectionController<Employee>(iPersistence);

  public EmployeeController() {
    setEmployees(dbConnection.loadFromDatabase("database-employee.bin"));
    employeesControllerCareTaker = new EmployeesControllerCareTaker();
  }

  public void add(String employeeId, String password, Date birthDate, String fullname, String address, String email, String phone) {
    Employee employee = new Employee(employeeId, password, birthDate, fullname, address, email, phone);
    executeService = new AddEmployeeCommand(dbConnection);
    setEmployees(invoker.executeCommand(employee, executeService));

    employeesSet.add(employee);
    employeesControllerCareTaker.addMemento(new EmployeesMemento(new TreeSet<>(employeesSet)));
  }

  public void update(Employee employee) {
    executeService = new UpdateEmployeeCommand(dbConnection);
    employees = invoker.executeCommand(employee, executeService);

    employeesSet.add(employee);
    employeesControllerCareTaker.addMemento(new EmployeesMemento(employeesSet));
  }

  public void search(Employee employee) {
    TreeSet<Employee> employeesResult = new TreeSet<Employee>();
    executeService = new SearchEmployeeCommand(dbConnection);
    employeesResult = invoker.executeCommand(employee, executeService);
    listAll(employeesResult);
  }

  public void undoEmployeesUpdate() {
    TreeSet<Employee> lastSavedMemento = new TreeSet<Employee>();
    try {
      lastSavedMemento = employeesControllerCareTaker.getLastSavedState().getSavedEmployeesCollection();
    } catch (NothingToUndoMementoException e) {
      System.out.println(e.getMessage());
    }

    for(Employee employee : new TreeSet<Employee>(employees)) {
      if (containsID(employee.getLogin(), lastSavedMemento)) {
        employeesSet.remove(employee);
        employees.remove(employee);
        break;
      }
    }

    dbConnection.saveInDatabase(employees, "database-employee.bin");
  }

  public void listAll(TreeSet<Employee> employeesSet) {
    employeesSet.forEach((value) -> {
      System.out.println(value.toString());
    });
  }

  public Boolean containsID(String employeesID, TreeSet<Employee> employeesMementoSet) {
    for(Employee employee : employeesMementoSet) {
      if(employee.getLogin().equals(employeesID)){
        return true;
      }
    }
    return false;
  }

  /**
	 * @return TreeSet<Employee> return the employees
	 */
	public TreeSet<Employee> getEmployees() {
    return employees;
}

  /**
	 * @return TreeSet<Employee> return the employees
	 */
	public TreeSet<Employee> getEmployeesSet() {
    return employeesSet;
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
  //   employeeController.add("AFADFADF8-7ADF", "dfadf8978ff", date, "Andre", "Rua J", "andre@gmail.com", "3433-8336");
  //   employeeController.listAll();
  //   employeeController.update(employee);

  //   employeeController.search(employee);
  // }


  // public static void main(String[] args) {
  //   EmployeeController employeeController = new EmployeeController();
  //   Date date = new Date(12, 12, 1999);

  //   employeeController.add("OPTRUUWQW-3922", "djue78skdi", date, "Joana Maria", "Rua H", "jmaria@gmail.com", "86767-5656");

  //   employeeController.add("AFADFADF8-7ADF", "dfadf8978ff", date, "Andre da Costa", "Rua J", "andre@gmail.com", "3433-8336");

  //   employeeController.add("QERIODSFK-4589", "djue78skdi", date, "Mathias Firmino", "Rua Q", "matfirmino@gmail.com", "5656-8978");


  //   System.out.println("\n------------------------------------------------------------------------------\n");

  //   employeeController.listAll(employeeController.getEmployees());
  //   employeeController.undoEmployeesUpdate();

  //   System.out.println("\n------------------------------------------------------------------------------\n");

  //   employeeController.listAll(employeeController.getEmployees());
  //   employeeController.undoEmployeesUpdate();

  //   System.out.println("\n------------------------------------------------------------------------------\n");


  //   employeeController.listAll(employeeController.getEmployees());
  //   employeeController.undoEmployeesUpdate();

  //   System.out.println("\n------------------------------------------------------------------------------\n");


  //   employeeController.listAll(employeeController.getEmployees());
  //   employeeController.undoEmployeesUpdate();

  //   System.out.println("\n------------------------------------------------------------------------------\n");


  //   employeeController.listAll(employeeController.getEmployees());

  // }


  // public static void main(String[] args) {
  //   EmployeeController employeeController = new EmployeeController();

  //   // employeeController.listAll(employeeController.getEmployees());

  //   // Date date = new Date(12, 12, 1999);
  //   // employeeController.add("employeeId", "password", date, "fullname", "address", "email", "phone");

  //   employeeController.listAll(employeeController.getEmployees());
  // }
}
