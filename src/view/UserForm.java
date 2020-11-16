package view;
import java.util.*;

import business.control.UserManager;
import business.model.User;
import infra.UserPersistence;

public class UserForm {
  public void menu() {
    HashMap<String, User> users = new HashMap<String, User>();
    HashMap<String, User> usersFile = new HashMap<String, User>();
    UserManager userManager = new UserManager(users);
    UserPersistence userPersistence = new UserPersistence();

    Scanner menu = new Scanner (System.in);
    Scanner input = new Scanner (System.in);

    while (true) {            

    System.out.print("\n\n=-=-=-=-MENU=-=-=-=\n");
    System.out.print("1 - Add Users       \n");
    System.out.print("2 - List all Users  \n");
    System.out.print("3 - Exit            \n");
    System.out.print("=-=-=-=-=-=-=-=-=-=\n");
    System.out.print("Enter an option: ");

    int option = menu.nextInt();

    if (option == 3) {
        System.out.print("\nbye.");
        menu.close();
        input.close();
        break;
    }

    switch (option) {
      case 1:
          String[] param = new String[2];
          System.out.println("\nAdd Users");
          System.out.print("Type your Login: ");
          param[0] = input.nextLine();
          System.out.print("Type your password: ");
          param[1] = input.nextLine();

          userManager.add(param);
          userPersistence.saveUsers(users);

          break;

      case 2:
        usersFile = userPersistence.loadUsers();
        UserManager userManagerFile = new UserManager(usersFile);
        userManagerFile.listAll();
        break;

      default:
          System.out.print("\nInvalid option!");
          break;
    } 
  }}
}
