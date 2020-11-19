package view;
import java.util.*;

import business.control.UserManager;
import business.model.User;
import infra.UserPersistence;
import util.ComparatorData;

public class UserForm {
  public void menu() {
    TreeMap<String, User> users;
    UserManager userManager;
    UserPersistence userPersistence;

    Scanner menu = new Scanner (System.in);
    Scanner input = new Scanner (System.in);

    while (true) {            

    System.out.print("\n\n=-=-=-=-MENU=-=-=-=\n");
    System.out.print("1 - Add Users       \n");
    System.out.print("2 - List all Users  \n");
    System.out.print("3 - List by descending birth date \n");
    System.out.print("4 - Exit            \n");
    System.out.print("=-=-=-=-=-=-=-=-=-=\n");
    System.out.print("Enter an option: ");

    int option = menu.nextInt();

    if (option == 4) {
        System.out.print("\nbye.");
        menu.close();
        input.close();
        break;
    }

    switch (option) {
      case 1:
          String[] param = new String[5];
          System.out.println("\nAdd Users");
          System.out.print("Type your Login: ");
          param[0] = input.nextLine();
          System.out.print("Type your password: ");
          param[1] = input.nextLine();
          System.out.print("Type the day you were born: ");
          param[2] = input.nextLine();
          System.out.print("Type the month you were born: ");
          param[3] = input.nextLine();
          System.out.print("Type the year you were born: ");
          param[4] = input.nextLine();

          userManager = new UserManager();
          userPersistence = new UserPersistence();
          userManager.add(param);
          userPersistence.saveUsers(userManager.getUsers());

          break;

      case 2:
        userPersistence = new UserPersistence();
        users = userPersistence.loadUsers();
        userManager = new UserManager(users);
        userManager.listAll();
        break;

      case 3:
        userPersistence = new UserPersistence();
        TreeSet<User> usersSet = new TreeSet<User>(new ComparatorData());
        users = userPersistence.loadUsers();

        users.forEach((key, value) -> {
          usersSet.add(value);
        });

        usersSet.forEach((value) -> {
          System.out.println(value.toString());
        });
        break;

      default:
          System.out.print("\nInvalid option!");
          break;
    } 
  }}
}
