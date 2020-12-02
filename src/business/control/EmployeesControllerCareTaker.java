package business.control;

import java.util.ArrayList;
import java.util.TreeSet;

import business.model.Employee;

public class EmployeesControllerCareTaker {
  protected ArrayList<EmployeesMemento> states;
  
  public EmployeesControllerCareTaker() {
    states = new ArrayList<EmployeesMemento>();
  }

  public void addMemento(EmployeesMemento employeeMemento) {
    states.add(employeeMemento);
  }

  public EmployeesMemento getLastSavedState() {
    if (states.size() <= 0) {
      System.out.println("all possible undoes have been undone");
      return new EmployeesMemento(new TreeSet<Employee>());
    }
    EmployeesMemento lastSavedMemento = states.get(states.size() - 1);
    states.remove(states.size() - 1);
    return lastSavedMemento;
  }
}
