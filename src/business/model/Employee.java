package business.model;

import java.util.ArrayList;

public class Employee extends User {

	private static final long serialVersionUID = 1L;
	private String fullname;
	private String address;
	private String email;
	private String phone;
	private ArrayList<Salary> salaries = new ArrayList<Salary>();

	public Employee(String kindVacation, String employeeId, String password, Date birthDate, String fullname, String address, String email, String phone) {
		super(kindVacation, employeeId, password, birthDate);
		this.fullname = fullname;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	/**
	 * @return String return the fullname
	 */
	public String getFullname() {
			return fullname;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
			this.fullname = fullname;
	}

	/**
	 * @return String return the address
	 */
	public String getAddress() {
			return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
			this.address = address;
	}

	/**
	 * @return String return the email
	 */
	public String getEmail() {
			return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
			this.email = email;
	}

	/**
	 * @return String return the phone
	 */
	public String getPhone() {
			return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
			this.phone = phone;
	}

	/**
	 * @return ArrayList<Salary> return the salaries
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

	@Override
  public String toString() {
		return ("Login: " + getLogin() 
		+ " Password: " + getPassword()  
		+ " Birth date: " 
		+ getBirthDate().showDate() 
		+ " Fullname: " 
		+ getFullname() 
		+ " Address: " 
		+ getAddress()
		+ " Email: " 
		+ getEmail()
		+ "Phone: " 
		+ getPhone() 
		+ " Salary: " 
		+ getSalary());
	}

	public int compareTo(Employee employee) {
    return getLogin().compareToIgnoreCase(employee.getLogin());
	}
	
	public Boolean compareAll(Employee employee) {
    return getLogin().equals(employee.getLogin()) && getPassword().equals(employee.getPassword());
  }
}
