package infra;

import business.model.Employee;

public class EmployeePersistenceFactory implements PersistenceFactory<Employee> {

  @Override
	public IPersistence<Employee> createPersistence() {
    return new EmployeePersistence();
	}
}
