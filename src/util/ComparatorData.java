package util;

import business.model.User;
import java.util.Comparator;

// EXIBIR USUÁRIOS ORDENADOS POR DATA DE NASCIMENTO DESCRESCENTE.
public class ComparatorData implements Comparator<User> {

	@Override
	public int compare(User user1, User user2) {
    return user2.getBirthDate().getYear() - user1.getBirthDate().getYear();
	}
}
