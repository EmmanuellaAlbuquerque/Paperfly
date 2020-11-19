package view;
import java.util.*;

import business.control.UserController;

public class UserForm {
  public void menu() {
    UserController userController = new UserController();

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

          userController.add(param);
          break;

      case 2:
          userController.listAllAlphabetical();
        break;

      case 3:
        userController.listAllByBirthDate();
        break;

      default:
          System.out.print("\nOpção inválida!");
          break;

    } 
  }}
}
