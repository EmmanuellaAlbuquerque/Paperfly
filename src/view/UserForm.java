package view;
import java.util.*;

import business.control.CompanyFacade;
import business.model.Salary;

public class UserForm {
  public void menu() {
    CompanyFacade companyFacade = CompanyFacade.getInstance();

    Scanner menu = new Scanner (System.in);
    Scanner input = new Scanner (System.in);

    while (true) {            

    System.out.print("\n\n=-=-=-=-=-=-=-=-=-=-=-=-=-= MENU =-=-=-=-=-=-=-=-=-=-=-=-=-= \n");
    System.out.print("1 - ADICIONAR USUÁRIOS \n");
    System.out.print("2 - REMOVER USUÁRIO \n");
    System.out.print("3 - LISTAR POR ORDEM ALFABÉTICA CRESCENTE  \n");
    System.out.print("4 - LISTAR POR DATA DE NASCIMENTO DESCRESCENTE \n");
    System.out.print("5 - REGISTRAR SALÁRIO DE UM USUÁRIO \n");
    System.out.print("6 - SAIR \n");
    System.out.print("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \n");
    System.out.print("Digite uma opção: ");

    int option = menu.nextInt();

    if (option == 6) {
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
          param[0] = input.next();
          System.out.print("Senha: ");
          param[1] = input.next();
          System.out.print("Dia de nascimento[DD]: ");
          param[2] = input.next();
          System.out.print("Mês de nascimento[MM]: ");
          param[3] = input.next();
          System.out.print("Ano do nascimento[YYYY]: ");
          param[4] = input.next();

          companyFacade.addUsers(param);
          break;

      case 2:
        String login;
        System.out.println("\nRemover usuário");
        System.out.print("Login: ");
        login = input.next();
        companyFacade.removeUsers(login);
        break;

      case 3:
        companyFacade.listAllAlphabetical();
        break;

      case 4:
        companyFacade.listAllByBirthDate();
        break;

      case 5:
        String userlogin;
        double price;
        int yearsOfWork;
        System.out.println("\nRegistrar salário");
        System.out.print("Login: ");
        userlogin = input.next();
        System.out.print("Preço: ");
        price = input.nextDouble();
        System.out.print("Anos de trabalho: ");
        yearsOfWork = input.nextInt();
        Salary salary = new Salary(price, yearsOfWork);
        companyFacade.registerNewSalary(userlogin, salary);
        break;

      default:
          System.out.print("\nOpção inválida!");
          break;

    } 
  }}
}
