package view;
import java.util.*;

import business.control.UserController;
import business.model.User;
import infra.UserPersistence;
import util.ComparatorDate;
import util.InfraException;

public class UserForm {
  public void menu() {
    TreeMap<String, User> users = new TreeMap<String, User>();
    UserController userController = new UserController();
    UserPersistence userPersistence;

    Scanner menu = new Scanner (System.in);
    Scanner input = new Scanner (System.in);

    while (true) {            

    System.out.print("\n\n=-=-=-=-=-=-=-=-=-=-=-=-=-= MENU =-=-=-=-=-=-=-=-=-=-=-=-=-= \n");
    System.out.print("1 - ADICIONAR USUÁRIOS \n");
    System.out.print("2 - LISTAR POR ORDEM ALFABÉTICA CRESCENTE  \n");
    System.out.print("3 - LISTAR POR DATA DE NASCIMENTO DESCRESCENTE \n");
    System.out.print("4 - Sair \n");
    System.out.print("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \n");
    System.out.print("Digite uma opção: ");

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
          System.out.println("\nAdicionar Usuários");
          System.out.print("Login: ");
          param[0] = input.nextLine();
          System.out.print("Senha: ");
          param[1] = input.nextLine();
          System.out.print("Dia de nascimento[DD]: ");
          param[2] = input.nextLine();
          System.out.print("Mês de nascimento[MM]: ");
          param[3] = input.nextLine();
          System.out.print("Ano do nascimento[YYYY]: ");
          param[4] = input.nextLine();

          userPersistence = new UserPersistence();

          try {
            userController = new UserController(userPersistence.loadUsers());
          } catch (InfraException e) {
            System.out.print(e.getMessage());
            // e.printStackTrace();
          }

          userController.add(param);

          try {
            userPersistence.saveUsers(userController.getUsers());
          } catch (InfraException e1) {
            System.out.print(e1.getMessage());
            // e1.printStackTrace();
          }

          break;

      case 2:
        userPersistence = new UserPersistence();
        try {
          users = userPersistence.loadUsers();
        } catch (InfraException e) {
          System.out.print(e.getMessage());
          // e.printStackTrace();
        }
        userController = new UserController(users);
        userController.listAll();
        break;

      case 3:
        userPersistence = new UserPersistence();
        TreeSet<User> usersSet = new TreeSet<User>(new ComparatorDate());
        try {
          users = userPersistence.loadUsers();
        } catch (InfraException e) {
          System.out.print(e.getMessage());
          // e.printStackTrace();
        }

        users.forEach((key, value) -> {
          usersSet.add(value);
        });

        usersSet.forEach((value) -> {
          System.out.println(value.toString());
        });
        break;

      default:
          System.out.print("\nOpção inválida!");
          break;

    } 
  }}
}
