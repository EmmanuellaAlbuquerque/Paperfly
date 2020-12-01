package business.control;

import business.model.Salary;
import business.model.User;

public class CompanyFacade {
  public static CompanyFacade instance;
  protected UserController userController;
  protected SalaryController salaryController;

  protected CompanyFacade() {
    userController = new UserController();
    salaryController = new SalaryController();
  }

  public static CompanyFacade getInstance() {
    if (instance == null) {
      instance = new CompanyFacade();
    }

    return instance;
  }

  public void addUsers(String[] param) {
    userController.add(param);
  }

  public void removeUsers(String login) {
    userController.del(login);
  }

  public void registerNewSalary(String login, Salary salary) {
    User user = userController.containsLogin(login);
    if (user != null) {
      if (user.getSalary() != null) {
        user.getSalary().forEach((historySalary) -> {
          salaryController.add(historySalary);
        });
      }
      salaryController.add(salary);
      salaryController.listAll();
      user.setSalary(salaryController.getSalaries());
      userController.getDbConnection().saveInDatabase(userController.getUsers(), "database-users.bin");
    }
    else {
      System.out.println("Usuário não existe");
    }
  }

  public void listAllAlphabetical() {
    userController.listAllAlphabetical();
  }

  public void listAllByBirthDate() {
    userController.listAllByBirthDate();
  }
}
