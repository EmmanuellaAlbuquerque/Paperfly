package business.model;

public class DividedVacationBuilder extends VacationBuilder {
    
    @Override
    public void buildKindVacation() {
        vacation.setKindVacation("Divididas");
    }

    public DividedVacationBuilder() {
    }
}