package business.control;

import java.util.ArrayList;
import java.util.TreeSet;

import business.model.Employee;
import util.NothingToUndoMementoException;

public class EmployeesControllerCareTaker {
  protected ArrayList<EmployeesMemento> states;
  
  public EmployeesControllerCareTaker() {
    states = new ArrayList<EmployeesMemento>();
  }

  public void addMemento(EmployeesMemento employeeMemento) {
    states.add(employeeMemento);

    int i= 0;
    for(EmployeesMemento memento : states) {
      TreeSet<Employee> employees = memento.getSavedEmployeesCollection();
      System.out.println("\n(" + i + ") ----------- lastSavedMemento ------------");
      for(Employee employee : employees) {
        System.out.println(employee.toString());
      }
      System.out.println("------------------------------------\n");
      i++;
    }
  }

  public EmployeesMemento getLastSavedState() throws NothingToUndoMementoException {
    if (states.size() <= 0) {
      throw new NothingToUndoMementoException();
    }

    EmployeesMemento lastSavedMemento = states.get(states.size() - 1);
    states.remove(states.size() - 1);

    return lastSavedMemento;
  }
}
