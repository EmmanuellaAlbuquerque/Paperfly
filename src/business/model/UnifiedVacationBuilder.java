package business.model;

public class UnifiedVacationBuilder extends VacationBuilder {
    @Override
    public void buildKindVacation() {
        vacation.setKindVacation("Unificadas");
    }

    public UnifiedVacationBuilder() {
    }
}