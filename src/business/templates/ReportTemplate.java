package business.templates;

import java.util.Calendar;
import business.model.User;

/**
 * Template de geração de relatórios.
 */
public abstract class ReportTemplate {

  public final String getTitle() {
    return "Empresa Paperfly\n - Relatório de acesso dos usuários ao sistema\n";
  }

  public abstract void generateReport(User user);

  public String getAcessData(User user) {
    Calendar calendar = Calendar.getInstance();
    int hourAcess = calendar.get(Calendar.HOUR_OF_DAY); 
    int minuteAcess = calendar.get(Calendar.MINUTE);
    int dayAcess = calendar.get(Calendar.DAY_OF_MONTH);
    int monthAcess = calendar.get(Calendar.MONTH) + 1;
    int yearAcess = calendar.get(Calendar.YEAR);

    return "Usuário: " + user.getLogin() + " - Hora de Acesso " + hourAcess + ":" + minuteAcess + " - Data de Acesso: " + dayAcess + "/" + monthAcess + "/" + yearAcess;
  }
}
