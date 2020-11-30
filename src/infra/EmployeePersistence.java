package infra;

import java.util.TreeSet;

import business.model.Employee;
import util.InfraException;

public class EmployeePersistence implements IPersistence<Employee>  {
  HandlePersistence<Employee> handleUserPersistence = new HandlePersistence<Employee>();

  @Override
  public TreeSet<Employee> loadUsers(String filename) throws InfraException {
    return handleUserPersistence.load(filename);
  }

  @Override
  public void saveUsers(TreeSet<Employee> users, String filename) throws InfraException {
    handleUserPersistence.save(users, filename);
  }
}
