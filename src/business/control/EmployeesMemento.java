package business.control;

import java.util.TreeSet;

import business.model.Employee;

public class EmployeesMemento {
  protected TreeSet<Employee> employeesState;

  public EmployeesMemento(TreeSet<Employee> employees) {
    employeesState = employees;
  }

  public TreeSet<Employee> getSavedEmployeesCollection() {
	  return employeesState;
  }
}
