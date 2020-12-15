package business.model;

import java.util.ArrayList;

public class CalculateBonusDecrease implements CalculateBonus {

  public CalculateBonusDecrease() {
    
  }

  @Override
	public double CalculateBankOfHoursBonus(Employee employee) {
    ArrayList<Salary> salaries;
    if (employee.getSalaries().size() > 0) {
      salaries = employee.getSalaries();
      int index = salaries.size() - 1;
      Salary salary = salaries.get(index);
      if (catchMissingHours(salary.getPrice())) {
        return calculatesPercentage(salary);
      }
    }
    else {
      salaries = new ArrayList<Salary>();
    }
		return 0;
  }
  
  private Boolean catchMissingHours(double price) {
    // Calculate Bank Of Hours Bonus for missing hours
    return true;
  }

  private double calculatesPercentage(Salary salary) {
    return salary.getPrice() * -0.10;
  }
}
