package business.model;

import java.util.ArrayList;

public class CalculateBonusIncrease implements CalculateBonus {

	@Override
	public double CalculateBankOfHoursBonus(Employee employee) {
    ArrayList<Salary> salaries = employee.getSalaries();
    int index = salaries.size();
    Salary salary = salaries.get(index);
    if (catchOvertime(salary.getPrice())) {
        return salary.getPrice() * 0.85;
    }
		return 0;
  }
  
  private Boolean catchOvertime(double price) {
    // Calculate Bank Of Hours Bonus for overtime
    return true;
  }
}
