package business.model;

public class TeamManager extends User {

  private static final long serialVersionUID = 1L;

	public TeamManager(String kindVacation, String employeeId, String password, Date birthDate) {
		super(kindVacation, employeeId, password, birthDate);
	}
}
