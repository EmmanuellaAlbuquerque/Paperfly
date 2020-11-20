package util;

import business.model.User;
import java.util.Comparator;

public class ComparatorDate implements Comparator<User> {

	@Override
	public int compare(User user1, User user2) {

		int day = (user1.getBirthDate().getDay() - user2.getBirthDate().getDay());
		int month = (user1.getBirthDate().getMonth() - user2.getBirthDate().getMonth());
		int year = (user1.getBirthDate().getYear() - user2.getBirthDate().getYear());

		int result = 0;

		if (year > 0) {
			result = -1;
			if (year > 0 && month > 0 && day > 0) {
				result = -1;
			}
		}
		else {
			result = 1;
		}

		if (year == 0 && month == 0 && day > 0) {
			result = -1;
		}

		return result;
	}
}
