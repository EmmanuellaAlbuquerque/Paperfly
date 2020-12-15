package business.model;

public abstract class VacationBuilder {
    protected Vacation vacation;

    public VacationBuilder(){
        vacation = new Vacation();
    }
    public abstract void buildKindVacation();
	public Vacation getVacation() {
		return vacation;
    }
    
}