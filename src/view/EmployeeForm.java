package view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import business.control.EmployeeController;
import business.model.Date;
import business.model.Employee;

public class EmployeeForm {
  public void menu() {


    EmployeeController employeeController = new EmployeeController();

    Date date = new Date(1, 2, 1999);

    Scanner menu = new Scanner (System.in);
    Scanner input = new Scanner (System.in);

    while (true) {            

    System.out.print("\n\n=-=-=-=-=-=-=-=-=-=-=-=-=-= MENU =-=-=-=-=-=-=-=-=-=-=-=-=-= \n");
    System.out.print("1 - ADICIONAR EMPREGADO \n");
    System.out.print("2 - ATUALIZAR EMPREGADO \n");
    System.out.print("3 - LISTAR EMPREGADOS \n");
    System.out.print("4 - PESQUISAR EMPREGADOS \n");
    System.out.print("5 - DESFAZER ÚLTIMA ALTERAÇÃO \n");
    System.out.print("6 - GET EMPLOYEE SET \n");
    System.out.print("7 - SAIR \n");
    System.out.print("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \n");
    System.out.print("Digite uma opção: ");

    int option = menu.nextInt();

    if (option == 7) {
      System.out.print("\nbye.");
      menu.close();
      input.close();
      break;
    }

    switch (option) {
      case 1:
        System.out.println("\nAdicionar Empregado");

        employeeController.add(generateRandomEmployeeID(), "123", date, generateRandomFullname(), "Rua J", "teste@gmail.com", "9878-7543");
        break;

      case 2:
        System.out.println("\nAtualizar Empregado");

        Employee employee = new Employee("H44QW4R7J-3085", "canad", date, "Mathias Firmino Andrade", "Rua J. Sales", "teste@gmail.com", "9878-7543");
        employeeController.update(employee);
        break;

      case 3:
        System.out.println("\nListar Empregados");
        employeeController.listAll(employeeController.getEmployees());
        break;

      case 4:
        System.out.println("\nPesquisar Empregados");

        Employee employeeSearch = new Employee("default", "123", date, generateRandomFullname(), "default", "default", "default");
        System.out.println("Pesquisando: " + employeeSearch.getFullname() + " ...");
        employeeController.search(employeeSearch);
        break;

      case 5:
        System.out.println("\nDesfazer última alteração");

        employeeController.undoEmployeesUpdate();
        break;

      case 6:
        System.out.println("\nEmployee SET");

        employeeController.listAll(employeeController.getEmployeesSet());
        break;
          
      default:
          System.out.print("\nOpção inválida!");
          break;
    }}
  }

  public static String generateRandomEmployeeID() {
    int finalNumbers = 1000 + new Random().nextInt(9000);
    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"; 
    StringBuilder sb = new StringBuilder(9); 

    for (int i = 0; i < 9; i++) {  
      int index = (int)(AlphaNumericString.length() * Math.random());
      sb.append(AlphaNumericString.charAt(index)); 
    } 
    return sb.toString() + "-" + finalNumbers;
  }

  public String generateRandomFullname() {
    ArrayList<String> names = new ArrayList<String>();
    names.add("Madalena Santos");
    names.add("Mathias Firmino");
    names.add("Ana Bento de Sá");
    int index = (int)(names.size() * Math.random());

    return names.get(index);
  }
}