package util;

public class HandleUserRegistration {
  public static Boolean verifyLogin(String login) {
    Boolean tamanhoMinMax = false;
    Boolean dontContainNumber = false;

    try {

      tamanhoMinMax = login.matches("[a-zA-Z]{1,20}");
      dontContainNumber = !login.matches(".*\\d.*");

      if(!(tamanhoMinMax && dontContainNumber)){
        throw new UserLoginException();
      }
      
    } catch (UserLoginException e) {
      e.printStackTrace();
    }

    return tamanhoMinMax && dontContainNumber;
  }

  public static Boolean verifyPassword(String password) {
    Boolean checkPassword = false;

    try {
      checkPassword = password.matches("(?=(.*\\d){2})[a-zA-Z0-9]{8,12}");

      if(!checkPassword){
        throw new UserPasswordException();
      }
      
    } catch (UserPasswordException e) {
      e.printStackTrace();
    }

    return checkPassword;
  }
}
