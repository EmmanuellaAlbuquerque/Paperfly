package business.model;

import java.io.Serializable;

public class Date implements Serializable {

	private static final long serialVersionUID = 1L;
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
  }

	/**
	 * @return int return the day
	 */
	public int getDay() {
			return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
			this.day = day;
	}

	/**
	 * @return int return the month
	 */
	public int getMonth() {
			return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
			this.month = month;
	}

	/**
	 * @return int return the year
	 */
	public int getYear() {
			return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
			this.year = year;
	}

	public String showDate() {
			return String.format("%02d/%02d/%04d", this.day, this.month, this.year);
	}
}
