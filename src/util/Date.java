package util;

import java.io.Serializable;

public class Date implements Serializable {
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

		
	public boolean validaData() { 
		return true;
	}

	// ^(?:(?:31(\/|-|\.)(?:0?[13578]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)(?:0?2)\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$

	public String showDate() {
			return this.day+"/"+this.month+"/"+this.year;
	}
		
			// public static void main(String[] args) {
	// 	Data data = new Data(3,2,2016);
	// 	data.validaData();
	// 	data.mostrarData();
	// } 
}
