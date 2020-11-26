package business.model;

public class Salary {
  private double price;
	private int yearsOfWork;
	
	public Salary(double price, int yearsOfWork) {
		this.price = price;
		this.yearsOfWork = yearsOfWork;
	}
  
	/**
	 * @return double return the price
	 */
	public double getPrice() {
			return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
			this.price = price;
	}

	/**
	 * @return int return the yearsOfWork
	 */
	public int getYearsOfWork() {
			return yearsOfWork;
	}

	/**
	 * @param yearsOfWork the yearsOfWork to set
	 */
	public void setYearsOfWork(int yearsOfWork) {
			this.yearsOfWork = yearsOfWork;
	}

	@Override
  public String toString() {
    return ("Price: " + getPrice() + " YearsOfWork: " + getYearsOfWork());
  }
}
