package business.model;

public class Vacation {
    private String kindVacation;

    public String getKindVacation(){
        return kindVacation;
    }
    public void setKindVacation(String kindVacation){
        this.kindVacation = kindVacation;
    }

    public Vacation(String kindVacation) {
        this.kindVacation = kindVacation;
    }
	public Vacation() {
	}

}