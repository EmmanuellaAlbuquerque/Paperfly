package business.control;

import java.util.TreeSet;

import business.model.Date;
import business.model.Employee;

public class EmployeeController {
  private TreeSet<Employee> employees = new TreeSet<Employee>();
  private EmployeeCommandInvoker invoker = new EmployeeCommandInvoker();
  private EmployeeCommand executeService;

  public void add(String employeeId, String password, Date birthDate, String fullname, String address, String email, String phone) {
    Employee employee = new Employee(employeeId, password, birthDate, fullname, address, email, phone);
    executeService = new AddEmployeeCommand();
    employees = invoker.executeCommand(employee, executeService);
  }

  public void listAll() {
    employees.forEach((value) -> {
      System.out.println(value.toString());
    });
  }

  // public static void main(String[] args) throws NoSuchFieldException, SecurityException {
  //   EmployeeController employeeController =  new EmployeeController();
  //   Date date = new Date(12, 12, 2012);
  //   employeeController.add("LPOQISK-9997", "dfadf8978ff", date, "Marcos Santana", "Rua J", "marcoss@gmail.com", "3433-8336");
  //   employeeController.listAll();
  // }
}
