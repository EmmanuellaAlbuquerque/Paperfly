package business.authentication;

public class GmailAuthenticationAdapter extends GmailAuthentication implements LoginAuthentication {

	@Override
	public Boolean authenticate(String email, String password, int phone) {
		return verifyAuthenticity(email, password);
	}
}
