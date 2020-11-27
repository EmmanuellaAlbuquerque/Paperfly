package business.authentication;

public interface LoginAuthentication {
  public Boolean authenticate(String email, String password, int phone);
}
