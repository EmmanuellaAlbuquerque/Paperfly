package business.control;

import java.util.ArrayList;

import business.model.Salary;

public class SalaryController {
  private ArrayList<Salary> salaries = new ArrayList<Salary>();

  public SalaryController() {}

  public SalaryController(ArrayList<Salary> salaries) {
    this.salaries = salaries;
  }

  /**
   * @return TreeSet<Salary> return the salaries
   */
  public ArrayList<Salary> getSalaries() {
      return salaries;
  }

  /**
   * @param salaries the salaries to set
   */
  public void setSalaries(ArrayList<Salary> salaries) {
      this.salaries = salaries;
  }

  public void add(Salary salary) {
    salaries.add(salary);
  }

  public void remove(Salary salary) {
    salaries.remove(salary);
  }

  public void listAll() {
    salaries.forEach((salary) -> {
      System.out.println(salary.toString());
    });
  }
}
