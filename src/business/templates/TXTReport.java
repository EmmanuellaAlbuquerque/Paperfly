package business.templates;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import business.model.User;

public class TXTReport extends ReportTemplate {

	@Override
	public void generateReport(User user) {
    try {
      FileWriter userAcessFile = new FileWriter("user_acess_report.txt", true);
      PrintWriter recordUserAcessFile = new PrintWriter(userAcessFile);

      recordUserAcessFile.println(getAcessData(user));    
      userAcessFile.close();

      System.out.println("txt report user acess generated");

    } catch (IOException e) {
      e.printStackTrace();
    }
	}
}
