package business.model;

/**
 * Human Resources Manager
 */
public class HRManager extends User {

  private static final long serialVersionUID = 1L;

	public HRManager(String employeeId, String password, Date birthDate) {
		super(employeeId, password, birthDate);
	}
}
