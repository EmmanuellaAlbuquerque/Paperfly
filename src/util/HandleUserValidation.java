package util;

public class HandleUserValidation {
  public static Boolean verifyLogin(String login) throws UserLoginException {
    Boolean tamanhoMinMax = false;
    Boolean dontContainNumber = false;

    try {

      tamanhoMinMax = login.matches("[a-zA-Z]{1,20}");
      dontContainNumber = !login.matches(".*\\d.*");

      if(!(tamanhoMinMax && dontContainNumber)){
        throw new UserLoginException();
      }
      
    } catch (UserLoginException e) {
      // e.printStackTrace();
      // System.out.println(e.getMessage());
      throw e;
    }

    return tamanhoMinMax && dontContainNumber;
  }

  public static Boolean verifyPassword(String password) throws UserPasswordException {
    Boolean checkPassword = false;

    try {
      checkPassword = password.matches("(?=(.*\\d){2})[a-zA-Z0-9]{8,12}");

      if(!checkPassword){
        throw new UserPasswordException();
      }
      
    } catch (UserPasswordException e) {
      // e.printStackTrace();
      // System.out.println(e.getMessage());
      throw e;
    }

    return checkPassword;
  }
}
