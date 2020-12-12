package business.model;

public class TeamManager extends User {

  private static final long serialVersionUID = 1L;

	public TeamManager(Vacation vac, String employeeId, String password, Date birthDate) {
		super(employeeId, password, birthDate, vac);
	}
}
