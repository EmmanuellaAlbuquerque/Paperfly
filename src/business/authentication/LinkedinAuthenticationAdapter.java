package business.authentication;

public class LinkedinAuthenticationAdapter extends LinkedinAuthentication implements LoginAuthentication {

	@Override
	public Boolean authenticate(String email, String password, int phone) {
    return authenticateForPhone(phone, password);
	}
}
