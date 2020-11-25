package business.templates;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import business.model.User;

public class HTMLReport extends ReportTemplate {

  @Override
  public void generateReport(User user) {
    try {
      FileWriter userAcessFile = new FileWriter("user_acess_report.html");
      PrintWriter recordUserAcessFile = new PrintWriter(userAcessFile);
      List<String> lines = Files.readAllLines(Paths.get("user_acess_report.txt"), StandardCharsets.UTF_8);

      recordUserAcessFile.println("<!DOCTYPE html>");
      recordUserAcessFile.println("<html lang=\"en\">");
      recordUserAcessFile.println("<head>");
      recordUserAcessFile.println("<meta charset=\"UTF-8\">");
      recordUserAcessFile.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
      recordUserAcessFile.println("<title>Relatório User Acess Paperfly</title>");
      recordUserAcessFile.println("</head>");
      recordUserAcessFile.println("<body>");
      recordUserAcessFile.println("<h1>"+getTitle()+"</h1>");

      for (String line : lines) {
        recordUserAcessFile.println("<ul>");
        recordUserAcessFile.println("<li>"+line+"</li>");
        recordUserAcessFile.println("</ul>");
      }

      recordUserAcessFile.println("</body>");
      recordUserAcessFile.println("</html>");
   
      userAcessFile.close();
      System.out.println("txt report user acess generated");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
