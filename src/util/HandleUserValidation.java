package util;

import business.model.Date;

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
      throw e;
    }

    return checkPassword;
  }

  public static Boolean verifyDate(Date date) throws DateFormatException {
    Boolean checkDate = false;

    try {
      checkDate = validateDate(date.showDate());

      if(!checkDate){
        throw new DateFormatException();
      }
      
    } catch (DateFormatException e) {
      throw e;
    }

    return checkDate;
  }

  private static Boolean validateDate(String dateformat) { 
		return dateformat.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)(?:0?2)\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
	}
}
